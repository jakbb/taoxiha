package com.taoxiha.base.query;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.taoxiha.base.BaseEntity;
import com.taoxiha.base.BaseQuery;
import com.taoxiha.base.model.CrawlConf;



public class CrawlConfQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** id */
	private java.lang.Integer id;
	/** crawlConfNum */
	private java.lang.String crawlConfNum;
	/** maxPages */
	private java.lang.Integer maxPages;
	/** maxDepth */
	private java.lang.Integer maxDepth;
	/** ipProxy */
	private java.lang.Integer ipProxy;
	/** isRobots */
	private java.lang.Integer isRobots;
	/** threadNum */
	private java.lang.Integer threadNum;
	/** delayTime */
	private java.lang.String delayTimeBeginString;
	private java.lang.String delayTimeEndString;
	
	/** createTime */
	private java.lang.String createTimeBeginString;
	private java.lang.String createTimeEndString;
	
	/** updateTime */
	private java.lang.String updateTimeBeginString;
	private java.lang.String updateTimeEndString;
	
	/** memo */
	private java.lang.String memo;

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.String getCrawlConfNum() {
		return this.crawlConfNum;
	}
	
	public void setCrawlConfNum(java.lang.String value) {
		this.crawlConfNum = value;
	}
	
	public java.lang.Integer getMaxPages() {
		return this.maxPages;
	}
	
	public void setMaxPages(java.lang.Integer value) {
		this.maxPages = value;
	}
	
	public java.lang.Integer getMaxDepth() {
		return this.maxDepth;
	}
	
	public void setMaxDepth(java.lang.Integer value) {
		this.maxDepth = value;
	}
	
	public java.lang.Integer getIpProxy() {
		return this.ipProxy;
	}
	
	public void setIpProxy(java.lang.Integer value) {
		this.ipProxy = value;
	}
	
	public java.lang.Integer getIsRobots() {
		return this.isRobots;
	}
	
	public void setIsRobots(java.lang.Integer value) {
		this.isRobots = value;
	}
	
	public java.lang.Integer getThreadNum() {
		return this.threadNum;
	}
	
	public void setThreadNum(java.lang.Integer value) {
		this.threadNum = value;
	}
	

	public java.lang.Integer getDelayTimeBegin() {
		return BaseEntity.strToUnixTime(getDelayTimeBeginString(), CrawlConf.FORMAT_DELAY_TIME);
	}
	
	public java.lang.String getDelayTimeBeginString() {
		return this.delayTimeBeginString;
	}
	
	public void setDelayTimeBeginString(java.lang.String value) {
		this.delayTimeBeginString = value;
	}	
	
	public java.lang.Integer getDelayTimeEnd() {
		return BaseEntity.strToUnixTime(getDelayTimeEndString(), CrawlConf.FORMAT_DELAY_TIME);
	}
	
	public java.lang.String getDelayTimeEndString() {
		return this.delayTimeEndString;
	}
	
	public void setDelayTimeEndString(java.lang.String value) {
		this.delayTimeEndString = value;
	}
	

	public java.lang.Integer getCreateTimeBegin() {
		return BaseEntity.strToUnixTime(getCreateTimeBeginString(), CrawlConf.FORMAT_CREATE_TIME);
	}
	
	public java.lang.String getCreateTimeBeginString() {
		return this.createTimeBeginString;
	}
	
	public void setCreateTimeBeginString(java.lang.String value) {
		this.createTimeBeginString = value;
	}	
	
	public java.lang.Integer getCreateTimeEnd() {
		return BaseEntity.strToUnixTime(getCreateTimeEndString(), CrawlConf.FORMAT_CREATE_TIME);
	}
	
	public java.lang.String getCreateTimeEndString() {
		return this.createTimeEndString;
	}
	
	public void setCreateTimeEndString(java.lang.String value) {
		this.createTimeEndString = value;
	}
	

	public java.lang.Integer getUpdateTimeBegin() {
		return BaseEntity.strToUnixTime(getUpdateTimeBeginString(), CrawlConf.FORMAT_UPDATE_TIME);
	}
	
	public java.lang.String getUpdateTimeBeginString() {
		return this.updateTimeBeginString;
	}
	
	public void setUpdateTimeBeginString(java.lang.String value) {
		this.updateTimeBeginString = value;
	}	
	
	public java.lang.Integer getUpdateTimeEnd() {
		return BaseEntity.strToUnixTime(getUpdateTimeEndString(), CrawlConf.FORMAT_UPDATE_TIME);
	}
	
	public java.lang.String getUpdateTimeEndString() {
		return this.updateTimeEndString;
	}
	
	public void setUpdateTimeEndString(java.lang.String value) {
		this.updateTimeEndString = value;
	}
	
	public java.lang.String getMemo() {
		return this.memo;
	}
	
	public void setMemo(java.lang.String value) {
		this.memo = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

