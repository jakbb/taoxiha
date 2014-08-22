package com.taoxiha.base.query;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.taoxiha.base.BaseEntity;
import com.taoxiha.base.BaseQuery;
import com.taoxiha.base.model.IpProxyPool;



public class IpProxyPoolQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** id */
	private java.lang.Integer id;
	/** proxyIp */
	private java.lang.String proxyIp;
	/** proxyAccount */
	private java.lang.String proxyAccount;
	/** proxyPwd */
	private java.lang.String proxyPwd;
	/** status */
	private java.lang.Integer status;
	/** createTime */
	private java.lang.String createTimeBeginString;
	private java.lang.String createTimeEndString;
	
	/** memo */
	private java.lang.String memo;

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.String getProxyIp() {
		return this.proxyIp;
	}
	
	public void setProxyIp(java.lang.String value) {
		this.proxyIp = value;
	}
	
	public java.lang.String getProxyAccount() {
		return this.proxyAccount;
	}
	
	public void setProxyAccount(java.lang.String value) {
		this.proxyAccount = value;
	}
	
	public java.lang.String getProxyPwd() {
		return this.proxyPwd;
	}
	
	public void setProxyPwd(java.lang.String value) {
		this.proxyPwd = value;
	}
	
	public java.lang.Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	

	public java.lang.Integer getCreateTimeBegin() {
		return BaseEntity.strToUnixTime(getCreateTimeBeginString(), IpProxyPool.FORMAT_CREATE_TIME);
	}
	
	public java.lang.String getCreateTimeBeginString() {
		return this.createTimeBeginString;
	}
	
	public void setCreateTimeBeginString(java.lang.String value) {
		this.createTimeBeginString = value;
	}	
	
	public java.lang.Integer getCreateTimeEnd() {
		return BaseEntity.strToUnixTime(getCreateTimeEndString(), IpProxyPool.FORMAT_CREATE_TIME);
	}
	
	public java.lang.String getCreateTimeEndString() {
		return this.createTimeEndString;
	}
	
	public void setCreateTimeEndString(java.lang.String value) {
		this.createTimeEndString = value;
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

