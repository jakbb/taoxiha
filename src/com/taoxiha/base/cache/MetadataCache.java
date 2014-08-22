
package com.taoxiha.base.cache;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.taoxiha.base.BaseCacheMange;
import com.taoxiha.base.model.Metadata;
import com.taoxiha.common.cache.redis.CacheAccessException;
import com.taoxiha.common.cache.redis.CacheAccessException.ErrorCode;


@Repository
public class MetadataCache extends BaseCacheMange<Metadata>{
	
    public static final String CHACHE_METADATANUM=Metadata.TABLE_CACHE_PREFIX.concat("metadataNum_");
	
	public Class<Metadata> getEntityClass() {
		return Metadata.class;
	}
	
	 private Set<String> getKeys(Metadata e){
	    	Set<String> keys = new HashSet<String>();
	    	if(StringUtils.isNotBlank(e.getMetadataNum())){
	    		keys.add(CHACHE_METADATANUM.concat(e.getMetadataNum()));
	    	} 
	    	return keys;
	    }
	    
	    public void add(Metadata e) throws CacheAccessException {
	    	Set<String> keys = getKeys(e);
	    	if(keys.size() == 0 ){
	    		throw new CacheAccessException(ErrorCode.PARSE_ERROR);
	    	}
	    	for (String key : keys) {
	    		saveEntity(key, e);			}
	    }
	    
	    public void modify(Metadata e) throws CacheAccessException{
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
	    
  	    
  		public Metadata getByMetadataNum(String value) throws CacheAccessException{
  			return getEntityByKey(CHACHE_METADATANUM.concat(value));
  		}
  		
  		public void removeByMetadataNum(String value) throws CacheAccessException{
  			deleteByKey(CHACHE_METADATANUM.concat(value));
  		}
	
    	
}
