package com.taoxiha.base.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.taoxiha.common.utils.log.LogUtils;

public class LogFilter extends HandlerInterceptorAdapter {

	private ThreadLocal<Long> local = new ThreadLocal<Long>();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		local.set(System.currentTimeMillis());
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		LogUtils.webLog(BaseCtrl.getBackLog(request));
	}
}
