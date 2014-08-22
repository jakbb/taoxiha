package com.taoxiha.base.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.taoxiha.base.BaseSpringJdbcDao;
import com.taoxiha.base.model.DataSourcePool;
import com.taoxiha.base.query.DataSourcePoolQuery;
import com.taoxiha.common.page.Page;
import static com.taoxiha.common.util.ObjectUtils.*;



@Repository
public class DataSourcePoolDao extends BaseSpringJdbcDao<DataSourcePool,java.lang.Integer>{
	
	public Class getEntityClass() {
		return DataSourcePool.class;
	}
	
	public void save(DataSourcePool entity) {
		String sql = getSqlGenerator().getInsertSql();
		insertWithGeneratedKey(entity,sql);
	}
	
	public Page findPage(DataSourcePoolQuery query) {
		StringBuilder sql = new StringBuilder("select * from  ").append(DataSourcePool.TABLE_NAME).append("  t where 1=1 ");
		if(isNotEmpty(query.getId())) {
            sql.append(" and t.id = :id ");
        }
		if(isNotEmpty(query.getSourceNum())) {
            sql.append(" and t.source_num = :sourceNum ");
        }
		if(isNotEmpty(query.getSourceName())) {
            sql.append(" and t.source_name = :sourceName ");
        }
		if(isNotEmpty(query.getMetadataModelNum())) {
            sql.append(" and t.metadata_model_num = :metadataModelNum ");
        }
		if(isNotEmpty(query.getDataSource())) {
            sql.append(" and t.data_source = :dataSource ");
        }
		if(isNotEmpty(query.getDataType())) {
            sql.append(" and t.data_type = :dataType ");
        }
		if(isNotEmpty(query.getReqType())) {
            sql.append(" and t.req_type = :reqType ");
        }
		if(isNotEmpty(query.getReqParams())) {
            sql.append(" and t.req_params = :reqParams ");
        }
		if(isNotEmpty(query.getUrlFilters())) {
            sql.append(" and t.url_filters = :urlFilters ");
        }
		if(isNotEmpty(query.getSourceDesc())) {
            sql.append(" and t.source_desc = :sourceDesc ");
        }
		if(isNotEmpty(query.getStatus())) {
            sql.append(" and t.status = :status ");
        }
		if(isNotEmpty(query.getResourceConfNum())) {
            sql.append(" and t.resource_conf_num = :resourceConfNum ");
        }
		if(isNotEmpty(query.getCrawlConfNum())) {
            sql.append(" and t.crawl_conf_num = :crawlConfNum ");
        }
		if(isNotEmpty(query.getStorageConfNum())) {
            sql.append(" and t.storage_conf_num = :storageConfNum ");
        }
		if(isNotEmpty(query.getIndexConfNum())) {
            sql.append(" and t.index_conf_num = :indexConfNum ");
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
	
	public DataSourcePool getBySourceNum(java.lang.String v) {
		String sql = "select * from  ".concat(DataSourcePool.TABLE_NAME).concat("  t where t.source_num=:key");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("key", v);
		return getEntityBySql(sql, map);
	}
	
	public List<DataSourcePool> getBySourceConfNum(java.lang.String v) {
		String sql = "select * from  ".concat(DataSourcePool.TABLE_NAME).concat("  t where t.resource_conf_num=:key");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("key", v);
		return getListEntityBySql(sql, map);
	}
	
}
