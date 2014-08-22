package com.taoxiha.base.query;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.taoxiha.base.BaseEntity;
import com.taoxiha.base.BaseQuery;
import com.taoxiha.base.model.DataTemplateModel;



public class DataTemplateModelQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** id */
	private java.lang.Integer id;
	/** 模板编号 */
	private java.lang.String tempNum;
	/** html, json,xml,logfile */
	private java.lang.String dataType;
	/** dataInfo */
	private java.lang.String dataInfo;
	/** tempAddress */
	private java.lang.String tempAddress;
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
	
	public java.lang.String getTempNum() {
		return this.tempNum;
	}
	
	public void setTempNum(java.lang.String value) {
		this.tempNum = value;
	}
	
	public java.lang.String getDataType() {
		return this.dataType;
	}
	
	public void setDataType(java.lang.String value) {
		this.dataType = value;
	}
	
	public java.lang.String getDataInfo() {
		return this.dataInfo;
	}
	
	public void setDataInfo(java.lang.String value) {
		this.dataInfo = value;
	}
	
	public java.lang.String getTempAddress() {
		return this.tempAddress;
	}
	
	public void setTempAddress(java.lang.String value) {
		this.tempAddress = value;
	}
	

	public java.lang.Integer getCreateTimeBegin() {
		return BaseEntity.strToUnixTime(getCreateTimeBeginString(), DataTemplateModel.FORMAT_CREATE_TIME);
	}
	
	public java.lang.String getCreateTimeBeginString() {
		return this.createTimeBeginString;
	}
	
	public void setCreateTimeBeginString(java.lang.String value) {
		this.createTimeBeginString = value;
	}	
	
	public java.lang.Integer getCreateTimeEnd() {
		return BaseEntity.strToUnixTime(getCreateTimeEndString(), DataTemplateModel.FORMAT_CREATE_TIME);
	}
	
	public java.lang.String getCreateTimeEndString() {
		return this.createTimeEndString;
	}
	
	public void setCreateTimeEndString(java.lang.String value) {
		this.createTimeEndString = value;
	}
	

	public java.lang.Integer getUpdateTimeBegin() {
		return BaseEntity.strToUnixTime(getUpdateTimeBeginString(), DataTemplateModel.FORMAT_UPDATE_TIME);
	}
	
	public java.lang.String getUpdateTimeBeginString() {
		return this.updateTimeBeginString;
	}
	
	public void setUpdateTimeBeginString(java.lang.String value) {
		this.updateTimeBeginString = value;
	}	
	
	public java.lang.Integer getUpdateTimeEnd() {
		return BaseEntity.strToUnixTime(getUpdateTimeEndString(), DataTemplateModel.FORMAT_UPDATE_TIME);
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

