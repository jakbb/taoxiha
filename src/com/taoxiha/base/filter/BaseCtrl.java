package com.taoxiha.base.filter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.taoxiha.common.crawl.crawler.Page;
import com.taoxiha.common.utils.SpringHelper;
import com.taoxiha.common.utils.log.LogUtils;

@Controller
public abstract class BaseCtrl {
	private static final String JSON_CONTENT_TYPE = "application/json;charset=UTF-8";
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(Exception ex, HttpServletRequest request, HttpServletResponse response) {
		LogUtils.errorLog(ex.getMessage(),ex);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("e", ex);
		return new ModelAndView("user/error", map);
	}
	
	    public String getMessage(String message){
	    	AbstractMessageSource messageSource =(AbstractMessageSource)SpringHelper.getBean("messageSource");
	       return messageSource.getMessage(message, null, new Locale("zh_CN"));
	    }
	    
		 public static String getBackLog(HttpServletRequest request){
			 Map<?, ?> map=request.getParameterMap();
				StringBuffer res=new StringBuffer();
				if(map!=null && map.size()>0){
					Iterator<?> it = map.entrySet().iterator();  
			        while (it.hasNext()) {  
			            @SuppressWarnings("rawtypes")
						Map.Entry e = (Map.Entry) it.next(); 
			            String key=(String)e.getKey();
			            String value=((String[])e.getValue())[0];
			            res.append(key).append("=").append(value).append("&");
			        }    
				}
				return res.toString();
		 }
	  
		
		public static String getCookieValue(HttpServletRequest request , String cookieName){
			if(request.getCookies() != null){
				for (Cookie cookie : request.getCookies()) {
					if(cookie.getName().equals(cookieName)){
						return cookie.getValue();
					}
				}
			}
			return null;
		}
			
}
