package com.taoxiha.common.utils.log;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import com.taoxiha.common.utils.date.DateUtils;
import com.taoxiha.common.utils.io.FileHelper;
import com.taoxiha.service.crawl.entity.CrawlInfoConfig;


/**
* @ClassName: LogUtils 
* @Description: 记录log
* @author zguowei jakbb01@gmail.com
* @date 2012-9-10 上午10:46:34 
*/
public class LogUtils {

	
	/**
	 * 抓取日志
	 */
	protected static final Logger CRAWL_LOG = Logger.getLogger("crawl");
	
	/**
	 * 数据日志
	 */
	public  static final Logger DATA_LOG = Logger.getLogger("data");
	
	/**
	 * Web访问日志
	 */
	protected static final Logger WEB_LOG = Logger.getLogger("web");
	
	/**
	 * 调式日志，
	 */
	protected static final Logger DEBUG_LOG = Logger.getLogger("debug");
	
	/**
	 * 未被处理，被系统捕获的例外
	 */
	protected static final Logger EXCEPTION_LOG = Logger.getLogger("exception");
	
	
	private static boolean open=false;
	
	private static String key="is.debug";
	
	private static ResourceBundle rb;
	
	static{
		rb = ResourceBundle.getBundle("conf/log4j");
		open=Boolean.parseBoolean(rb.getString(key));
	}
	
	
	public static void LogAll(Logger log,Object ...items) {
		if(null==log)log = DEBUG_LOG;
		if(null==items || items.length==0)return;
		StringBuffer l = new StringBuffer();
		for(Object item : items){
			l.append(null==item ? "" : item.toString());
		}
		log.info(l.toString());
	}
	
	public static void crawlLog(String log){
		CRAWL_LOG.info(log);
	}
	
	public static void webLog(String log){
		WEB_LOG.info(log);
	}
	
	public static void dataLog(String log) {
		DATA_LOG.info(log);
	}
	
	public static void errorLog(String message, Throwable e) {
		EXCEPTION_LOG.error(message, e);
	}
	
	public static void error(String message) {
		EXCEPTION_LOG.error(message);
	}
	
	/**
	 * 调式日志
	 * @param message
	 */
	public static void debug(String message) {
		if(open){
			DEBUG_LOG.debug(message);
		}
	}
	
	public static void debug(String message,Throwable e) {
		DEBUG_LOG.debug(message,e);
	}
	
	
	private static final ThreadLocal<Logger> CRAWL_DATA_LOG = new ThreadLocal<Logger>() {
		  protected synchronized Logger initialValue() {
		   return Logger.getLogger("crawl_data_log");
		  }
		 };
		 private static Logger getCrawlLog() {
		  return (Logger) CRAWL_DATA_LOG.get();
		 }
		 
	private static final Logger _CRAWL_DATA_LOG =Logger.getLogger("crawl_data_log");
		
     public static Logger getByTaskNum(String tasknum){
//    	 final Logger log = getCrawlLog();
    	 final Logger log =_CRAWL_DATA_LOG;
    	 final CrawlAppenderFactory appenderFactory = new CrawlAppenderFactory();
    	  Appender appender = appenderFactory.getAppender(tasknum);
          if (!log.isAttached(appender)) {
            log.addAppender(appender);
          }
    	 return log;
     }
		 
     //数据日志动态路径指定
	 public static Logger dynamicLog(String taskNum){
				Layout layout = new PatternLayout("%m%n"); 
				String datadir=CrawlInfoConfig.datapath+"/"+DateUtils.getTheDateString();
				File file= new File(datadir,taskNum);
				if(!file.isFile()){
					file=FileHelper.mkdir(datadir,taskNum);
				}
				try {
					getCrawlLog().removeAllAppenders();
					Appender appender = new FileAppender(layout, file.getAbsolutePath());
					getCrawlLog().setLevel(Level.INFO);
					getCrawlLog().setAdditivity(false);
					getCrawlLog().addAppender(appender);
					return getCrawlLog();
				} catch (IOException e) {
				errorLog(e.getMessage(), e);
				return null;
				}
				}
	
}
