package com.taoxiha.service.crawl.entity;import java.io.Serializable;import java.util.List;import com.taoxiha.base.model.CrawlConf;import com.taoxiha.base.model.DataSourcePool;import com.taoxiha.base.model.IpProxyPool;import com.taoxiha.base.model.Metadata;public class CrawlParams implements Serializable{		private static final long serialVersionUID = 1L;		 private static ThreadLocal<CrawlParams> instanceMap = new ThreadLocal<CrawlParams>();  	    /** 	     * 得到与当前线程相关的，当前类的实例 	     */  	    public static synchronized CrawlParams getInstance(){  	    	CrawlParams instance = instanceMap.get();  	        if(null == instance){  	            instance = new CrawlParams();  	            instance.setCrawlResult(new CrawlResult());	            instanceMap.set(instance);  	        }  	        return instance;  	    }	    	    public static synchronized void setInstance(CrawlParams crawl){	    	if(null != crawl){	    	instanceMap.set(crawl);	    	}	    }		private DataSourcePool data;//数据源		private ReqParams reqParams;//请求参数		private UrlRegFilters urlRegFilters;//页面过滤		private CrawlConf crawlConf;//爬虫参数配置		private IpProxyPool ipProxyPool;//IP 代理		private List<Metadata> metadatas;//元数据集合		private String taskNum;//任务编号		private CrawlResult crawlResult;//单个线程抓取结果			public CrawlParams (){}		public List<Metadata> getMetadatas() {		return metadatas;	}	public void setMetadatas(List<Metadata> metadatas) {		this.metadatas = metadatas;	}	public String getTaskNum() {		return taskNum;	}	public void setTaskNum(String taskNum) {		this.taskNum = taskNum;	}	public DataSourcePool getData() {		return data;	}	public void setData(DataSourcePool data) {		this.data = data;	}	public ReqParams getReqParams() {		return reqParams;	}	public void setReqParams(ReqParams reqParams) {		this.reqParams = reqParams;	}	public UrlRegFilters getUrlRegFilters() {		return urlRegFilters;	}	public void setUrlRegFilters(UrlRegFilters urlRegFilters) {		this.urlRegFilters = urlRegFilters;	}	public CrawlConf getCrawlConf() {		return crawlConf;	}	public void setCrawlConf(CrawlConf crawlConf) {		this.crawlConf = crawlConf;	}	public IpProxyPool getIpProxyPool() {		return ipProxyPool;	}	public void setIpProxyPool(IpProxyPool ipProxyPool) {		this.ipProxyPool = ipProxyPool;	}	public CrawlResult getCrawlResult() {		return crawlResult;	}	public void setCrawlResult(CrawlResult crawlResult) {		this.crawlResult = crawlResult;	}	}