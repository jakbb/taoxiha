package com.taoxiha.common.cache.memcached;


import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.exception.MemcachedException;
import net.spy.memcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.taoxiha.common.util.holder.ApplicationContextHolder;

public class Xmemcached {
	
	@Autowired
	@Qualifier("xmemcachedClient")
	private static MemcachedClient client;
	
	public static final int EXPIRE_TIME=3600;

	static{
		if(null==client){
		client=(MemcachedClient) ApplicationContextHolder.getBean("xmemcachedClient");
		}
	}
	
	public static MemcachedClient getClient() {
		return client;
	}
	
	
	/*
	public static Object getValeuByKey(String key){
		try {
			return client.get(key);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void setValue(String key,Object value){
		try {
			client.set(key, EXPIRE_TIME, value);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void setValueWithTime(String key,int expireTime,Object value){
		try {
			client.set(key, expireTime, value);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean delete(String key) {
		if (key == null || key.length() <= 0) {
			return false;
		}
		
		if (client == null) {
			return false;
		}

		try {
			 return client.delete(key);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void update(String key ,Object obj){
		try {
			client.replace(key, 0, obj);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static AbstractApplicationContext cxt;
	
	public static AbstractApplicationContext getCxt() {
		return new ClassPathXmlApplicationContext(
				"spring/*.xml");
	}
	public static void main(String[] args) throws Exception{
		cxt=getCxt();
		MemcachedClient client=(MemcachedClient) ApplicationContextHolder.getBean("xmemcachedClient");
		client.set("name", 0, "jakbb");
		System.out.println(client.get("name"));
	}
	*/

}
