package com.taoxiha.base.query;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.taoxiha.base.BaseEntity;
import com.taoxiha.base.BaseQuery;
import com.taoxiha.base.model.DataStorageConf;



public class DataStorageConfQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** id */
	private java.lang.Integer id;
	/** storageConfNum */
	private java.lang.String storageConfNum;
	/** 1 存缓存 2 存文件 3 存数据库 4 存分布式文件管理系统 */
	private java.lang.Integer storageType;
	/** 0 文件以数字序列命名存储 1 以docid存储 2 以时间精确到秒存储              */
	private java.lang.String storageRule;
	/** storagePath */
	private java.lang.String storagePath;
	/** 0 json 1 xml 2  竖线分割字符串 */
	private java.lang.Integer storageFormat;
	/** filterWords */
	private java.lang.String filterWords;
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
	
	public java.lang.String getStorageConfNum() {
		return this.storageConfNum;
	}
	
	public void setStorageConfNum(java.lang.String value) {
		this.storageConfNum = value;
	}
	
	public java.lang.Integer getStorageType() {
		return this.storageType;
	}
	
	public void setStorageType(java.lang.Integer value) {
		this.storageType = value;
	}
	
	public java.lang.String getStorageRule() {
		return this.storageRule;
	}
	
	public void setStorageRule(java.lang.String value) {
		this.storageRule = value;
	}
	
	public java.lang.String getStoragePath() {
		return this.storagePath;
	}
	
	public void setStoragePath(java.lang.String value) {
		this.storagePath = value;
	}
	
	public java.lang.Integer getStorageFormat() {
		return this.storageFormat;
	}
	
	public void setStorageFormat(java.lang.Integer value) {
		this.storageFormat = value;
	}
	
	public java.lang.String getFilterWords() {
		return this.filterWords;
	}
	
	public void setFilterWords(java.lang.String value) {
		this.filterWords = value;
	}
	

	public java.lang.Integer getCreateTimeBegin() {
		return BaseEntity.strToUnixTime(getCreateTimeBeginString(), DataStorageConf.FORMAT_CREATE_TIME);
	}
	
	public java.lang.String getCreateTimeBeginString() {
		return this.createTimeBeginString;
	}
	
	public void setCreateTimeBeginString(java.lang.String value) {
		this.createTimeBeginString = value;
	}	
	
	public java.lang.Integer getCreateTimeEnd() {
		return BaseEntity.strToUnixTime(getCreateTimeEndString(), DataStorageConf.FORMAT_CREATE_TIME);
	}
	
	public java.lang.String getCreateTimeEndString() {
		return this.createTimeEndString;
	}
	
	public void setCreateTimeEndString(java.lang.String value) {
		this.createTimeEndString = value;
	}
	

	public java.lang.Integer getUpdateTimeBegin() {
		return BaseEntity.strToUnixTime(getUpdateTimeBeginString(), DataStorageConf.FORMAT_UPDATE_TIME);
	}
	
	public java.lang.String getUpdateTimeBeginString() {
		return this.updateTimeBeginString;
	}
	
	public void setUpdateTimeBeginString(java.lang.String value) {
		this.updateTimeBeginString = value;
	}	
	
	public java.lang.Integer getUpdateTimeEnd() {
		return BaseEntity.strToUnixTime(getUpdateTimeEndString(), DataStorageConf.FORMAT_UPDATE_TIME);
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

