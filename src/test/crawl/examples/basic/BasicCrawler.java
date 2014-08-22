/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package test.crawl.examples.basic;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import test.crawl.examples.Utils;

import com.taoxiha.common.crawl.crawler.Page;
import com.taoxiha.common.crawl.crawler.WebCrawler;
import com.taoxiha.common.crawl.parser.HtmlParseData;
import com.taoxiha.common.crawl.url.WebURL;
import com.taoxiha.common.crawl.util.IO;
import com.taoxiha.common.utils.log.LogUtils;

/**
 * @author Yasser Ganjisaffar <lastname at gmail dot com>
 */
public class BasicCrawler extends WebCrawler {

	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g" + "|png|tiff?|mid|mp2|mp3|mp4"
			+ "|wav|avi|mov|mpeg|ram|m4v|pdf" + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

	
	private static File storageFolder;
	
	public static void configure(String storageFolderName) {
		storageFolder = new File(storageFolderName);
		if (!storageFolder.exists()) {
			storageFolder.mkdirs();
		}
	}
	
   String[] urlPath={"/a/item","s?pn="};
	/**
	 * You should implement this function to specify whether the given url
	 * should be crawled or not (based on your crawling logic).
	 */
	@Override
	public boolean shouldVisit(WebURL url) {
		boolean flag=false;
		String href = url.getURL().toLowerCase();
//		LogUtils.dataLog(href);
		for(String str:urlPath){
			if(href.contains(str)){
				flag=true;
				LogUtils.debug("flag: "+flag+"  anchor: "+url.getAnchor()+"  url: "+href);
				break;
			}
		}
		flag= !FILTERS.matcher(href).matches() && flag ;
		return flag;
	}

	/**
	 * This function is called when a page is fetched and ready to be processed
	 * by your program.
	 */
	@Override
	public void visit(Page page) {
		WebURL webURL=page.getWebURL();
		int docid = page.getWebURL().getDocid();
		String url = page.getWebURL().getURL();
		String domain = page.getWebURL().getDomain();
		String path = page.getWebURL().getPath();
		String subDomain = page.getWebURL().getSubDomain();
		String parentUrl = page.getWebURL().getParentUrl();
		String anchor = page.getWebURL().getAnchor();

/*		
		System.out.println("Docid: " + docid);
		System.out.println("URL: " + url);
		System.out.println("Domain: '" + domain + "'");
		System.out.println("Sub-domain: '" + subDomain + "'");
		System.out.println("Path: '" + path + "'");
		System.out.println("Parent page: " + parentUrl);
		System.out.println("Anchor text: " + anchor);
		*/
		
		if (page.getParseData() instanceof HtmlParseData) {
			HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
			String text = htmlParseData.getText();
			String html = htmlParseData.getHtml();
			List<WebURL> links = htmlParseData.getOutgoingUrls();
			LogUtils.dataLog("Links: " + url);

			/*
			for(WebURL webUrl:links){
				LogUtils.dataLog("outLinks:  "+webUrl.getURL().toLowerCase());
			}
			*/
			
			String title=htmlParseData.getTitle();
			System.out.println("Tile : " + title);
//			+"\n  Text :" +htmlParseData.getText());
			/*System.out.println("Text length: " + text.length());
			System.out.println("Html length: " + html.length());
			System.out.println("Number of outgoing links: " + links.size());*/
			System.out.println(" Url: "+url);
			int pageNum=0;
			if(url.contains("s?pn=")){
				String pn=url.substring(url.indexOf("pn=")+3, url.length());
				int num=Integer.valueOf(pn.split("&")[0]);
				pageNum=(num>pageNum)?num:pageNum;
			}
			LogUtils.dataLog("pageNum: " + pageNum);
			
			boolean flag=url.contains("/a/item?docid=");
			// store html
			if(flag){
				System.out.println("save Url: "+webURL.getURL().toLowerCase());
				anchor=Utils.replaceHtmlTag(anchor);
				LogUtils.dataLog("anchor: " + anchor);
			IO.writeBytesToFile(html.getBytes(), storageFolder.getAbsolutePath() + "/" + title+".html");
			}
		}

		/*Header[] responseHeaders = page.getFetchResponseHeaders();
		if (responseHeaders != null) {
			System.out.println("Response headers:");
			for (Header header : responseHeaders) {
				System.out.println("\t" + header.getName() + ": " + header.getValue());
			}
		}
		
		System.out.println("=============");*/
	}
	
	
	
	public static void main(String[] args) {
		String url="http://m.baidu.com/s?pn=401323&rn=10&st=10a081&tj=search_50_web&tn=webmkt&word=Android";
		
		Pattern patten = Pattern.compile("^?pn=(\\d+)");
		Matcher matcher=patten.matcher(url);
		if(matcher.find()){
			System.out.println(matcher.group(1));
			}
		
		String pn=url.substring(url.indexOf("pn=")+3, url.length());
		System.out.println(pn.split("&")[0]);
}
	
}
