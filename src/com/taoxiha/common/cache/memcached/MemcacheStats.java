package com.taoxiha.common.cache.memcached;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MemcacheStats implements Serializable {
	private String serverHost;
	private String statInfo;

	public String getServerHost() {
		return serverHost;
	}

	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}

	public String getStatInfo() {
		return statInfo;
	}

	public void setStatInfo(String statInfo) {
		this.statInfo = statInfo;
	}

}
