package com.taoxiha.common.cache.redis;



public interface EntityCache <E>{
	String CACHE_APP_NAME="taoxiha_";
	
	public Class<E> getEntityClass();

	public String getByKey(String id) throws CacheAccessException;
	
	public E getEntityByKey(String id) throws CacheAccessException; 
	
	public void deleteByKey(String id) throws CacheAccessException;
	
	public void add( E entity) throws CacheAccessException;
	
	
}
