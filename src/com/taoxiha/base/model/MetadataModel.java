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
@Table(name = "metadata_model")
public class MetadataModel extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	//cache prefix
	public static final String TABLE_CACHE_PREFIX=CACHE_APP_NAME.concat("cache-table-metadata_model-");
	//alias
	public static final String TABLE_ALIAS = "MetadataModel";
	public static final String TABLE_NAME = "metadata_model";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_METADATA_MODEL_NUM = "metadataModelNum";
	public static final String ALIAS_MODEL_NAME = "modelName";
	public static final String ALIAS_MODEL_DESC = "modelDesc";
	public static final String ALIAS_CREATE_TIME = "createTime";
	public static final String ALIAS_UPDATE_TIME = "updateTime";
	
	//date formats
	public static final String FORMAT_CREATE_TIME = ENTITY_DATE_FORMAT;
	public static final String FORMAT_UPDATE_TIME = ENTITY_DATE_FORMAT;
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private java.lang.Integer id;
	@Length(max=50)
	private java.lang.String metadataModelNum;
	@Length(max=100)
	private java.lang.String modelName;
	@Length(max=100)
	private java.lang.String modelDesc;
	
	private java.lang.Integer createTime;
	
	private java.lang.Integer updateTime;
	//columns END


	public MetadataModel(){
	}

	public MetadataModel(
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
	
	@Column(name = "metadata_model_num", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getMetadataModelNum() {
		return this.metadataModelNum;
	}
	
	public void setMetadataModelNum(java.lang.String value) {
		this.metadataModelNum = value;
	}
	
	@Column(name = "model_name", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getModelName() {
		return this.modelName;
	}
	
	public void setModelName(java.lang.String value) {
		this.modelName = value;
	}
	
	@Column(name = "model_desc", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getModelDesc() {
		return this.modelDesc;
	}
	
	public void setModelDesc(java.lang.String value) {
		this.modelDesc = value;
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
	

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("MetadataModelNum",getMetadataModelNum())
			.append("ModelName",getModelName())
			.append("ModelDesc",getModelDesc())
			.append("CreateTime",getCreateTime())
			.append("UpdateTime",getUpdateTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof MetadataModel == false) return false;
		if(this == obj) return true;
		MetadataModel other = (MetadataModel)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

