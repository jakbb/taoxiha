package com.taoxiha.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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

import com.taoxiha.base.BaseEntity;



@Entity
@Table(name = "metadata")
public class Metadata extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	//cache prefix
	public static final String TABLE_CACHE_PREFIX=CACHE_APP_NAME.concat("cache-table-metadata-");
	//alias
	public static final String TABLE_ALIAS = "Metadata";
	public static final String TABLE_NAME = "metadata";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_METADATA_NUM = "metadataNum";
	public static final String ALIAS_METADATA_MODEL_NUM = "metadataModelNum";
	public static final String ALIAS_DATA_FIELD = "dataField";
	public static final String ALIAS_DATA_KEY = "dataKey";
	public static final String ALIAS_DATA_PATH = "dataPath";
	public static final String ALIAS_DATA_TYPE = "dataType";
	public static final String ALIAS_DATA_ATTR = "dataAttr";
	public static final String ALIAS_DATA_VALUE = "元数据值";
	public static final String ALIAS_DATA_FORMAT = "dataFormat";
	public static final String ALIAS_TEMP_NUM = "tempNum";
	public static final String ALIAS_DATA_FILTER = "dataFilter";
	public static final String ALIAS_CREATE_TIME = "createTime";
	public static final String ALIAS_UPDATE_TIME = "updateTime";
	public static final String ALIAS_MEMO = "memo";
	
	//date formats
	public static final String FORMAT_CREATE_TIME = ENTITY_DATE_FORMAT;
	public static final String FORMAT_UPDATE_TIME = ENTITY_DATE_FORMAT;
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private java.lang.Integer id;
	@Length(max=100)
	private java.lang.String metadataNum;
	@Length(max=100)
	private java.lang.String metadataModelNum;
	@Length(max=50)
	private java.lang.String dataField;
	@Length(max=10)
	private java.lang.Integer dataSize;
	@Length(max=50)
	private java.lang.String dataKey;
	@Length(max=50)
	private java.lang.String dataPath;
	@Length(max=50)
	private java.lang.String dataType;
	@Length(max=50)
	private java.lang.String dataAttr;
	@Length(max=50)
	private java.lang.String dataValue="";
	@Length(max=50)
	private java.lang.String dataFormat;
	@Length(max=100)
	private java.lang.String tempNum;
	@Length(max=100)
	private java.lang.String dataFilter;
	
	private java.lang.Integer createTime;
	
	private java.lang.Integer updateTime;
	@Length(max=200)
	private java.lang.String memo;
	//columns END


	public Metadata(){
	}

	public Metadata(
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
	
	@Column(name = "metadata_num", unique = true, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getMetadataNum() {
		return this.metadataNum;
	}
	
	public void setMetadataNum(java.lang.String value) {
		this.metadataNum = value;
	}
	
	@Column(name = "metadata_model_num", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getMetadataModelNum() {
		return this.metadataModelNum;
	}
	
	public void setMetadataModelNum(java.lang.String value) {
		this.metadataModelNum = value;
	}
	
	@Column(name = "data_field", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getDataField() {
		return this.dataField;
	}
	
	public void setDataField(java.lang.String value) {
		this.dataField = value;
	}
	
	@Column(name = "data_size", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getDataSize() {
		return dataSize;
	}

	public void setDataSize(java.lang.Integer dataSize) {
		this.dataSize = dataSize;
	}

	@Column(name = "data_key", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getDataKey() {
		return this.dataKey;
	}
	
	public void setDataKey(java.lang.String value) {
		this.dataKey = value;
	}
	
	@Column(name = "data_path", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getDataPath() {
		return this.dataPath;
	}
	
	public void setDataPath(java.lang.String value) {
		this.dataPath = value;
	}
	
	@Column(name = "data_type", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getDataType() {
		return this.dataType;
	}
	
	public void setDataType(java.lang.String value) {
		this.dataType = value;
	}
	
	@Column(name = "data_attr", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getDataAttr() {
		return this.dataAttr;
	}
	
	public void setDataAttr(java.lang.String value) {
		this.dataAttr = value;
	}
	
	@Column(name = "data_value", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getDataValue() {
		return this.dataValue;
	}
	
	public void setDataValue(java.lang.String value) {
		this.dataValue = value;
	}
	
	@Column(name = "data_format", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getDataFormat() {
		return this.dataFormat;
	}
	
	public void setDataFormat(java.lang.String value) {
		this.dataFormat = value;
	}
	
	@Column(name = "temp_num", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getTempNum() {
		return this.tempNum;
	}
	
	public void setTempNum(java.lang.String value) {
		this.tempNum = value;
	}
	
	@Column(name = "data_filter", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getDataFilter() {
		return this.dataFilter;
	}
	
	public void setDataFilter(java.lang.String value) {
		this.dataFilter = value;
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
	
	@Column(name = "memo", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getMemo() {
		return this.memo;
	}
	
	public void setMemo(java.lang.String value) {
		this.memo = value;
	}
	

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("MetadataNum",getMetadataNum())
			.append("MetadataModelNum",getMetadataModelNum())
			.append("DataField",getDataField())
			.append("DataSize",getDataSize())
			.append("DataKey",getDataKey())
			.append("DataPath",getDataPath())
			.append("DataType",getDataType())
			.append("DataAttr",getDataAttr())
			.append("DataValue",getDataValue())
			.append("DataFormat",getDataFormat())
			.append("TempNum",getTempNum())
			.append("DataFilter",getDataFilter())
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
		if(obj instanceof Metadata == false) return false;
		if(this == obj) return true;
		Metadata other = (Metadata)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

