package com.taoxiha.service.crawl.entity;

import java.util.ResourceBundle;

 

public class CrawlInfoConfig {
	

	private static Object lock              = new Object();
	private static CrawlInfoConfig config     = null;
	private static ResourceBundle rb        = null;
	private static final String CONFIG_FILE = "conf/crawl";
	
	private CrawlInfoConfig() {
		rb = ResourceBundle.getBundle(CONFIG_FILE);
	}
	public static String pidpath = "";
	public static String datapath = "";
	

	static {
		CrawlInfoConfig conf=getInstance();
		pidpath = conf.getValue("pidpath");
		datapath=conf.getValue("datapath");
	}
	
	
	public static CrawlInfoConfig getInstance() {
		synchronized(lock) {
			if(null == config) {
				config = new CrawlInfoConfig();
			}
		}
		return (config);
	}
	
	public String getValue(String key) {
		return (rb.getString(key));
	}
}
