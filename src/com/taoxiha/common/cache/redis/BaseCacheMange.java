package com.taoxiha.common.cache.redis;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import com.taoxiha.common.cache.redis.CacheAccessException.ErrorCode;

/**
 * cache 管理抽象类
 * 
 * @ClassName: BaseCacheMange
 * @Description: 完成cacheCURD
 * @author zguowei jakbb01@gmail.com
 * @date 2013-3-4 下午4:48:42
 * 缓存中对象以hash格式存放 ， 缓存key为主键
 * 其他唯一字段与主键做hash对应
 * 
 * @param <E>
 * @param <PK>
 */
public abstract class BaseCacheMange<E> extends RedisClientSurppot implements EntityCache<E> {

	public static final String UNIQUE_CACHE_KEY_PREFIX = CACHE_APP_NAME.concat("cache-user-unique-");
	
	public String getByKey(String key) throws CacheAccessException {
		try {
			return getString(key);
		} catch (Exception e) {
			throw new CacheAccessException(ErrorCode.CONNECTION_CACHE_ERROR);
		}
	}

	@SuppressWarnings("rawtypes")
	public E getEntityByKey(String key) throws CacheAccessException {
		try {
			Map map = getHash(key);
			if(map == null ){
				return null;
			}
			E e = getEntityClass().newInstance();
			BeanUtils.populate(e, map);
			return e;
		} catch (RuntimeException e) {
			throw new CacheAccessException(ErrorCode.PARSE_ERROR);
		} catch (Exception e) {
			throw new CacheAccessException(ErrorCode.CONNECTION_CACHE_ERROR);
		}
	}

	public void deleteByKey(String key) throws CacheAccessException {
		try {
			delete(key);
		} catch (Exception e) {
			throw new CacheAccessException(ErrorCode.CONNECTION_CACHE_ERROR);
		}
	}

	/** 指定key保存对象作为value */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void save(String key, E entity) throws CacheAccessException {
		try {
			Map map = PropertyUtils.describe(entity);
			this.setHash(key, map);
		} catch (RuntimeException e) {
			throw new CacheAccessException(ErrorCode.PARSE_ERROR);
		} catch (Exception e) {
			throw new CacheAccessException(ErrorCode.CONNECTION_CACHE_ERROR);
		}
	}

	public boolean has(String key) throws CacheAccessException {
		try {
			return super.hasKey(key);
		} catch (Exception e) {
			throw new CacheAccessException(ErrorCode.CONNECTION_CACHE_ERROR);
		}
	}

	 
	protected String getStringProp(Object obj, String propName) {
		try {
			Object o = PropertyUtils.getProperty(obj, propName);
			if(o == null ){
				return null;
			}
			return String.valueOf( PropertyUtils.getProperty(obj, propName));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
 

	public void setExpireTime(String key , long timeout) throws CacheAccessException{
			super.expire(key, timeout);
	}

}
