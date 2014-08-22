package com.taoxiha.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javacommon.xsqlbuilder.SafeSqlProcesserFactory;
import javacommon.xsqlbuilder.XsqlBuilder;
import javacommon.xsqlbuilder.XsqlBuilder.XsqlFilterResult;
import javacommon.xsqlbuilder.safesql.DirectReturnSafeSqlProcesser;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.incrementer.AbstractSequenceMaxValueIncrementer;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;

import com.taoxiha.common.jdbc.dialect.Dialect;
import com.taoxiha.common.jdbc.sqlgenerator.CacheSqlGenerator;
import com.taoxiha.common.jdbc.sqlgenerator.SpringNamedSqlGenerator;
import com.taoxiha.common.jdbc.sqlgenerator.SqlGenerator;
import com.taoxiha.common.jdbc.sqlgenerator.metadata.Column;
import com.taoxiha.common.jdbc.sqlgenerator.metadata.MetadataCreateUtils;
import com.taoxiha.common.jdbc.sqlgenerator.metadata.Table;
import com.taoxiha.common.jdbc.support.OffsetLimitResultSetExtractor;
import com.taoxiha.common.page.Page;
import com.taoxiha.common.page.PageRequest;
import com.taoxiha.common.util.CollectionHelper;
import com.taoxiha.common.util.ObjectUtils;
import com.taoxiha.common.util.SqlRemoveUtils;
/**
 * Spring的JDBC基类
 * 
 */
public abstract class BaseSpringJdbcDao<E,PK extends Serializable> extends JdbcDaoSupport implements EntityDao<E,PK>{

	protected final Log log = LogFactory.getLog(getClass());

	protected SimpleJdbcTemplate simpleJdbcTemplate;
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	Table table = MetadataCreateUtils.createTable(getEntityClass());
	SqlGenerator sqlGenerator = new CacheSqlGenerator(new SpringNamedSqlGenerator(table));
	
	public abstract Class<E> getEntityClass();
	
	private Dialect dialect;
	
	public void setDialect(Dialect d) {
		this.dialect = d;
	}
	
	protected void checkDaoConfig() {
		super.checkDaoConfig();
		if(dialect == null) throw new IllegalStateException("'dialect' property must be not null");
		log.info("use jdbc dialect:"+dialect);
		simpleJdbcTemplate = new SimpleJdbcTemplate(getJdbcTemplate());
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate());
	}
	
	public SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}
	
	public Object getIdentifierPropertyValue(Object entity) {
		try {
			return PropertyUtils.getProperty(entity, getIdentifierPropertyName());
		} catch (Exception e) {
			throw new IllegalStateException("cannot get property value on entityClass:"+entity.getClass()+" by propertyName:"+getIdentifierPropertyName(),e);
		}
	}
	
	public void setIdentifierProperty(Object entity, Object id) {
		try {
			BeanUtils.setProperty(entity, getIdentifierPropertyName(), id);
		} catch (Exception e) {
			throw new IllegalStateException("cannot set property value:"+id+" on entityClass:"+entity.getClass()+" by propertyName:"+getIdentifierPropertyName(),e);
		}
	}
	
	/**
	 * 得到全部数据,但执行分页
	 * @param pageRequest
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Page findAll(String tableName,final PageRequest pageRequest) {
		return pageQuery("select * from "+tableName+" /~ order by [sortColumns] ~/",pageRequest);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page pageQuery(String query,PageRequest pageRequest) {
		return pageQuery(query,pageRequest,new BeanPropertyRowMapper(getEntityClass()), "select count(1) ");
	}
	
	@SuppressWarnings("rawtypes")
	public Page pageQuery(String query,PageRequest pageRequest,RowMapper rowMapper, String countQuerySelectPrefix) {
		String countQuery = countQuerySelectPrefix + SqlRemoveUtils.removeSelect(query);
		return pageQuery(query,countQuery,pageRequest,rowMapper);
	}
	
	@SuppressWarnings("rawtypes")
	public Page pageQuery(String query,PageRequest pageRequest,String countQueryPrefix,RowMapper rowMapper) {
		String countQuery = countQueryPrefix + SqlRemoveUtils.removeSelect(query);
		return pageQuery(query,countQuery,pageRequest,rowMapper);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page pageQuery(String query,String countQuery,final PageRequest pageRequest,RowMapper rowMapper) {
		final int totalCount = queryTotalCount(countQuery,pageRequest);
		
		Map otherFilters = new HashMap();
		otherFilters.put("sortColumns", pageRequest.getSortColumns());
		
		//混合使用otherFilters与pageRequest.getFilters()为一个filters使用
		XsqlFilterResult queryXsqlResult = getXsqlBuilder().generateHql(query,otherFilters,pageRequest);
		String sql = queryXsqlResult.getXsql();
//		Map acceptedFilters = queryXsqlResult.getAcceptedFilters();
		int pageSize = pageRequest.getPageSize();
		int pageNumber = pageRequest.getPageNumber();
				Page page=null;
				try {
					page=pageQuery(sql, com.taoxiha.common.beanutils.PropertyUtils.describe(pageRequest), totalCount, pageSize, pageNumber,rowMapper);
				} catch (Exception e) {
					e.printStackTrace();
					com.taoxiha.common.utils.log.LogUtils.error(e.getMessage());
				}
				return page; 
	}

	protected XsqlBuilder getXsqlBuilder() {
//		XsqlBuilder builder = new XsqlBuilder();
		XsqlBuilder builder = new XsqlBuilder(SafeSqlProcesserFactory.getMysql());
		if(builder.getSafeSqlProcesser().getClass() == DirectReturnSafeSqlProcesser.class) {
			System.err.println("BaseSpringJdbcDao.getXsqlBuilder(): 故意报错,你未开启Sql安全过滤,单引号等转义字符在拼接sql时需要转义,不然会导致Sql注入攻击的安全问题，请修改源码使用new XsqlBuilder(SafeSqlProcesserFactory.getDataBaseName())开启安全过滤");
		}
		return builder;
	}

	private int queryTotalCount(String countQuery,Object filtersObject) {
		XsqlFilterResult countQueryXsqlResult = getXsqlBuilder().generateHql(countQuery,filtersObject);
		String removedOrderByQuery = SqlRemoveUtils.removeOrders(countQueryXsqlResult.getXsql());
		final int totalCount = getNamedParameterJdbcTemplate().queryForInt(removedOrderByQuery,new BeanPropertySqlParameterSource(filtersObject));
		return totalCount;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Page pageQuery(String sql, Map paramMap, final int totalCount,int pageSize, int pageNumber, RowMapper rowMapper) {
		if(totalCount <= 0) {
			return new Page(pageNumber,pageSize,0);
		}
		Page page = new Page(pageNumber,pageSize,totalCount);
		List list = pageQuery(sql, paramMap,page.getFirstResult(),pageSize,rowMapper);
		page.setResult(list);
		return page;
	}

	static final String LIMIT_PLACEHOLDER = ":__limit";
	static final String OFFSET_PLACEHOLDER = ":__offset";
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List pageQuery(String sql, final Map paramMap, int startRow,int pageSize, final RowMapper rowMapper) {
		//支持limit查询
		if(dialect.supportsLimit()) {
			paramMap.put(LIMIT_PLACEHOLDER.substring(1), pageSize);
			
			//支持limit及offset.则完全使用数据库分页
			if(dialect.supportsLimitOffset()) {
				paramMap.put(OFFSET_PLACEHOLDER.substring(1), startRow);
				sql = dialect.getLimitString(sql,startRow,OFFSET_PLACEHOLDER,pageSize,LIMIT_PLACEHOLDER);
				startRow = 0;
			}else {
				//不支持offset,则在后面查询中使用游标配合limit分页
				sql = dialect.getLimitString(sql, 0,null, pageSize,LIMIT_PLACEHOLDER);
			}
			
			pageSize = Integer.MAX_VALUE;
		}
		return (List)getNamedParameterJdbcTemplate().query(sql, paramMap, new OffsetLimitResultSetExtractor(startRow,pageSize,rowMapper));
	}
	
	/**
	 * 适用sqlserver,mysql 自动生成主键
	 */
	protected void insertWithGeneratedKey(Object entity, String insertSql) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(insertSql, new BeanPropertySqlParameterSource(entity) , keyHolder);
		setIdentifierProperty(entity, keyHolder.getKey().longValue());
	}

	protected void insertWithSequence(Object entity,AbstractSequenceMaxValueIncrementer sequenceIncrementer,String insertSql) {
		Long id = sequenceIncrementer.nextLongValue();
		setIdentifierProperty(entity, id);
		getNamedParameterJdbcTemplate().update(insertSql, new BeanPropertySqlParameterSource(entity));
	}
	
	protected void insertWithOracleSequence(Object entity,String sequenceName,String insertSql) {
		insertWithSequence(entity, new OracleSequenceMaxValueIncrementer(getDataSource(),sequenceName), insertSql);
	}
	
	protected Long insertAndReturnId(Object entity,AbstractSequenceMaxValueIncrementer sequenceIncrementer,String insertSql) {
		Long id = sequenceIncrementer.nextLongValue();
		setIdentifierProperty(entity, id);
		getNamedParameterJdbcTemplate().update(insertSql, new BeanPropertySqlParameterSource(entity));
		return id;
	}
	
	
	
	protected void insertWithUUID(Object entity,String insertSql) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		setIdentifierProperty(entity, uuid);
		getNamedParameterJdbcTemplate().update(insertSql, new BeanPropertySqlParameterSource(entity));
	}
	
	public void flush() {
		//ignore
	}
	
	public boolean isUnique(E entity, String uniquePropertyNames) {
		throw new UnsupportedOperationException();
	}
	
	@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	public E getById(PK id) {
		List list = null;
		if(getSqlGenerator().getTable().getPrimaryKeyCount() > 1) {
			list = getNamedParameterJdbcTemplate().query(getSqlGenerator().getSelectByPkSql(), new BeanPropertySqlParameterSource(id), new BeanPropertyRowMapper(getEntityClass()));
		}else if(getSqlGenerator().getTable().getPrimaryKeyCount() == 1){
			list = getSimpleJdbcTemplate().query(getSqlGenerator().getSelectByPkSql(), ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), id);
		}else {
			throw new IllegalStateException("not found primary key on table:"+getSqlGenerator().getTable().getTableName());
		}
		return (E)CollectionHelper.findSingleObject(list);
	}

	public void deleteById(PK id) {
		if(getSqlGenerator().getTable().getPrimaryKeyCount() > 1) {
			getNamedParameterJdbcTemplate().update(getSqlGenerator().getDeleteByPkSql(),new BeanPropertySqlParameterSource(id));
		}else if(getSqlGenerator().getTable().getPrimaryKeyCount() == 1){
			getSimpleJdbcTemplate().update(getSqlGenerator().getDeleteByPkSql(), id);
		}else {
			throw new IllegalStateException("not found primary key on table:"+getSqlGenerator().getTable().getTableName());
		}
	}
	
	public void saveOrUpdate(E entity) {
		Object id = getIdentifierPropertyValue(entity);
		if(ObjectUtils.isNullOrEmptyString(id)) {
			save(entity);
		}else {
			update(entity);
		}
	}
	public void update(E entity) {
		String sql = getSqlGenerator().getUpdateByPkSql();
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public void updateBySql(String sql,E entity) {
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public void batchUpdate(String sql,List<E> list){
		 List<BeanPropertySqlParameterSource> userSourceList = new ArrayList<BeanPropertySqlParameterSource>();       
		   for (E e: list) {
		         userSourceList.add(new BeanPropertySqlParameterSource(e));
	       }
		 BeanPropertySqlParameterSource[] beanSources  =  userSourceList.toArray(new BeanPropertySqlParameterSource[userSourceList.size()]);
		getNamedParameterJdbcTemplate().batchUpdate(sql, beanSources);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<E> findAll() {
		String sql = "SELECT * FROM " + getSqlGenerator().getTable().getTableName();
		return getNamedParameterJdbcTemplate().query(sql, new HashMap(), ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}
	
	/**
	 * 查询对象集合 
	 * @param sql 采用占位符:
	 * @param obj 传入object数组
	 * @return List<Entity>
	 */
	
	@SuppressWarnings("unchecked")
	public List<E> getListEntityBySql(String sql,Object obj){
		List<E> list= getNamedParameterJdbcTemplate().query(sql, new BeanPropertySqlParameterSource(obj), ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
		if(list.isEmpty()){
			return null;
		}
		return list;
	}
	
	/**
	 * 查询单个对象
	 * @param sql 查询语句 命名参数 采用占位符":"  sql="select * from enterprise where id = :id"
	 * @param map 
	 * @return Entity
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public E getEntityBySql(String sql,Map map){
		if(map == null)
			map = new HashMap();
		List<E> list= getNamedParameterJdbcTemplate().query(sql, map, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}
	
	/**
	 * 查询对象集合
	 * @param sql 采用占位符":" sql="select * from enterprise where id = :id"
	 * @param map
	 * @return List<Entity>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<E> getListEntityBySql(String sql,Map map){
		if(map == null)
			map = new HashMap();
		List<E> list= getNamedParameterJdbcTemplate().query(sql, map, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
		if(list.isEmpty()){
			return null;
		}
		return list;
	}
	
	/**
	 * 得到生成增删改查的sql生成工具
	 * @return
	 */
	public SqlGenerator getSqlGenerator() {
		return sqlGenerator;
	}
	
	public String getIdentifierPropertyName() {
		List<Column> primaryKeyColumns = getSqlGenerator().getTable().getPrimaryKeyColumns();
		if(primaryKeyColumns.isEmpty()) {
			throw new IllegalStateException("not found primary key on table:"+getSqlGenerator().getTable().getTableName());
		}
		return primaryKeyColumns.get(0).getPropertyName();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Integer updateOrDeleteOrInertBySQLAndMap(String sql, Map map){
		if(map == null){
			map = new HashMap();
		}
		return getSimpleJdbcTemplate().update(sql.toString(), map);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Integer queryForIntBySql(String sql, Map map){
		if(map == null){
			map = new HashMap();
		}
		Integer result;
		try{
			result = getSimpleJdbcTemplate().queryForInt(sql, map);
		}catch(org.springframework.dao.EmptyResultDataAccessException e){
			result = null;
		}
		return result;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Long queryForLongBySql(String sql, Map map){
		if(map == null){
			map = new HashMap();
		}
		Long result;
		try{
			result = getSimpleJdbcTemplate().queryForLong(sql, map);
		}catch(org.springframework.dao.EmptyResultDataAccessException e){
			result = null;
		}
		return result;
	}

}
