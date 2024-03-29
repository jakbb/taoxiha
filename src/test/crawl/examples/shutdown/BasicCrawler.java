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

package test.crawl.examples.shutdown;

import java.util.List;
import java.util.regex.Pattern;

import com.taoxiha.common.crawl.crawler.Page;
import com.taoxiha.common.crawl.crawler.WebCrawler;
import com.taoxiha.common.crawl.parser.HtmlParseData;
import com.taoxiha.common.crawl.url.WebURL;

/**
 * @author Yasser Ganjisaffar <lastname at gmail dot com>
 */

public class BasicCrawler extends WebCrawler {

	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g" + "|png|tiff?|mid|mp2|mp3|mp4"
			+ "|wav|avi|mov|mpeg|ram|m4v|pdf" + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

	private final static String DOMAIN = "http://www.ics.uci.edu/";

	@Override
	public boolean shouldVisit(WebURL url) {
		String href = url.getURL().toLowerCase();
		return !FILTERS.matcher(href).matches() && href.startsWith(DOMAIN);
	}

	@Override
	public void visit(Page page) {
		int docid = page.getWebURL().getDocid();
		String url = page.getWebURL().getURL();
		int parentDocid = page.getWebURL().getParentDocid();

		System.out.println("Docid: " + docid);
		System.out.println("URL: " + url);
		System.out.println("Docid of parent page: " + parentDocid);

		if (page.getParseData() instanceof HtmlParseData) {
			HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
			String text = htmlParseData.getText();
			String html = htmlParseData.getHtml();
			List<WebURL> links = htmlParseData.getOutgoingUrls();

			System.out.println("Text length: " + text.length());
			System.out.println("Html length: " + html.length());
			System.out.println("Number of outgoing links: " + links.size());
		}

		System.out.println("=============");
	}
}
