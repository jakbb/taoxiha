
package com.taoxiha.base.cache;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.taoxiha.base.BaseCacheMange;
import com.taoxiha.base.model.DataTemplateModel;
import com.taoxiha.common.cache.redis.CacheAccessException;
import com.taoxiha.common.cache.redis.CacheAccessException.ErrorCode;


@Repository
public class DataTemplateModelCache extends BaseCacheMange<DataTemplateModel>{
	
    public static final String CHACHE_TEMPNUM=DataTemplateModel.TABLE_CACHE_PREFIX.concat("tempNum_");
	
	public Class<DataTemplateModel> getEntityClass() {
		return DataTemplateModel.class;
	}
	
	 private Set<String> getKeys(DataTemplateModel e){
	    	Set<String> keys = new HashSet<String>();
	    	if(StringUtils.isNotBlank(e.getTempNum())){
	    		keys.add(CHACHE_TEMPNUM.concat(e.getTempNum()));
	    	} 
	    	return keys;
	    }
	    
	    public void add(DataTemplateModel e) throws CacheAccessException {
	    	Set<String> keys = getKeys(e);
	    	if(keys.size() == 0 ){
	    		throw new CacheAccessException(ErrorCode.PARSE_ERROR);
	    	}
	    	for (String key : keys) {
	    		saveEntity(key, e);
			}
	    }
	    
	    public void modify(DataTemplateModel e) throws CacheAccessException{
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
	    
  	    
  		public DataTemplateModel getByTempNum(String value) throws CacheAccessException{
  			return getEntityByKey(CHACHE_TEMPNUM.concat(value));
  		}
  		
  		public void removeByTempNum(String value) throws CacheAccessException{
  			deleteByKey(CHACHE_TEMPNUM.concat(value));
  		}
	
    	
}
