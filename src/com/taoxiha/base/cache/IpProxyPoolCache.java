
package com.taoxiha.base.cache;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.taoxiha.base.BaseCacheMange;
import com.taoxiha.base.model.IpProxyPool;
import com.taoxiha.common.cache.redis.CacheAccessException;
import com.taoxiha.common.cache.redis.CacheAccessException.ErrorCode;


@Repository
public class IpProxyPoolCache extends BaseCacheMange<IpProxyPool>{
	
    public static final String CHACHE_PROXYIP=IpProxyPool.TABLE_CACHE_PREFIX.concat("proxyIp_");
	
	public Class<IpProxyPool> getEntityClass() {
		return IpProxyPool.class;
	}
	
	 private Set<String> getKeys(IpProxyPool e){
	    	Set<String> keys = new HashSet<String>();
	    	if(StringUtils.isNotBlank(e.getProxyIp())){
	    		keys.add(CHACHE_PROXYIP.concat(e.getProxyIp()));
	    	} 
	    	return keys;
	    }
	    
	    public void add(IpProxyPool e) throws CacheAccessException {
	    	Set<String> keys = getKeys(e);
	    	if(keys.size() == 0 ){
	    		throw new CacheAccessException(ErrorCode.PARSE_ERROR);
	    	}
	    	for (String key : keys) {
	    		saveEntity(key, e);
			}
	    }
	    
	    public void modify(IpProxyPool e) throws CacheAccessException{
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
	    
  	    
  		public IpProxyPool getByProxyIp(String value) throws CacheAccessException{
  			return getEntityByKey(CHACHE_PROXYIP.concat(value));
  		}
  		
  		public void removeByProxyIp(String value) throws CacheAccessException{
  			deleteByKey(CHACHE_PROXYIP.concat(value));
  		}
	
    	
}
