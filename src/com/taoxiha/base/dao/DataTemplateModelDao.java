package com.taoxiha.base.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.taoxiha.base.BaseSpringJdbcDao;
import com.taoxiha.base.model.DataTemplateModel;
import com.taoxiha.base.query.DataTemplateModelQuery;
import com.taoxiha.common.page.Page;
import static com.taoxiha.common.util.ObjectUtils.*;



@Repository
public class DataTemplateModelDao extends BaseSpringJdbcDao<DataTemplateModel,java.lang.Integer>{
	
	public Class getEntityClass() {
		return DataTemplateModel.class;
	}
	
	public void save(DataTemplateModel entity) {
		String sql = getSqlGenerator().getInsertSql();
		insertWithGeneratedKey(entity,sql);
	}
	
	public Page findPage(DataTemplateModelQuery query) {
		StringBuilder sql = new StringBuilder("select * from  ").append(DataTemplateModel.TABLE_NAME).append("  t where 1=1 ");
		if(isNotEmpty(query.getId())) {
            sql.append(" and t.id = :id ");
        }
		if(isNotEmpty(query.getTempNum())) {
            sql.append(" and t.temp_num = :tempNum ");
        }
		if(isNotEmpty(query.getDataType())) {
            sql.append(" and t.data_type = :dataType ");
        }
		if(isNotEmpty(query.getDataInfo())) {
            sql.append(" and t.data_info = :dataInfo ");
        }
		if(isNotEmpty(query.getTempAddress())) {
            sql.append(" and t.temp_address = :tempAddress ");
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
	
	public DataTemplateModel getByTempNum(java.lang.String v) {
		String sql = "select * from  ".concat(DataTemplateModel.TABLE_NAME).concat("  t where t.temp_num=:key");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("key", v);
		return getEntityBySql(sql, map);
	}	
	
	

}
