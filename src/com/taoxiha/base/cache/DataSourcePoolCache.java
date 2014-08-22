
package com.taoxiha.base.cache;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.taoxiha.base.BaseCacheMange;
import com.taoxiha.base.model.DataSourcePool;
import com.taoxiha.common.cache.redis.CacheAccessException;
import com.taoxiha.common.cache.redis.CacheAccessException.ErrorCode;


@Repository
public class DataSourcePoolCache extends BaseCacheMange<DataSourcePool>{
	
    public static final String CHACHE_SOURCENUM=DataSourcePool.TABLE_CACHE_PREFIX.concat("sourceNum_");
	
	public Class<DataSourcePool> getEntityClass() {
		return DataSourcePool.class;
	}
	
	 private Set<String> getKeys(DataSourcePool e){
	    	Set<String> keys = new HashSet<String>();
	    	if(StringUtils.isNotBlank(e.getSourceNum())){
	    		keys.add(CHACHE_SOURCENUM.concat(e.getSourceNum()));
	    	} 
	    	return keys;
	    }
	    
	    public void add(DataSourcePool e) throws CacheAccessException {
	    	Set<String> keys = getKeys(e);
	    	if(keys.size() == 0 ){
	    		throw new CacheAccessException(ErrorCode.PARSE_ERROR);
	    	}
	    	for (String key : keys) {
	    		saveEntity(key, e);
			}
	    }
	    
	    public void modify(DataSourcePool e) throws CacheAccessException{
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
	    
  	    
  		public DataSourcePool getBySourceNum(String value) throws CacheAccessException{
  			return getEntityByKey(CHACHE_SOURCENUM.concat(value));
  		}
  		
  		public void removeBySourceNum(String value) throws CacheAccessException{
  			deleteByKey(CHACHE_SOURCENUM.concat(value));
  		}
	
    	
}
