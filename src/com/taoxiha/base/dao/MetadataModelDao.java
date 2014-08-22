package com.taoxiha.base.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import static com.taoxiha.common.util.ObjectUtils.*;
import com.taoxiha.base.BaseSpringJdbcDao;
import com.taoxiha.base.model.MetadataModel;
import com.taoxiha.base.query.MetadataModelQuery;
import com.taoxiha.common.page.Page;


@Repository
public class MetadataModelDao extends BaseSpringJdbcDao<MetadataModel,java.lang.Integer>{
	
	public Class getEntityClass() {
		return MetadataModel.class;
	}
	
	public void save(MetadataModel entity) {
		String sql = getSqlGenerator().getInsertSql();
		insertWithGeneratedKey(entity,sql);
	}
	
	public Page findPage(MetadataModelQuery query) {
		StringBuilder sql = new StringBuilder("select * from  ").append(MetadataModel.TABLE_NAME).append("  t where 1=1 ");
		if(isNotEmpty(query.getId())) {
            sql.append(" and t.id = :id ");
        }
		if(isNotEmpty(query.getMetadataModelNum())) {
            sql.append(" and t.metadata_model_num = :metadataModelNum ");
        }
		if(isNotEmpty(query.getModelName())) {
            sql.append(" and t.model_name = :modelName ");
        }
		if(isNotEmpty(query.getModelDesc())) {
            sql.append(" and t.model_desc = :modelDesc ");
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
	
	public MetadataModel getByMetadataModelNum(java.lang.String v) {
		String sql = "select * from  ".concat(MetadataModel.TABLE_NAME).concat("  t where t.metadata_model_num=:key");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("key", v);
		return getEntityBySql(sql, map);
	}	
	
	

}
