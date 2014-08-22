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
@Table(name = "metadata_template_model")
public class DataTemplateModel extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	//cache prefix
	public static final String TABLE_CACHE_PREFIX=CACHE_APP_NAME.concat("cache-table-metadata_template_model-");
	//alias
	public static final String TABLE_ALIAS = "DataTemplateModel";
	public static final String TABLE_NAME = "metadata_template_model";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_TEMP_NUM = "模板编号";
	public static final String ALIAS_DATA_TYPE = "html, json,xml,logfile";
	public static final String ALIAS_DATA_INFO = "dataInfo";
	public static final String ALIAS_TEMP_ADDRESS = "tempAddress";
	public static final String ALIAS_CREATE_TIME = "createTime";
	public static final String ALIAS_UPDATE_TIME = "updateTime";
	public static final String ALIAS_MEMO = "memo";
	
	//date formats
	public static final String FORMAT_CREATE_TIME = ENTITY_DATE_FORMAT;
	public static final String FORMAT_UPDATE_TIME = ENTITY_DATE_FORMAT;
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private java.lang.Integer id;
	@Length(max=50)
	private java.lang.String tempNum;
	@Length(max=50)
	private java.lang.String dataType;
	@Length(max=4000)
	private java.lang.String dataInfo;
	@Length(max=100)
	private java.lang.String tempAddress;
	
	private java.lang.Integer createTime;
	
	private java.lang.Integer updateTime;
	@Length(max=500)
	private java.lang.String memo;
	//columns END


	public DataTemplateModel(){
	}

	public DataTemplateModel(
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
	
	@Column(name = "temp_num", unique = true, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getTempNum() {
		return this.tempNum;
	}
	
	public void setTempNum(java.lang.String value) {
		this.tempNum = value;
	}
	
	@Column(name = "data_type", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getDataType() {
		return this.dataType;
	}
	
	public void setDataType(java.lang.String value) {
		this.dataType = value;
	}
	
	@Column(name = "data_info", unique = false, nullable = true, insertable = true, updatable = true, length = 4000)
	public java.lang.String getDataInfo() {
		return this.dataInfo;
	}
	
	public void setDataInfo(java.lang.String value) {
		this.dataInfo = value;
	}
	
	@Column(name = "temp_address", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getTempAddress() {
		return this.tempAddress;
	}
	
	public void setTempAddress(java.lang.String value) {
		this.tempAddress = value;
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
			.append("TempNum",getTempNum())
			.append("DataType",getDataType())
			.append("DataInfo",getDataInfo())
			.append("TempAddress",getTempAddress())
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
		if(obj instanceof DataTemplateModel == false) return false;
		if(this == obj) return true;
		DataTemplateModel other = (DataTemplateModel)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

