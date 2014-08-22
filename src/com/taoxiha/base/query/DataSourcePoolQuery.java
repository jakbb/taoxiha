package com.taoxiha.base.query;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.taoxiha.base.BaseEntity;
import com.taoxiha.base.BaseQuery;
import com.taoxiha.base.model.DataSourcePool;



public class DataSourcePoolQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** id */
	private java.lang.Integer id;
	/** 数据源编号 */
	private java.lang.String sourceNum;
	/** 数据源名称 */
	private java.lang.String sourceName;
	/** 元数据模型编号 */
	private java.lang.String metadataModelNum;
	/** 数据地址 */
	private java.lang.String dataSource;
	/** html, json,xml,logfile */
	private java.lang.String dataType;
	/** 请求方式 get post put delete  */
	private java.lang.String reqType;
	/** 请求附带参数 */
	private java.lang.String reqParams;
	/** 以竖线分割  父级页面地址 | 数据访问页 |  数据下载页 */
	private java.lang.String urlFilters;
	/** 数据源描述 */
	private java.lang.String sourceDesc;
	/** 状态 0 不启用1 启用  */
	private java.lang.Integer status;
	/** 源数据抓取编号 */
	private java.lang.String resourceConfNum;
	/** 抓取配置编号 */
	private java.lang.String crawlConfNum;
	/** 存储配置编号 */
	private java.lang.String storageConfNum;
	/** 索引配置编号 */
	private java.lang.String indexConfNum;
	/** 创建时间 */
	private java.lang.String createTimeBeginString;
	private java.lang.String createTimeEndString;
	
	/** 更新时间 */
	private java.lang.String updateTimeBeginString;
	private java.lang.String updateTimeEndString;
	

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.String getSourceNum() {
		return this.sourceNum;
	}
	
	public void setSourceNum(java.lang.String value) {
		this.sourceNum = value;
	}
	
	public java.lang.String getSourceName() {
		return this.sourceName;
	}
	
	public void setSourceName(java.lang.String value) {
		this.sourceName = value;
	}
	
	public java.lang.String getMetadataModelNum() {
		return this.metadataModelNum;
	}
	
	public void setMetadataModelNum(java.lang.String value) {
		this.metadataModelNum = value;
	}
	
	public java.lang.String getDataSource() {
		return this.dataSource;
	}
	
	public void setDataSource(java.lang.String value) {
		this.dataSource = value;
	}
	
	public java.lang.String getDataType() {
		return this.dataType;
	}
	
	public void setDataType(java.lang.String value) {
		this.dataType = value;
	}
	
	public java.lang.String getReqType() {
		return this.reqType;
	}
	
	public void setReqType(java.lang.String value) {
		this.reqType = value;
	}
	
	public java.lang.String getReqParams() {
		return this.reqParams;
	}
	
	public void setReqParams(java.lang.String value) {
		this.reqParams = value;
	}
	
	public java.lang.String getUrlFilters() {
		return this.urlFilters;
	}
	
	public void setUrlFilters(java.lang.String value) {
		this.urlFilters = value;
	}
	
	public java.lang.String getSourceDesc() {
		return this.sourceDesc;
	}
	
	public void setSourceDesc(java.lang.String value) {
		this.sourceDesc = value;
	}
	
	public java.lang.Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	
	public java.lang.String getResourceConfNum() {
		return this.resourceConfNum;
	}
	
	public void setResourceConfNum(java.lang.String value) {
		this.resourceConfNum = value;
	}
	
	public java.lang.String getCrawlConfNum() {
		return this.crawlConfNum;
	}
	
	public void setCrawlConfNum(java.lang.String value) {
		this.crawlConfNum = value;
	}
	
	public java.lang.String getStorageConfNum() {
		return this.storageConfNum;
	}
	
	public void setStorageConfNum(java.lang.String value) {
		this.storageConfNum = value;
	}
	
	public java.lang.String getIndexConfNum() {
		return this.indexConfNum;
	}
	
	public void setIndexConfNum(java.lang.String value) {
		this.indexConfNum = value;
	}
	

	public java.lang.Integer getCreateTimeBegin() {
		return BaseEntity.strToUnixTime(getCreateTimeBeginString(), DataSourcePool.FORMAT_CREATE_TIME);
	}
	
	public java.lang.String getCreateTimeBeginString() {
		return this.createTimeBeginString;
	}
	
	public void setCreateTimeBeginString(java.lang.String value) {
		this.createTimeBeginString = value;
	}	
	
	public java.lang.Integer getCreateTimeEnd() {
		return BaseEntity.strToUnixTime(getCreateTimeEndString(), DataSourcePool.FORMAT_CREATE_TIME);
	}
	
	public java.lang.String getCreateTimeEndString() {
		return this.createTimeEndString;
	}
	
	public void setCreateTimeEndString(java.lang.String value) {
		this.createTimeEndString = value;
	}
	

	public java.lang.Integer getUpdateTimeBegin() {
		return BaseEntity.strToUnixTime(getUpdateTimeBeginString(), DataSourcePool.FORMAT_UPDATE_TIME);
	}
	
	public java.lang.String getUpdateTimeBeginString() {
		return this.updateTimeBeginString;
	}
	
	public void setUpdateTimeBeginString(java.lang.String value) {
		this.updateTimeBeginString = value;
	}	
	
	public java.lang.Integer getUpdateTimeEnd() {
		return BaseEntity.strToUnixTime(getUpdateTimeEndString(), DataSourcePool.FORMAT_UPDATE_TIME);
	}
	
	public java.lang.String getUpdateTimeEndString() {
		return this.updateTimeEndString;
	}
	
	public void setUpdateTimeEndString(java.lang.String value) {
		this.updateTimeEndString = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

