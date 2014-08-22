package com.taoxiha.base.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.taoxiha.base.BaseSpringJdbcDao;
import com.taoxiha.base.model.Metadata;
import com.taoxiha.base.query.MetadataQuery;
import com.taoxiha.common.page.Page;
import static com.taoxiha.common.util.ObjectUtils.*;


@Repository
public class MetadataDao extends BaseSpringJdbcDao<Metadata,java.lang.Integer>{
	
	public Class getEntityClass() {
		return Metadata.class;
	}
	
	public void save(Metadata entity) {
		String sql = getSqlGenerator().getInsertSql();
		insertWithGeneratedKey(entity,sql);
	}
	
	public Page findPage(MetadataQuery query) {
		StringBuilder sql = new StringBuilder("select * from  ").append(Metadata.TABLE_NAME).append("  t where 1=1 ");
		if(isNotEmpty(query.getId())) {
            sql.append(" and t.id = :id ");
        }
		if(isNotEmpty(query.getMetadataNum())) {
            sql.append(" and t.metadata_num = :metadataNum ");
        }
		if(isNotEmpty(query.getMetadataModelNum())) {
            sql.append(" and t.metadata_model_num = :metadataModelNum ");
        }
		if(isNotEmpty(query.getDataField())) {
            sql.append(" and t.data_field = :dataField ");
        }
		if(isNotEmpty(query.getDataKey())) {
            sql.append(" and t.data_key = :dataKey ");
        }
		if(isNotEmpty(query.getDataPath())) {
            sql.append(" and t.data_path = :dataPath ");
        }
		if(isNotEmpty(query.getDataType())) {
            sql.append(" and t.data_type = :dataType ");
        }
		if(isNotEmpty(query.getDataAttr())) {
            sql.append(" and t.data_attr = :dataAttr ");
        }
		if(isNotEmpty(query.getDataValue())) {
            sql.append(" and t.data_value = :dataValue ");
        }
		if(isNotEmpty(query.getDataFormat())) {
            sql.append(" and t.data_format = :dataFormat ");
        }
		if(isNotEmpty(query.getTempNum())) {
            sql.append(" and t.temp_num = :tempNum ");
        }
		if(isNotEmpty(query.getDataFilter())) {
            sql.append(" and t.data_filter = :dataFilter ");
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
	
	public Metadata getByMetadataNum(java.lang.String v) {
		String sql = "select * from  ".concat(Metadata.TABLE_NAME).concat("  t where t.metadata_num=:key");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("key", v);
		return getEntityBySql(sql, map);
	}	
	
	
	public List<Metadata> getByMetadataModelNum(java.lang.String v) {
		String sql = "select * from  ".concat(Metadata.TABLE_NAME).concat("  t where t.metadata_model_num=:key order by id");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("key", v);
		return getListEntityBySql(sql, map);
	}	
	
	

}
