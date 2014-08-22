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

package com.taoxiha.service.crawl.entity;

import java.io.Serializable;

public class CrawlResult implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/*private static ThreadLocal<CrawlResult> instanceMap = new ThreadLocal<CrawlResult>();  
	
	 *//** 
     * 得到与当前线程相关的，当前类的实例 
     *//*  
    public static synchronized CrawlResult getInstance(){  
    	CrawlResult instance = instanceMap.get();  
        if(null == instance){  
            instance = new CrawlResult();  
            instanceMap.set(instance);  
        }  
        return instance;  
    }
    
    public static synchronized void setInstance(CrawlResult result){
    	if(null != result){
    		instanceMap.set(result);
    	}
    }*/
	
	private int pages;
	private long links;
	private long textSize;
	private long htmlSize;
	private String sourceNum;
	
	public CrawlResult(){}
	
	public void pageAdd(){
		pages++;
	}
	
	public String getSourceNum() {
		return sourceNum;
	}

	public void setSourceNum(String sourceNum) {
		this.sourceNum = sourceNum;
	}

	public void linksAdd(int addSize){
		this.links+=addSize;
	}
	
	public void textSizeAdd(int addSize){
		this.textSize+=addSize;
	}
	
	public void htmlSizeAdd(int addSize){
		this.htmlSize+=addSize;
	}
	
	
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public long getLinks() {
		return links;
	}
	public void setLinks(long links) {
		this.links = links;
	}
	public long getTextSize() {
		return textSize;
	}
	public void setTextSize(long textSize) {
		this.textSize = textSize;
	}
	public long getHtmlSize() {
		return htmlSize;
	}
	public void setHtmlSize(long htmlSize) {
		this.htmlSize = htmlSize;
	}

	@Override
	public String toString() {
		return "CrawlResult [pages=" + pages + ", links=" + links
				+ ", textSize=" + textSize + ", htmlSize=" + htmlSize
				+ ", sourceNum=" + sourceNum + "]";
	}
	
}
