
package com.taoxiha.base.cache;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.taoxiha.base.BaseCacheMange;
import com.taoxiha.base.model.ResourceConf;
import com.taoxiha.common.cache.redis.CacheAccessException;
import com.taoxiha.common.cache.redis.CacheAccessException.ErrorCode;


@Repository
public class ResourceConfCache extends BaseCacheMange<ResourceConf>{
	
    public static final String CHACHE_RESOURCECONFNUM=ResourceConf.TABLE_CACHE_PREFIX.concat("resourceConfNum_");
	
	public Class<ResourceConf> getEntityClass() {
		return ResourceConf.class;
	}
	
	 private Set<String> getKeys(ResourceConf e){
	    	Set<String> keys = new HashSet<String>();
	    	if(StringUtils.isNotBlank(e.getResourceConfNum())){
	    		keys.add(CHACHE_RESOURCECONFNUM.concat(e.getResourceConfNum()));
	    	} 
	    	return keys;
	    }
	    
	    public void add(ResourceConf e) throws CacheAccessException {
	    	Set<String> keys = getKeys(e);
	    	if(keys.size() == 0 ){
	    		throw new CacheAccessException(ErrorCode.PARSE_ERROR);
	    	}
	    	for (String key : keys) {
	    		saveEntity(key, e);
			}
	    }
	    
	    public void modify(ResourceConf e) throws CacheAccessException{
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
	    
  	    
  		public ResourceConf getByResourceConfNum(String value) throws CacheAccessException{
  			return getEntityByKey(CHACHE_RESOURCECONFNUM.concat(value));
  		}
  		
  		public void removeByResourceConfNum(String value) throws CacheAccessException{
  			deleteByKey(CHACHE_RESOURCECONFNUM.concat(value));
  		}
	
    	
}
