package com.taoxiha.common.cache.memcached;

public class MemcachedCAS {

	private long cas;
	private Object value;

	public long getCas() {
		return cas;
	}

	public void setCas(long cas) {
		this.cas = cas;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
