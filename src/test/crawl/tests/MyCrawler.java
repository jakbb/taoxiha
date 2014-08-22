package test.crawl.tests;

import java.util.List;
import java.util.regex.Pattern;

import com.taoxiha.common.crawl.crawler.Page;
import com.taoxiha.common.crawl.crawler.WebCrawler;
import com.taoxiha.common.crawl.parser.HtmlParseData;
import com.taoxiha.common.crawl.url.WebURL;
import com.taoxiha.common.utils.log.LogUtils;

public class MyCrawler extends WebCrawler {
	
	
    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g" 
                                                      + "|png|tiff?|mid|mp2|mp3|mp4"
                                                      + "|wav|avi|mov|mpeg|ram|m4v|pdf" 
                                                      + "|rm|smil|wmv|swf|wma|zip|rar|gz|apk))$");

    /**
     * You should implement this function to specify whether
     * the given url should be crawled or not (based on your
     * crawling logic).
     */
    @Override
    public boolean shouldVisit(WebURL url) {
            String href = url.getURL().toLowerCase();
//            System.out.println("href  : "+href);
            String parentUrl=url.getParentUrl();
            if(parentUrl.contains("item?docid=")){
            	return false;
            }
//            !FILTERS.matcher(href).matches(); 
          return href.contains("item?docid=") || href.contains("rank?cid=");
           
//           && href.startsWith("http://www.ics.uci.edu/");
    }

    /**
     * This function is called when a page is fetched and ready 
     * to be processed by your program.
     */
    private  static int  count=0;
    
    private synchronized void countAdd(){
    	count++;
    }
    
    @Override
    public void visit(Page page) {          
            String url = page.getWebURL().getURL();
            System.out.println("parentURL: " + page.getWebURL().getParentUrl());

            System.out.println("URL: " + url);
            if(url.contains("item?docid=")){
            	countAdd();
            	System.out.println("count "+ count);
            }
            System.out.println("ContentCharset: "+page.getContentCharset());
            
            if (page.getParseData() instanceof HtmlParseData) {
                    HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
                    String text = htmlParseData.getText();
                    String html = htmlParseData.getHtml();
                    List<WebURL> links = htmlParseData.getOutgoingUrls();
                    LogUtils.dataLog(html);
                    System.out.println("Text length: " + text);
                    System.out.println("Html length: " + html.length());
                    System.out.println("Number of outgoing links: " + links.size());
            }
    }
}