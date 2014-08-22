package com.taoxiha.common.utils.apkresolve;

import java.math.BigDecimal;


/**
 * 对应APK安装包的信息
 * 
 * @author Jason
 * 
 */
public class APK {
	private String name;
	private String packageName;
	private String versionCode;
	private String versionName;
	private String iconPath;
	private float size;
	private String sdkVersion;
	private long bytes;
	private byte[] iconBytes;

	public String getSdkVersion() {
		return sdkVersion;
	}

	public void setSdkVersion(String sdkVersion) {
		this.sdkVersion = sdkVersion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	
	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public long getBytes() {
		return bytes;
	}

	public void setBytes(long bytes) {
		this.bytes = bytes;
		BigDecimal res = new BigDecimal(bytes).divide(new BigDecimal(1024*1024)).setScale(2,BigDecimal.ROUND_DOWN);
		size = res.floatValue();
	}

	public byte[] getIconBytes() {
		return iconBytes;
	}

	public void setIconBytes(byte[] iconBytes) {
		this.iconBytes = iconBytes;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("{");
		str.append("name=").append(name).append(",");
		str.append("packageName=").append(packageName).append(",");
		str.append("versionCode=").append(versionCode).append(",");
		str.append("versionName=").append(versionName).append(",");
		str.append("iconPath=").append(iconPath).append(",");
		str.append("iconBytes=").append(iconBytes).append(",");
		str.append("sdkVersion=").append(sdkVersion).append(",");
		str.append("size=").append(size).append(",");
		str.append("bytes=").append(bytes);
		str.append("}");
		return str.toString();
	}
}
