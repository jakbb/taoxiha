package test.crawl.tests.netty;import java.util.concurrent.Future;import com.taoxiha.common.http.client.AsyncHttpClient;import com.taoxiha.common.http.client.Response;public class Test {			public static void main(String[] args) throws Exception {		//auto提示语//		String url="http://nssug.baidu.com/su?prod=wiseapp&ie=utf-8&wd=QQ";		//搜索//		String url="http://m.baidu.com/s?st=10a081&tn=webmkt&pn=0&word=xiha";		//ajax 获取app信息 		String url="http://as.baidu.com/a/ajax?docid=1358165";		AsyncHttpClient asyncHttpClient = new AsyncHttpClient();				Future<Response> f = asyncHttpClient.prepareGet(url).execute();		Response r = f.get();		String charset="utf-8";//				r.getContentType().split(";")[1].split("=")[1];//		System.out.println();		System.out.println(r.getResponseBody(charset));			}}