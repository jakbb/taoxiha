package com.taoxiha.common.cache.memcached;

import java.util.Map;



public interface IMemcachedCache {

	/**
	 * 永久
	 */
	public static final int FOREVER = 0;
	/**
	 * 一秒钟
	 */
	public static final int SECOND = 1;
	/**
	 * 一分钟
	 */
	public static final int MINUTE = 60;
	/**
	 * 一小时
	 */
	public static final int HOUR = 3600;
	/**
	 * 一天
	 */
	public static final int DAY = 86400;
	/**
	 * 一周
	 */
	public static final int WEEK = 604800;
	/**
	 * 一月
	 */
	public static final int MONTH = 2592000;

	/**
	 * 初始化
	 */
	public void init();

	/**
	 * 关闭
	 */
	public void close();

	/**
	 * 
	 * @param key
	 * @return
	 */
	public Object get(String key);

	/**
	 * 采用本地cache结合memcache的方式
	 * 
	 * @param key
	 * @param 本地缓存失效时间单位秒
	 * @return
	 */
	public Object get(String key, int localTTL);

	/**
	 * 
	 * @param key
	 * @return
	 */
	public MemcachedCAS gets(String key);

	public boolean cas(String key, long casId, Object value);

	/**
	 * 获取多个keys对应的key&value Entrys
	 * 
	 * @param keys
	 * @return
	 */
	public Map<String, Object> getMulti(String[] keys);

	/**
	 * key所对应的是一个计数器，实现增加inc的数量
	 * 
	 * @param key
	 * @param inc
	 * @return
	 */
	public long incr(String key, int inc);

	/**
	 * key所对应的是一个计数器，实现减少decr的数量
	 * 
	 * @param key
	 * @param decr
	 * @return
	 */
	public long decr(String key, int decr);

	/**
	 * 保存数据
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean add(String key, Object value);

	/**
	 * 保存数据
	 * 
	 * @param key
	 * @param value
	 * @param exp
	 * @return
	 */
	public boolean add(String key, Object value, int exp);

	/**
	 * delete
	 * 
	 * @param key
	 * @return
	 */
	public boolean delete(String key);
}
