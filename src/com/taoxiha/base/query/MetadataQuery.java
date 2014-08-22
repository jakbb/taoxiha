package com.taoxiha.base.query;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.taoxiha.base.BaseEntity;
import com.taoxiha.base.BaseQuery;
import com.taoxiha.base.model.Metadata;



public class MetadataQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** id */
	private java.lang.Integer id;
	/** metadataNum */
	private java.lang.String metadataNum;
	/** metadataModelNum */
	private java.lang.String metadataModelNum;
	/** dataField */
	private java.lang.String dataField;
	/** dataKey */
	private java.lang.String dataKey;
	/** dataPath */
	private java.lang.String dataPath;
	/** dataType */
	private java.lang.String dataType;
	/** dataAttr */
	private java.lang.String dataAttr;
	/** 元数据值 */
	private java.lang.String dataValue;
	/** dataFormat */
	private java.lang.String dataFormat;
	/** tempNum */
	private java.lang.String tempNum;
	/** dataFilter */
	private java.lang.String dataFilter;
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
	
	public java.lang.String getMetadataNum() {
		return this.metadataNum;
	}
	
	public void setMetadataNum(java.lang.String value) {
		this.metadataNum = value;
	}
	
	public java.lang.String getMetadataModelNum() {
		return this.metadataModelNum;
	}
	
	public void setMetadataModelNum(java.lang.String value) {
		this.metadataModelNum = value;
	}
	
	public java.lang.String getDataField() {
		return this.dataField;
	}
	
	public void setDataField(java.lang.String value) {
		this.dataField = value;
	}
	
	public java.lang.String getDataKey() {
		return this.dataKey;
	}
	
	public void setDataKey(java.lang.String value) {
		this.dataKey = value;
	}
	
	public java.lang.String getDataPath() {
		return this.dataPath;
	}
	
	public void setDataPath(java.lang.String value) {
		this.dataPath = value;
	}
	
	public java.lang.String getDataType() {
		return this.dataType;
	}
	
	public void setDataType(java.lang.String value) {
		this.dataType = value;
	}
	
	public java.lang.String getDataAttr() {
		return this.dataAttr;
	}
	
	public void setDataAttr(java.lang.String value) {
		this.dataAttr = value;
	}
	
	public java.lang.String getDataValue() {
		return this.dataValue;
	}
	
	public void setDataValue(java.lang.String value) {
		this.dataValue = value;
	}
	
	public java.lang.String getDataFormat() {
		return this.dataFormat;
	}
	
	public void setDataFormat(java.lang.String value) {
		this.dataFormat = value;
	}
	
	public java.lang.String getTempNum() {
		return this.tempNum;
	}
	
	public void setTempNum(java.lang.String value) {
		this.tempNum = value;
	}
	
	public java.lang.String getDataFilter() {
		return this.dataFilter;
	}
	
	public void setDataFilter(java.lang.String value) {
		this.dataFilter = value;
	}
	

	public java.lang.Integer getCreateTimeBegin() {
		return BaseEntity.strToUnixTime(getCreateTimeBeginString(), Metadata.FORMAT_CREATE_TIME);
	}
	
	public java.lang.String getCreateTimeBeginString() {
		return this.createTimeBeginString;
	}
	
	public void setCreateTimeBeginString(java.lang.String value) {
		this.createTimeBeginString = value;
	}	
	
	public java.lang.Integer getCreateTimeEnd() {
		return BaseEntity.strToUnixTime(getCreateTimeEndString(), Metadata.FORMAT_CREATE_TIME);
	}
	
	public java.lang.String getCreateTimeEndString() {
		return this.createTimeEndString;
	}
	
	public void setCreateTimeEndString(java.lang.String value) {
		this.createTimeEndString = value;
	}
	

	public java.lang.Integer getUpdateTimeBegin() {
		return BaseEntity.strToUnixTime(getUpdateTimeBeginString(), Metadata.FORMAT_UPDATE_TIME);
	}
	
	public java.lang.String getUpdateTimeBeginString() {
		return this.updateTimeBeginString;
	}
	
	public void setUpdateTimeBeginString(java.lang.String value) {
		this.updateTimeBeginString = value;
	}	
	
	public java.lang.Integer getUpdateTimeEnd() {
		return BaseEntity.strToUnixTime(getUpdateTimeEndString(), Metadata.FORMAT_UPDATE_TIME);
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

