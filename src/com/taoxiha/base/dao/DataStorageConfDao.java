package com.taoxiha.base.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.taoxiha.base.BaseSpringJdbcDao;
import com.taoxiha.base.model.DataStorageConf;
import com.taoxiha.base.query.DataStorageConfQuery;
import com.taoxiha.common.page.Page;
import static com.taoxiha.common.util.ObjectUtils.*;


@Repository
public class DataStorageConfDao extends BaseSpringJdbcDao<DataStorageConf,java.lang.Integer>{
	
	public Class getEntityClass() {
		return DataStorageConf.class;
	}
	
	public void save(DataStorageConf entity) {
		String sql = getSqlGenerator().getInsertSql();
		insertWithGeneratedKey(entity,sql);
	}
	
	public Page findPage(DataStorageConfQuery query) {
		StringBuilder sql = new StringBuilder("select * from  ").append(DataStorageConf.TABLE_NAME).append("  t where 1=1 ");
		if(isNotEmpty(query.getId())) {
            sql.append(" and t.id = :id ");
        }
		if(isNotEmpty(query.getStorageConfNum())) {
            sql.append(" and t.storage_conf_num = :storageConfNum ");
        }
		if(isNotEmpty(query.getStorageType())) {
            sql.append(" and t.storage_type = :storageType ");
        }
		if(isNotEmpty(query.getStorageRule())) {
            sql.append(" and t.storage_rule = :storageRule ");
        }
		if(isNotEmpty(query.getStoragePath())) {
            sql.append(" and t.storage_path = :storagePath ");
        }
		if(isNotEmpty(query.getStorageFormat())) {
            sql.append(" and t.storage_format = :storageFormat ");
        }
		if(isNotEmpty(query.getFilterWords())) {
            sql.append(" and t.filter_words = :filterWords ");
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
		if(isNotEmpty(query.getMemo())) {
            sql.append(" and t.memo = :memo ");
        }
		if(isNotEmpty(query.getSort())) {
            sql.append(" order by ").append(query.getSort());
        }
		
		return pageQuery(sql.toString(),query);
	}
	
	public DataStorageConf getByStorageConfNum(java.lang.String v) {
		String sql = "select * from  ".concat(DataStorageConf.TABLE_NAME).concat("  t where t.storage_conf_num=:key");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("key", v);
		return getEntityBySql(sql, map);
	}	
	
	

}
