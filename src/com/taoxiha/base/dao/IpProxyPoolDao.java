package com.taoxiha.base.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.taoxiha.base.BaseSpringJdbcDao;
import com.taoxiha.base.model.IpProxyPool;
import com.taoxiha.base.query.IpProxyPoolQuery;
import com.taoxiha.common.page.Page;
import static com.taoxiha.common.util.ObjectUtils.*;


@Repository
public class IpProxyPoolDao extends BaseSpringJdbcDao<IpProxyPool,java.lang.Integer>{
	
	public Class getEntityClass() {
		return IpProxyPool.class;
	}
	
	public void save(IpProxyPool entity) {
		String sql = getSqlGenerator().getInsertSql();
		insertWithGeneratedKey(entity,sql);
	}
	
	public Page findPage(IpProxyPoolQuery query) {
		StringBuilder sql = new StringBuilder("select * from  ").append(IpProxyPool.TABLE_NAME).append("  t where 1=1 ");
		if(isNotEmpty(query.getId())) {
            sql.append(" and t.id = :id ");
        }
		if(isNotEmpty(query.getProxyIp())) {
            sql.append(" and t.proxy_ip = :proxyIp ");
        }
		if(isNotEmpty(query.getProxyAccount())) {
            sql.append(" and t.proxy_account = :proxyAccount ");
        }
		if(isNotEmpty(query.getProxyPwd())) {
            sql.append(" and t.proxy_pwd = :proxyPwd ");
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
		if(isNotEmpty(query.getMemo())) {
            sql.append(" and t.memo = :memo ");
        }
		if(isNotEmpty(query.getSort())) {
            sql.append(" order by ").append(query.getSort());
        }
		
		return pageQuery(sql.toString(),query);
	}
	
	public IpProxyPool getByProxyIp(java.lang.String v) {
		String sql = "select * from  ".concat(IpProxyPool.TABLE_NAME).concat("  t where t.proxy_ip=:key");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("key", v);
		return getEntityBySql(sql, map);
	}	
	
	

}
