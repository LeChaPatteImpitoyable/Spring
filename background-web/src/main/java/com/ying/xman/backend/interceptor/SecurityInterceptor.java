package com.ying.xman.backend.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SecurityInterceptor implements HandlerInterceptor {

	private static final Logger LOG = LoggerFactory.getLogger(SecurityInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		LOG.info("======================================pre");
//		// 处理url
		String reqUrl = request.getRequestURI();

		LOG.info("reqUrl ---> " + (StringUtils.isEmpty(reqUrl) ? "--NULL--" : reqUrl));


		return true;
	}

}
