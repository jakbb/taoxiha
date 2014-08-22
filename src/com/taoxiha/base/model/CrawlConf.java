package com.taoxiha.base.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import com.sleepycat.persist.model.Entity;
import com.taoxiha.base.BaseEntity;



@Entity
@Table(name = "crawl_conf")
public class CrawlConf extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	//cache prefix
	public static final String TABLE_CACHE_PREFIX=CACHE_APP_NAME.concat("cache-table-crawl_conf-");
	//alias
	public static final String TABLE_ALIAS = "CrawlConf";
	public static final String TABLE_NAME = "crawl_conf";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CRAWL_CONF_NUM = "crawlConfNum";
	public static final String ALIAS_MAX_PAGES = "maxPages";
	public static final String ALIAS_MAX_DEPTH = "maxDepth";
	public static final String ALIAS_IP_PROXY = "ipProxy";
	public static final String ALIAS_IS_ROBOTS = "isRobots";
	public static final String ALIAS_THREAD_NUM = "threadNum";
	public static final String ALIAS_DELAY_TIME = "delayTime";
	public static final String ALIAS_CREATE_TIME = "createTime";
	public static final String ALIAS_UPDATE_TIME = "updateTime";
	public static final String ALIAS_MEMO = "memo";
	
	//date formats
	public static final String FORMAT_DELAY_TIME = ENTITY_DATE_FORMAT;
	public static final String FORMAT_CREATE_TIME = ENTITY_DATE_FORMAT;
	public static final String FORMAT_UPDATE_TIME = ENTITY_DATE_FORMAT;
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private java.lang.Integer id;
	@Length(max=50)
	private java.lang.String crawlConfNum;
	
	private java.lang.Integer maxPages;
	
	private java.lang.Integer maxDepth;
	
	private java.lang.Integer ipProxy;
	
	private java.lang.Integer isRobots;
	
	private java.lang.Integer threadNum;
	
	private java.lang.Integer delayTime;
	
	private java.lang.Integer createTime;
	
	private java.lang.Integer updateTime;
	@Length(max=500)
	private java.lang.String memo;
	//columns END


	public CrawlConf(){
	}

	public CrawlConf(
		java.lang.Integer id
	){
		this.id = id;
	}

	

	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	@Id @GeneratedValue(generator="custom-id")
	@GenericGenerator(name="custom-id", strategy = "increment")
	@Column(name = "id", unique = true, nullable = false, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getId() {
		return this.id;
	}
	
	@Column(name = "crawl_conf_num", unique = true, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getCrawlConfNum() {
		return this.crawlConfNum;
	}
	
	public void setCrawlConfNum(java.lang.String value) {
		this.crawlConfNum = value;
	}
	
	@Column(name = "max_pages", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getMaxPages() {
		return this.maxPages;
	}
	
	public void setMaxPages(java.lang.Integer value) {
		this.maxPages = value;
	}
	
	@Column(name = "max_depth", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getMaxDepth() {
		return this.maxDepth;
	}
	
	public void setMaxDepth(java.lang.Integer value) {
		this.maxDepth = value;
	}
	
	@Column(name = "ip_proxy", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getIpProxy() {
		return this.ipProxy;
	}
	
	public void setIpProxy(java.lang.Integer value) {
		this.ipProxy = value;
	}
	
	@Column(name = "is_robots", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getIsRobots() {
		return this.isRobots;
	}
	
	public void setIsRobots(java.lang.Integer value) {
		this.isRobots = value;
	}
	
	@Column(name = "thread_num", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getThreadNum() {
		return this.threadNum;
	}
	
	public void setThreadNum(java.lang.Integer value) {
		this.threadNum = value;
	}
	
	@Transient
    public String getDelayTimeString() {
	  return fromUinxTime(getDelayTime());
	 }
    public void setDelayTimeString(String value) {
    	setDelayTime(strToUnixTime(value,FORMAT_DELAY_TIME));
	 }    
	@Column(name = "delay_time", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getDelayTime() {
		return this.delayTime;
	}
	
	public void setDelayTime(java.lang.Integer value) {
		this.delayTime = value;
	}
	
	@Transient
    public String getCreateTimeString() {
	  return fromUinxTime(getCreateTime());
	 }
    public void setCreateTimeString(String value) {
    	setCreateTime(strToUnixTime(value,FORMAT_CREATE_TIME));
	 }    
	@Column(name = "create_time", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.lang.Integer value) {
		this.createTime = value;
	}
	
	@Transient
    public String getUpdateTimeString() {
	  return fromUinxTime(getUpdateTime());
	 }
    public void setUpdateTimeString(String value) {
    	setUpdateTime(strToUnixTime(value,FORMAT_UPDATE_TIME));
	 }    
	@Column(name = "update_time", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getUpdateTime() {
		return this.updateTime;
	}
	
	public void setUpdateTime(java.lang.Integer value) {
		this.updateTime = value;
	}
	
	@Column(name = "memo", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
	public java.lang.String getMemo() {
		return this.memo;
	}
	
	public void setMemo(java.lang.String value) {
		this.memo = value;
	}
	

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("CrawlConfNum",getCrawlConfNum())
			.append("MaxPages",getMaxPages())
			.append("MaxDepth",getMaxDepth())
			.append("IpProxy",getIpProxy())
			.append("IsRobots",getIsRobots())
			.append("ThreadNum",getThreadNum())
			.append("DelayTime",getDelayTime())
			.append("CreateTime",getCreateTime())
			.append("UpdateTime",getUpdateTime())
			.append("Memo",getMemo())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof CrawlConf == false) return false;
		if(this == obj) return true;
		CrawlConf other = (CrawlConf)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

