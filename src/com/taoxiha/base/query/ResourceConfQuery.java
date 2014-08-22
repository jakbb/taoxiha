package com.taoxiha.base.query;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.taoxiha.base.BaseEntity;
import com.taoxiha.base.BaseQuery;
import com.taoxiha.base.model.ResourceConf;



public class ResourceConfQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** id */
	private java.lang.Integer id;
	/** 源数据抓取编号 */
	private java.lang.String resourceConfNum;
	/** resourceName */
	private java.lang.String resourceName;
	/** resourceDesc */
	private java.lang.String resourceDesc;
	/** 备注 */
	private java.lang.String status;
	/** create_time */
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
	
	public java.lang.String getResourceConfNum() {
		return this.resourceConfNum;
	}
	
	public void setResourceConfNum(java.lang.String value) {
		this.resourceConfNum = value;
	}
	
	public java.lang.String getResourceName() {
		return this.resourceName;
	}
	
	public void setResourceName(java.lang.String value) {
		this.resourceName = value;
	}
	
	public java.lang.String getResourceDesc() {
		return this.resourceDesc;
	}
	
	public void setResourceDesc(java.lang.String value) {
		this.resourceDesc = value;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}
	
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	

	public java.lang.Integer getCreateTimeBegin() {
		return BaseEntity.strToUnixTime(getCreateTimeBeginString(), ResourceConf.FORMAT_CREATE_TIME);
	}
	
	public java.lang.String getCreateTimeBeginString() {
		return this.createTimeBeginString;
	}
	
	public void setCreateTimeBeginString(java.lang.String value) {
		this.createTimeBeginString = value;
	}	
	
	public java.lang.Integer getCreateTimeEnd() {
		return BaseEntity.strToUnixTime(getCreateTimeEndString(), ResourceConf.FORMAT_CREATE_TIME);
	}
	
	public java.lang.String getCreateTimeEndString() {
		return this.createTimeEndString;
	}
	
	public void setCreateTimeEndString(java.lang.String value) {
		this.createTimeEndString = value;
	}
	

	public java.lang.Integer getUpdateTimeBegin() {
		return BaseEntity.strToUnixTime(getUpdateTimeBeginString(), ResourceConf.FORMAT_UPDATE_TIME);
	}
	
	public java.lang.String getUpdateTimeBeginString() {
		return this.updateTimeBeginString;
	}
	
	public void setUpdateTimeBeginString(java.lang.String value) {
		this.updateTimeBeginString = value;
	}	
	
	public java.lang.Integer getUpdateTimeEnd() {
		return BaseEntity.strToUnixTime(getUpdateTimeEndString(), ResourceConf.FORMAT_UPDATE_TIME);
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

