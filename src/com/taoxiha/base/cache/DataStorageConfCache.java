
package com.taoxiha.base.cache;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.taoxiha.base.BaseCacheMange;
import com.taoxiha.base.model.DataStorageConf;
import com.taoxiha.common.cache.redis.CacheAccessException;
import com.taoxiha.common.cache.redis.CacheAccessException.ErrorCode;


@Repository
public class DataStorageConfCache extends BaseCacheMange<DataStorageConf>{
	
    public static final String CHACHE_STORAGECONFNUM=DataStorageConf.TABLE_CACHE_PREFIX.concat("storageConfNum_");
	
	public Class<DataStorageConf> getEntityClass() {
		return DataStorageConf.class;
	}
	
	 private Set<String> getKeys(DataStorageConf e){
	    	Set<String> keys = new HashSet<String>();
	    	if(StringUtils.isNotBlank(e.getStorageConfNum())){
	    		keys.add(CHACHE_STORAGECONFNUM.concat(e.getStorageConfNum()));
	    	} 
	    	return keys;
	    }
	    
	    public void add(DataStorageConf e) throws CacheAccessException {
	    	Set<String> keys = getKeys(e);
	    	if(keys.size() == 0 ){
	    		throw new CacheAccessException(ErrorCode.PARSE_ERROR);
	    	}
	    	for (String key : keys) {
	    		saveEntity(key, e);
			}
	    }
	    
	    public void modify(DataStorageConf e) throws CacheAccessException{
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
	    
  	    
  		public DataStorageConf getByStorageConfNum(String value) throws CacheAccessException{
  			return getEntityByKey(CHACHE_STORAGECONFNUM.concat(value));
  		}
  		
  		public void removeByStorageConfNum(String value) throws CacheAccessException{
  			deleteByKey(CHACHE_STORAGECONFNUM.concat(value));
  		}
	
    	
}
