package com.taoxiha.common.cache.memcached;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;

import com.taoxiha.common.cache.localcache.LocalCache;


public class SpyMemcachedCache implements IMemcachedCache {

	private static final int TIMEOUT = 5;

	private MemcachedClient client;
	private List<String> list;
	private LocalCache local;

	public SpyMemcachedCache() {
		if (local == null)
			local = new LocalCache();
	}

	public SpyMemcachedCache(List<String> list) {
		this.list = list;
		if (local == null)
			local = new LocalCache();
	}

    public void init() {
        List<InetSocketAddress> addrs = new ArrayList<InetSocketAddress>();
        try {
            for (String host : list) {
                String[] ss = host.split(":");
                InetSocketAddress isa;
                isa = new InetSocketAddress(ss[0], Integer
                        .parseInt(ss[1]));
                addrs.add(isa);
            }
            client = new MemcachedClient(addrs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public void close() {
		if (client != null) {
			client.shutdown();
		}
	}

	/**
	 * 获取后缓存到本地
	 */
	public Object get(String key, int localTTL) {
		Object ret = null;
		if (local.containsKey(key)) {
			ret = local.get(key);
		}
		if (ret != null) {
			return ret;
		}

		ret = get(key);
		if (ret != null) {
			local.put(key, ret, localTTL);
		}

		return ret;
	}

	/**
	 * 获取缓存
	 * 
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		if (key == null || key.length() <= 0) {
			return null;
		}
		if (client == null) {
			return null;
		}
		if (!client.isAlive()) {
	            return null;
		}
		if (client.isInterrupted()) {
			return null;
		}
		if (client.getAvailableServers().size() <= 0) {
			return null;
		}

		Object ret = null;

		Future<Object> f = client.asyncGet(key);
		try {
			ret = f.get(TIMEOUT, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			f.cancel(false);
		} catch (InterruptedException e) {
			f.cancel(false);
		} catch (ExecutionException e) {
//			System.out.println("==============");
			f.cancel(false);
		}

		return ret;
	}

	public Map<String, Object> getMulti(String[] keys) {
		if (keys == null || keys.length <= 0) {
			return null;
		}

		Map<String, Object> ret = null;
		Future<Map<String, Object>> f = client.asyncGetBulk(keys);
		try {
			ret = f.get(TIMEOUT, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			f.cancel(false);
		} catch (InterruptedException e) {
			f.cancel(false);
		} catch (ExecutionException e) {
			f.cancel(false);
		}

		return ret;
	}

	public long incr(String key, int inc) {
		if (key == null || key.length() <= 0) {
			return -1;
		}

		Long ret = null;
		Future<Long> f = client.asyncIncr(key, inc);
		try {
			ret = f.get(TIMEOUT, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			f.cancel(false);
		} catch (InterruptedException e) {
			f.cancel(false);
		} catch (ExecutionException e) {
			f.cancel(false);
		}

		return ret;
	}

	public long decr(String key, int decr) {
		if (key == null || key.length() <= 0) {
			return -1;
		}

		Long ret = null;
		Future<Long> f = client.asyncDecr(key, decr);
		try {
			ret = f.get(TIMEOUT, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			f.cancel(false);
		} catch (InterruptedException e) {
			f.cancel(false);
		} catch (ExecutionException e) {
			f.cancel(false);
		}

		return ret;
	}

	public boolean add(String key, Object value) {
		return add(key, value, 0);
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @param exp
	 * @return
	 */
	public boolean add(String key, Object value, int exp) {
		if (key == null || key.length() <= 0) {
			return false;
		}

		if (client == null) {
			return false;
		}
		if (!client.isAlive()) {
			return false;
		}
		if (client.isInterrupted()) {
			return false;
		}
		if (client.getAvailableServers().size() <= 0) {
			return false;
		}

		Future<Boolean> f = client.set(key, exp, value);
		return f.isDone();
	}

	public boolean delete(String key) {
		if (key == null || key.length() <= 0) {
			return false;
		}

		if (client == null) {
			return false;
		}
		if (!client.isAlive()) {
			return false;
		}
		if (client.isInterrupted()) {
			return false;
		}
		if (client.getAvailableServers().size() <= 0) {
			return false;
		}
		if (local.containsKey(key)) {
			local.remove(key);
		}

		Future<Boolean> a = client.delete(key);

		return a.isDone();
	}

	public MemcachedCAS gets(String key) {
		if (key == null || key.length() <= 0) {
			return null;
		}

		if (client == null) {
			return null;
		}
		if (!client.isAlive()) {
			return null;
		}
		if (client.isInterrupted()) {
			return null;
		}
		if (client.getAvailableServers().size() <= 0) {
			return null;
		}

		MemcachedCAS ret = null;
		CASValue<Object> cas = null;

		Future<CASValue<Object>> f = client.asyncGets(key);
		try {
			cas = f.get(TIMEOUT, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			f.cancel(false);
		} catch (InterruptedException e) {
			f.cancel(false);
		} catch (ExecutionException e) {
			f.cancel(false);
		}

		if (cas == null) {
			return null;
		}

		ret = new MemcachedCAS();
		ret.setCas(cas.getCas());
		ret.setValue(cas.getValue());

		return ret;
	}

	public boolean cas(String key, long casId, Object value) {
		if (key == null || key.length() <= 0) {
			return false;
		}

		if (client == null) {
			return false;
		}
		if (!client.isAlive()) {
			return false;
		}
		if (client.isInterrupted()) {
			return false;
		}
		if (client.getAvailableServers().size() <= 0) {
			return false;
		}

		CASResponse cas = null;

		Future<CASResponse> f = client.asyncCAS(key, casId, value);
		try {
			cas = f.get(TIMEOUT, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			f.cancel(false);
		} catch (InterruptedException e) {
			f.cancel(false);
		} catch (ExecutionException e) {
			f.cancel(false);
		}

		if (cas == null) {
			return false;
		}

		if (cas.equals(CASResponse.OK)) {
			return true;
		}

		return false;
	}
}
