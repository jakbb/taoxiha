package com.taoxiha.common.utils;

import java.util.ResourceBundle;

 
/**
 * @author liuhui
 *
 */
public class Configuration {

	private static final String CONFIG_FILE = "conf/conf";
	private static ResourceBundle bundle = ResourceBundle.getBundle(CONFIG_FILE);
	
	public static Integer AZB_TO_RMB_RATE = Integer.parseInt(get("azb_to_rmb_rate"));
	public static String WEB_RECHARGE_APP_KEY = get("web_recharge_app_key");
	public static String BASE_URL = get("base_url");
	public static String MSG_CONTENT=get("msg_content");
	public static String BASE_MSG_URL=get("base_msg_url");
	public static boolean DEBUG = Boolean.parseBoolean(get("debug"));
	private static String get(String key) {
		return bundle.getString(key);
	}
}
