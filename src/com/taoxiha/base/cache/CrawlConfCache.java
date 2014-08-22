
package com.taoxiha.base.cache;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.taoxiha.base.BaseCacheMange;
import com.taoxiha.base.model.CrawlConf;
import com.taoxiha.common.cache.redis.CacheAccessException;
import com.taoxiha.common.cache.redis.CacheAccessException.ErrorCode;


@Repository
public class CrawlConfCache extends BaseCacheMange<CrawlConf>{
	
    public static final String CHACHE_CRAWLCONFNUM=CrawlConf.TABLE_CACHE_PREFIX.concat("crawlConfNum_");
	
	public Class<CrawlConf> getEntityClass() {
		return CrawlConf.class;
	}
	
	 private Set<String> getKeys(CrawlConf e){
	    	Set<String> keys = new HashSet<String>();
	    	if(StringUtils.isNotBlank(e.getCrawlConfNum())){
	    		keys.add(CHACHE_CRAWLCONFNUM.concat(e.getCrawlConfNum()));
	    	} 
	    	return keys;
	    }
	    
	    public void add(CrawlConf e) throws CacheAccessException {
	    	Set<String> keys = getKeys(e);
	    	if(keys.size() == 0 ){
	    		throw new CacheAccessException(ErrorCode.PARSE_ERROR);
	    	}
	    	for (String key : keys) {
	    		saveEntity(key, e);
			}
	    }
	    
	    public void modify(CrawlConf e) throws CacheAccessException{
			Set<String> keys = getKeys(e);
			if(keys.size() != 0 ){
				for (String key : keys) {
					if(hasKey(key)){
						deleteByKey(key);
					}
				}
			}
			add(e);
		}
	    
  	    
  		public CrawlConf getByCrawlConfNum(String value) throws CacheAccessException{
  			return getEntityByKey(CHACHE_CRAWLCONFNUM.concat(value));
  		}
  		
  		public void removeByCrawlConfNum(String value) throws CacheAccessException{
  			deleteByKey(CHACHE_CRAWLCONFNUM.concat(value));
  		}
	
    	
}
