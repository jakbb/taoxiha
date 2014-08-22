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
@Table(name = "ip_proxy_pool")
public class IpProxyPool extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	//cache prefix
	public static final String TABLE_CACHE_PREFIX=CACHE_APP_NAME.concat("cache-table-ip_proxy_pool-");
	//alias
	public static final String TABLE_ALIAS = "IpProxyPool";
	public static final String TABLE_NAME = "ip_proxy_pool";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_PROXY_IP = "proxyIp";
	public static final String ALIAS_PROXY_ACCOUNT = "proxyAccount";
	public static final String ALIAS_PROXY_PWD = "proxyPwd";
	public static final String ALIAS_STATUS = "status";
	public static final String ALIAS_CREATE_TIME = "createTime";
	public static final String ALIAS_MEMO = "memo";
	
	//date formats
	public static final String FORMAT_CREATE_TIME = ENTITY_DATE_FORMAT;
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private java.lang.Integer id;
	@Length(max=50)
	private java.lang.String proxyIp;
	@Length(max=50)
	private java.lang.String proxyAccount;
	@Length(max=50)
	private java.lang.String proxyPwd;
	
	private java.lang.Integer status;
	
	private java.lang.Integer createTime;
	@Length(max=100)
	private java.lang.String memo;
	//columns END


	public IpProxyPool(){
	}

	public IpProxyPool(
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
	
	@Column(name = "proxy_ip", unique = true, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getProxyIp() {
		return this.proxyIp;
	}
	
	public void setProxyIp(java.lang.String value) {
		this.proxyIp = value;
	}
	
	@Column(name = "proxy_account", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getProxyAccount() {
		return this.proxyAccount;
	}
	
	public void setProxyAccount(java.lang.String value) {
		this.proxyAccount = value;
	}
	
	@Column(name = "proxy_pwd", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getProxyPwd() {
		return this.proxyPwd;
	}
	
	public void setProxyPwd(java.lang.String value) {
		this.proxyPwd = value;
	}
	
	@Column(name = "status", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(java.lang.Integer value) {
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
	
	@Column(name = "memo", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getMemo() {
		return this.memo;
	}
	
	public void setMemo(java.lang.String value) {
		this.memo = value;
	}
	

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("ProxyIp",getProxyIp())
			.append("ProxyAccount",getProxyAccount())
			.append("ProxyPwd",getProxyPwd())
			.append("Status",getStatus())
			.append("CreateTime",getCreateTime())
			.append("Memo",getMemo())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof IpProxyPool == false) return false;
		if(this == obj) return true;
		IpProxyPool other = (IpProxyPool)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

