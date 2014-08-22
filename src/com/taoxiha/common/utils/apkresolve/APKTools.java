package com.taoxiha.common.utils.apkresolve;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.taoxiha.common.utils.io.FileHelper;
import com.taoxiha.common.utils.io.FileUtils;
import com.taoxiha.common.utils.io.IOUtil;

public class APKTools {

	/**
	 * 获取APK安装包信息
	 * @throws IOException 
	 */
	public static APK getAPK(String apkPath,String aaptPath) throws IOException {
		APK apk = null;
		String cmd = aaptPath + " dump badging " + apkPath;
		Runtime run = Runtime.getRuntime();
		Process process = run.exec(cmd);
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader buffer = new BufferedReader(isr);
		StringBuilder str = new StringBuilder();
		String line = null;
		while ((line = buffer.readLine()) != null) {
			str.append(line);
		}
		buffer.close();
		isr.close();
		is.close();
		process.destroy();
		
		String content = str.toString();
//		System.out.println(content);
		String packageName = "";
		String versionCode = "";
		String versionName = "";
		String iconPath = "";
		String sdkVersion = "1";
		String name = "";
		
		Matcher mat = Pattern.compile("package: name='(.*?)'", Pattern.CASE_INSENSITIVE).matcher(content);
		if(mat.find()){
			packageName = mat.group(1);
		}
		
		mat = Pattern.compile("versionCode='(\\d*?)'", Pattern.CASE_INSENSITIVE).matcher(content);
		if(mat.find()){
			versionCode = mat.group(1);
		}
		
		mat = Pattern.compile("versionName='(.*?)'", Pattern.CASE_INSENSITIVE).matcher(content);
		if(mat.find()){
			versionName = mat.group(1);
		}
		
		mat = Pattern.compile("application-label:'(.*?)'", Pattern.CASE_INSENSITIVE).matcher(str);
		if(mat.find()){
			name = mat.group(1);
		}
		
		mat = Pattern.compile("icon='(.*?)'", Pattern.CASE_INSENSITIVE).matcher(content);
		if(mat.find()){
			iconPath = mat.group(1);
		}
		
		mat = Pattern.compile("sdkVersion:'(.*?)'", Pattern.CASE_INSENSITIVE).matcher(content);
		if(mat.find()){
			sdkVersion = mat.group(1);
		}

		apk = new APK();
		apk.setName(name);
		apk.setIconPath(iconPath);
		apk.setPackageName(packageName);
		apk.setVersionCode(versionCode);
		apk.setVersionName(versionName);
		apk.setSdkVersion(sdkVersion);
		apk.setBytes(new File(apkPath).length());
		apk.setIconBytes(getIcon(apkPath,iconPath));
		
		return apk;
	}

	public static byte[] getIcon(String apkPath, String iconPath) throws IOException {
		ZipEntry entry = null; // 得到zip包中文件
		ZipFile zf = new ZipFile(apkPath);
		Enumeration<?> enu = zf.entries();
		while (enu.hasMoreElements()) {
			entry = (ZipEntry) enu.nextElement();
			if (entry.getName().equalsIgnoreCase(iconPath)) {
				break;
			}else{
				entry = null;
			}
		}
		if(entry == null) return null;
		
		InputStream in = zf.getInputStream(entry);
		ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
		byte[] b = new byte[1024];
		int length = -1;
		length = in.read(b);
		while (length != -1) {
			bytestream.write(b,0,length);
			length = in.read(b);
		}
		in.close();
		b = bytestream.toByteArray();
		bytestream.close();
		zf.close();
		return b;
	}

	public static void main(String[] args) throws IOException {
		String apkPath = "/Users/apple/Downloads/wai_jianghu.0.1.2.apk";
		APK apk = getAPK(apkPath, "/Users/apple/soft/android-sdk-macosx2/platform-tools/aapt");
		System.out.println(apk);
		System.out.println(apk.getIconBytes().length);
		OutputStream out = new FileOutputStream(new File("/data/file03.icon"));
		out.write(apk.getIconBytes(), 0, apk.getIconBytes().length);
		out.flush();
		out.close();
		System.out.println(System.getProperty("os.name"));
	}
}
