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
@Table(name = "data_source_pool")
public class DataSourcePool extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	//cache prefix
	public static final String TABLE_CACHE_PREFIX=CACHE_APP_NAME.concat("cache-table-data_source_pool-");
	//alias
	public static final String TABLE_ALIAS = "DataSourcePool";
	public static final String TABLE_NAME = "data_source_pool";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_SOURCE_NUM = "数据源编号";
	public static final String ALIAS_SOURCE_NAME = "数据源名称";
	public static final String ALIAS_METADATA_MODEL_NUM = "元数据模型编号";
	public static final String ALIAS_DATA_SOURCE = "数据地址";
	public static final String ALIAS_DATA_TYPE = "html, json,xml,logfile";
	public static final String ALIAS_REQ_TYPE = "请求方式 get post put delete ";
	public static final String ALIAS_REQ_PARAMS = "请求附带参数";
	public static final String ALIAS_URL_FILTERS = "以竖线分割  父级页面地址 | 数据访问页 |  数据下载页";
	public static final String ALIAS_SOURCE_DESC = "数据源描述";
	public static final String ALIAS_STATUS = "状态 0 不启用1 启用 ";
	public static final String ALIAS_RESOURCE_CONF_NUM = "源数据抓取编号";
	public static final String ALIAS_CRAWL_CONF_NUM = "抓取配置编号";
	public static final String ALIAS_STORAGE_CONF_NUM = "存储配置编号";
	public static final String ALIAS_INDEX_CONF_NUM = "索引配置编号";
	public static final String ALIAS_CREATE_TIME = "创建时间";
	public static final String ALIAS_UPDATE_TIME = "更新时间";
	
	//date formats
	public static final String FORMAT_CREATE_TIME = ENTITY_DATE_FORMAT;
	public static final String FORMAT_UPDATE_TIME = ENTITY_DATE_FORMAT;
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private java.lang.Integer id;
	@Length(max=100)
	private java.lang.String sourceNum;
	@Length(max=100)
	private java.lang.String sourceName;
	@Length(max=100)
	private java.lang.String metadataModelNum;
	@Length(max=100)
	private java.lang.String dataSource;
	@Length(max=50)
	private java.lang.String dataType;
	@Length(max=50)
	private java.lang.String reqType;
	@Length(max=100)
	private java.lang.String reqParams;
	@Length(max=100)
	private java.lang.String urlFilters;
	@Length(max=100)
	private java.lang.String sourceDesc;
	
	private java.lang.Integer status;
	@Length(max=100)
	private java.lang.String resourceConfNum;
	@Length(max=100)
	private java.lang.String crawlConfNum;
	@Length(max=100)
	private java.lang.String storageConfNum;
	@Length(max=100)
	private java.lang.String indexConfNum;
	
	private java.lang.Integer createTime;
	
	private java.lang.Integer updateTime;
	//columns END


	public DataSourcePool(){
	}

	public DataSourcePool(
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
	
	@Column(name = "source_num", unique = true, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getSourceNum() {
		return this.sourceNum;
	}
	
	public void setSourceNum(java.lang.String value) {
		this.sourceNum = value;
	}
	
	@Column(name = "source_name", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getSourceName() {
		return this.sourceName;
	}
	
	public void setSourceName(java.lang.String value) {
		this.sourceName = value;
	}
	
	@Column(name = "metadata_model_num", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getMetadataModelNum() {
		return this.metadataModelNum;
	}
	
	public void setMetadataModelNum(java.lang.String value) {
		this.metadataModelNum = value;
	}
	
	@Column(name = "data_source", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getDataSource() {
		return this.dataSource;
	}
	
	public void setDataSource(java.lang.String value) {
		this.dataSource = value;
	}
	
	@Column(name = "data_type", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getDataType() {
		return this.dataType;
	}
	
	public void setDataType(java.lang.String value) {
		this.dataType = value;
	}
	
	@Column(name = "req_type", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getReqType() {
		return this.reqType;
	}
	
	public void setReqType(java.lang.String value) {
		this.reqType = value;
	}
	
	@Column(name = "req_params", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getReqParams() {
		return this.reqParams;
	}
	
	public void setReqParams(java.lang.String value) {
		this.reqParams = value;
	}
	
	@Column(name = "url_filters", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getUrlFilters() {
		return this.urlFilters;
	}
	
	public void setUrlFilters(java.lang.String value) {
		this.urlFilters = value;
	}
	
	@Column(name = "source_desc", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getSourceDesc() {
		return this.sourceDesc;
	}
	
	public void setSourceDesc(java.lang.String value) {
		this.sourceDesc = value;
	}
	
	@Column(name = "status", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	
	@Column(name = "resource_conf_num", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getResourceConfNum() {
		return this.resourceConfNum;
	}
	
	public void setResourceConfNum(java.lang.String value) {
		this.resourceConfNum = value;
	}
	
	@Column(name = "crawl_conf_num", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getCrawlConfNum() {
		return this.crawlConfNum;
	}
	
	public void setCrawlConfNum(java.lang.String value) {
		this.crawlConfNum = value;
	}
	
	@Column(name = "storage_conf_num", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getStorageConfNum() {
		return this.storageConfNum;
	}
	
	public void setStorageConfNum(java.lang.String value) {
		this.storageConfNum = value;
	}
	
	@Column(name = "index_conf_num", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getIndexConfNum() {
		return this.indexConfNum;
	}
	
	public void setIndexConfNum(java.lang.String value) {
		this.indexConfNum = value;
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
			.append("SourceNum",getSourceNum())
			.append("SourceName",getSourceName())
			.append("MetadataModelNum",getMetadataModelNum())
			.append("DataSource",getDataSource())
			.append("DataType",getDataType())
			.append("ReqType",getReqType())
			.append("ReqParams",getReqParams())
			.append("UrlFilters",getUrlFilters())
			.append("SourceDesc",getSourceDesc())
			.append("Status",getStatus())
			.append("ResourceConfNum",getResourceConfNum())
			.append("CrawlConfNum",getCrawlConfNum())
			.append("StorageConfNum",getStorageConfNum())
			.append("IndexConfNum",getIndexConfNum())
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
		if(obj instanceof DataSourcePool == false) return false;
		if(this == obj) return true;
		DataSourcePool other = (DataSourcePool)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

