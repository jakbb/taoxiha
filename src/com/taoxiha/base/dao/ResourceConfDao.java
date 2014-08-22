package com.taoxiha.base.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import static com.taoxiha.common.util.ObjectUtils.*;
import com.taoxiha.base.BaseSpringJdbcDao;
import com.taoxiha.base.model.ResourceConf;
import com.taoxiha.base.query.ResourceConfQuery;
import com.taoxiha.common.page.Page;


@Repository
public class ResourceConfDao extends BaseSpringJdbcDao<ResourceConf,java.lang.Integer>{
	
	public Class getEntityClass() {
		return ResourceConf.class;
	}
	
	public void save(ResourceConf entity) {
		String sql = getSqlGenerator().getInsertSql();
		insertWithGeneratedKey(entity,sql);
	}
	
	public Page findPage(ResourceConfQuery query) {
		StringBuilder sql = new StringBuilder("select * from  ").append(ResourceConf.TABLE_NAME).append("  t where 1=1 ");
		if(isNotEmpty(query.getId())) {
            sql.append(" and t.id = :id ");
        }
		if(isNotEmpty(query.getResourceConfNum())) {
            sql.append(" and t.resource_conf_num = :resourceConfNum ");
        }
		if(isNotEmpty(query.getResourceName())) {
            sql.append(" and t.resource_name = :resourceName ");
        }
		if(isNotEmpty(query.getResourceDesc())) {
            sql.append(" and t.resource_desc = :resourceDesc ");
        }
		if(isNotEmpty(query.getStatus())) {
            sql.append(" and t.status = :status ");
        }
		if(isNotEmpty(query.getCreateTimeBegin())) {
		    sql.append(" and t.create_time >= :createTimeBegin ");
		}
		if(isNotEmpty(query.getCreateTimeEnd())) {
            sql.append(" and t.create_time <= :createTimeEnd ");
        }
		if(isNotEmpty(query.getUpdateTimeBegin())) {
		    sql.append(" and t.update_time >= :updateTimeBegin ");
		}
		if(isNotEmpty(query.getUpdateTimeEnd())) {
            sql.append(" and t.update_time <= :updateTimeEnd ");
        }
		if(isNotEmpty(query.getSort())) {
            sql.append(" order by ").append(query.getSort());
        }
		
		return pageQuery(sql.toString(),query);
	}
	
	public ResourceConf getByResourceConfNum(java.lang.String v) {
		String sql = "select * from  ".concat(ResourceConf.TABLE_NAME).concat("  t where t.resource_conf_num=:key");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("key", v);
		return getEntityBySql(sql, map);
	}	
	
	

}
