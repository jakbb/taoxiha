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
@Table(name = "resource_conf")
public class ResourceConf extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	//cache prefix
	public static final String TABLE_CACHE_PREFIX=CACHE_APP_NAME.concat("cache-table-resource_conf-");
	//alias
	public static final String TABLE_ALIAS = "ResourceConf";
	public static final String TABLE_NAME = "resource_conf";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_RESOURCE_CONF_NUM = "源数据抓取编号";
	public static final String ALIAS_RESOURCE_NAME = "resourceName";
	public static final String ALIAS_RESOURCE_DESC = "resourceDesc";
	public static final String ALIAS_STATUS = "备注";
	public static final String ALIAS_CREATE_TIME = "create_time";
	public static final String ALIAS_UPDATE_TIME = "更新时间";
	
	//date formats
	public static final String FORMAT_CREATE_TIME = ENTITY_DATE_FORMAT;
	public static final String FORMAT_UPDATE_TIME = ENTITY_DATE_FORMAT;
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private java.lang.Integer id;
	@Length(max=100)
	private java.lang.String resourceConfNum;
	@Length(max=100)
	private java.lang.String resourceName;
	@Length(max=100)
	private java.lang.String resourceDesc;
	@Length(max=200)
	private java.lang.String status;
	
	private java.lang.Integer createTime;
	
	private java.lang.Integer updateTime;
	//columns END


	public ResourceConf(){
	}

	public ResourceConf(
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
	
	@Column(name = "resource_conf_num", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getResourceConfNum() {
		return this.resourceConfNum;
	}
	
	public void setResourceConfNum(java.lang.String value) {
		this.resourceConfNum = value;
	}
	
	@Column(name = "resource_name", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getResourceName() {
		return this.resourceName;
	}
	
	public void setResourceName(java.lang.String value) {
		this.resourceName = value;
	}
	
	@Column(name = "resource_desc", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getResourceDesc() {
		return this.resourceDesc;
	}
	
	public void setResourceDesc(java.lang.String value) {
		this.resourceDesc = value;
	}
	
	@Column(name = "status", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getStatus() {
		return this.status;
	}
	
	public void setStatus(java.lang.String value) {
		this.status = value;
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
			.append("ResourceConfNum",getResourceConfNum())
			.append("ResourceName",getResourceName())
			.append("ResourceDesc",getResourceDesc())
			.append("Status",getStatus())
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
		if(obj instanceof ResourceConf == false) return false;
		if(this == obj) return true;
		ResourceConf other = (ResourceConf)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

