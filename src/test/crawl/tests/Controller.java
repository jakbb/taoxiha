package test.crawl.tests;

import com.taoxiha.common.crawl.crawler.CrawlConfig;
import com.taoxiha.common.crawl.crawler.CrawlController;
import com.taoxiha.common.crawl.fetcher.PageFetcher;
import com.taoxiha.common.crawl.robotstxt.RobotstxtConfig;
import com.taoxiha.common.crawl.robotstxt.RobotstxtServer;

public class Controller {
    public static void main(String[] args) throws Exception {
            String crawlStorageFolder = "/data/crawl/root";
            int numberOfCrawlers = 7;

            CrawlConfig config = new CrawlConfig();
            config.setMaxDepthOfCrawling(1);
            config.setCrawlStorageFolder(crawlStorageFolder);

            /*
             * Instantiate the controller for this crawl.
             */
            PageFetcher pageFetcher = new PageFetcher(config);
            RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
            RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
            CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

            /*
             * For each crawl, you need to add some seed urls. These are the first
             * URLs that are fetched and then the crawler starts following links
             * which are found in these pages
             */
            controller.addSeed("http://as.baidu.com/a/rank");
           /**
            controller.addSeed("http://www.anzhi.com/");
            controller.addSeed("http://m.baidu.com/s?word=%E5%BA%94%E7%94%A8%E5%B8%82%E5%9C%BA&st=10a081&tn=webmkt&pn=10&rn=10&tj=search_0_web&f=web_alad_5@next");
            controller.addSeed("http://www.appchina.com/top/index.html");
            controller.addSeed("http://app.sohu.com/list_hot/0/92-1.html");
           **/
            /*
             * Start the crawl. This is a blocking operation, meaning that your code
             * will reach the line after this only when crawling is finished.
             */
            controller.start(MyCrawler.class, numberOfCrawlers);
            
            controller.waitUntilFinish();
            
            System.out.println("finished");
            
    }
}