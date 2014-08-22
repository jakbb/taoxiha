package com.taoxiha.base.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.taoxiha.base.BaseSpringJdbcDao;
import com.taoxiha.base.model.CrawlConf;
import com.taoxiha.base.query.CrawlConfQuery;
import com.taoxiha.common.page.Page;
import static com.taoxiha.common.util.ObjectUtils.*;


@Repository
public class CrawlConfDao extends BaseSpringJdbcDao<CrawlConf,java.lang.Integer>{
	
	public Class getEntityClass() {
		return CrawlConf.class;
	}
	
	public void save(CrawlConf entity) {
		String sql = getSqlGenerator().getInsertSql();
		insertWithGeneratedKey(entity,sql);
	}
	
	public Page findPage(CrawlConfQuery query) {
		StringBuilder sql = new StringBuilder("select * from  ").append(CrawlConf.TABLE_NAME).append("  t where 1=1 ");
		if(isNotEmpty(query.getId())) {
            sql.append(" and t.id = :id ");
        }
		if(isNotEmpty(query.getCrawlConfNum())) {
            sql.append(" and t.crawl_conf_num = :crawlConfNum ");
        }
		if(isNotEmpty(query.getMaxPages())) {
            sql.append(" and t.max_pages = :maxPages ");
        }
		if(isNotEmpty(query.getMaxDepth())) {
            sql.append(" and t.max_depth = :maxDepth ");
        }
		if(isNotEmpty(query.getIpProxy())) {
            sql.append(" and t.ip_proxy = :ipProxy ");
        }
		if(isNotEmpty(query.getIsRobots())) {
            sql.append(" and t.is_robots = :isRobots ");
        }
		if(isNotEmpty(query.getThreadNum())) {
            sql.append(" and t.thread_num = :threadNum ");
        }
		if(isNotEmpty(query.getDelayTimeBegin())) {
		    sql.append(" and t.delay_time >= :delayTimeBegin ");
		}
		if(isNotEmpty(query.getDelayTimeEnd())) {
            sql.append(" and t.delay_time <= :delayTimeEnd ");
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
	
	public CrawlConf getByCrawlConfNum(java.lang.String v) {
		String sql = "select * from  ".concat(CrawlConf.TABLE_NAME).concat("  t where t.crawl_conf_num=:key");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("key", v);
		return getEntityBySql(sql, map);
	}	
	
	

}
