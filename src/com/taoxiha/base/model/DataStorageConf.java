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
@Table(name = "data_storage_conf")
public class DataStorageConf extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	//cache prefix
	public static final String TABLE_CACHE_PREFIX=CACHE_APP_NAME.concat("cache-table-data_storage_conf-");
	//alias
	public static final String TABLE_ALIAS = "DataStorageConf";
	public static final String TABLE_NAME = "data_storage_conf";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STORAGE_CONF_NUM = "storageConfNum";
	public static final String ALIAS_STORAGE_TYPE = "1 存缓存 2 存文件 3 存数据库 4 存分布式文件管理系统";
	public static final String ALIAS_STORAGE_RULE = "0 文件以数字序列命名存储 1 以docid存储 2 以时间精确到秒存储             ";
	public static final String ALIAS_STORAGE_PATH = "storagePath";
	public static final String ALIAS_STORAGE_FORMAT = "0 json 1 xml 2  竖线分割字符串";
	public static final String ALIAS_FILTER_WORDS = "filterWords";
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
	private java.lang.String storageConfNum;
	
	private java.lang.Integer storageType;
	@Length(max=50)
	private java.lang.String storageRule;
	@Length(max=50)
	private java.lang.String storagePath;
	
	private java.lang.Integer storageFormat;
	@Length(max=50)
	private java.lang.String filterWords;
	
	private java.lang.Integer createTime;
	
	private java.lang.Integer updateTime;
	@Length(max=500)
	private java.lang.String memo;
	//columns END


	public DataStorageConf(){
	}

	public DataStorageConf(
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
	
	@Column(name = "storage_conf_num", unique = true, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getStorageConfNum() {
		return this.storageConfNum;
	}
	
	public void setStorageConfNum(java.lang.String value) {
		this.storageConfNum = value;
	}
	
	@Column(name = "storage_type", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getStorageType() {
		return this.storageType;
	}
	
	public void setStorageType(java.lang.Integer value) {
		this.storageType = value;
	}
	
	@Column(name = "storage_rule", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getStorageRule() {
		return this.storageRule;
	}
	
	public void setStorageRule(java.lang.String value) {
		this.storageRule = value;
	}
	
	@Column(name = "storage_path", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getStoragePath() {
		return this.storagePath;
	}
	
	public void setStoragePath(java.lang.String value) {
		this.storagePath = value;
	}
	
	@Column(name = "storage_format", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getStorageFormat() {
		return this.storageFormat;
	}
	
	public void setStorageFormat(java.lang.Integer value) {
		this.storageFormat = value;
	}
	
	@Column(name = "filter_words", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getFilterWords() {
		return this.filterWords;
	}
	
	public void setFilterWords(java.lang.String value) {
		this.filterWords = value;
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
			.append("StorageConfNum",getStorageConfNum())
			.append("StorageType",getStorageType())
			.append("StorageRule",getStorageRule())
			.append("StoragePath",getStoragePath())
			.append("StorageFormat",getStorageFormat())
			.append("FilterWords",getFilterWords())
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
		if(obj instanceof DataStorageConf == false) return false;
		if(this == obj) return true;
		DataStorageConf other = (DataStorageConf)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

