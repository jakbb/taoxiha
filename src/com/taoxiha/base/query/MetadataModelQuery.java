package com.taoxiha.base.query;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.taoxiha.base.BaseEntity;
import com.taoxiha.base.BaseQuery;
import com.taoxiha.base.model.MetadataModel;



public class MetadataModelQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** id */
	private java.lang.Integer id;
	/** metadataModelNum */
	private java.lang.String metadataModelNum;
	/** modelName */
	private java.lang.String modelName;
	/** modelDesc */
	private java.lang.String modelDesc;
	/** createTime */
	private java.lang.String createTimeBeginString;
	private java.lang.String createTimeEndString;
	
	/** updateTime */
	private java.lang.String updateTimeBeginString;
	private java.lang.String updateTimeEndString;
	

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.String getMetadataModelNum() {
		return this.metadataModelNum;
	}
	
	public void setMetadataModelNum(java.lang.String value) {
		this.metadataModelNum = value;
	}
	
	public java.lang.String getModelName() {
		return this.modelName;
	}
	
	public void setModelName(java.lang.String value) {
		this.modelName = value;
	}
	
	public java.lang.String getModelDesc() {
		return this.modelDesc;
	}
	
	public void setModelDesc(java.lang.String value) {
		this.modelDesc = value;
	}
	

	public java.lang.Integer getCreateTimeBegin() {
		return BaseEntity.strToUnixTime(getCreateTimeBeginString(), MetadataModel.FORMAT_CREATE_TIME);
	}
	
	public java.lang.String getCreateTimeBeginString() {
		return this.createTimeBeginString;
	}
	
	public void setCreateTimeBeginString(java.lang.String value) {
		this.createTimeBeginString = value;
	}	
	
	public java.lang.Integer getCreateTimeEnd() {
		return BaseEntity.strToUnixTime(getCreateTimeEndString(), MetadataModel.FORMAT_CREATE_TIME);
	}
	
	public java.lang.String getCreateTimeEndString() {
		return this.createTimeEndString;
	}
	
	public void setCreateTimeEndString(java.lang.String value) {
		this.createTimeEndString = value;
	}
	

	public java.lang.Integer getUpdateTimeBegin() {
		return BaseEntity.strToUnixTime(getUpdateTimeBeginString(), MetadataModel.FORMAT_UPDATE_TIME);
	}
	
	public java.lang.String getUpdateTimeBeginString() {
		return this.updateTimeBeginString;
	}
	
	public void setUpdateTimeBeginString(java.lang.String value) {
		this.updateTimeBeginString = value;
	}	
	
	public java.lang.Integer getUpdateTimeEnd() {
		return BaseEntity.strToUnixTime(getUpdateTimeEndString(), MetadataModel.FORMAT_UPDATE_TIME);
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

