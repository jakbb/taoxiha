
package com.taoxiha.base.cache;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.taoxiha.base.BaseCacheMange;
import com.taoxiha.base.model.MetadataModel;
import com.taoxiha.common.cache.redis.CacheAccessException;
import com.taoxiha.common.cache.redis.CacheAccessException.ErrorCode;


@Repository
public class MetadataModelCache extends BaseCacheMange<MetadataModel>{
	
    public static final String CHACHE_METADATAMODELNUM=MetadataModel.TABLE_CACHE_PREFIX.concat("metadataModelNum_");
	
	public Class<MetadataModel> getEntityClass() {
		return MetadataModel.class;
	}
	
	 private Set<String> getKeys(MetadataModel e){
	    	Set<String> keys = new HashSet<String>();
	    	if(StringUtils.isNotBlank(e.getMetadataModelNum())){
	    		keys.add(CHACHE_METADATAMODELNUM.concat(e.getMetadataModelNum()));
	    	} 
	    	return keys;
	    }
	    
	    public void add(MetadataModel e) throws CacheAccessException {
	    	Set<String> keys = getKeys(e);
	    	if(keys.size() == 0 ){
	    		throw new CacheAccessException(ErrorCode.PARSE_ERROR);
	    	}
	    	for (String key : keys) {
	    		saveEntity(key, e);
			}
	    }
	    
	    public void modify(MetadataModel e) throws CacheAccessException{
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
	    
  	    
  		public MetadataModel getByMetadataModelNum(String value) throws CacheAccessException{
  			return getEntityByKey(CHACHE_METADATAMODELNUM.concat(value));
  		}
  		
  		public void removeByMetadataModelNum(String value) throws CacheAccessException{
  			deleteByKey(CHACHE_METADATAMODELNUM.concat(value));
  		}
	
    	
}
