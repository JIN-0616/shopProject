package com.springlesson.interceptor;

import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springlesson.domain.LoginVo;

public class CookieLoginInterceptor extends HandlerInterceptorAdapter{
	private static final Logger logger = LoggerFactory.getLogger(CookieLoginInterceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//String loginJson = loginCookieVal;
		logger.info("============================================preHandle==============================");
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		String loginJson=null;
		if(loginCookie!=null){
			loginJson= loginCookie.getValue();
		}
		logger.info(loginJson+"");
		if(loginJson!=null){
			ObjectMapper loginObject = new ObjectMapper();
			LoginVo loginVo = loginObject.readValue(URLDecoder.decode(loginJson, "UTF-8"), LoginVo.class);
			logger.info(loginVo.getId()+"");
			request.getSession().setAttribute("LoginVo", loginVo);
			return true;
		}else{
			response.sendRedirect(request.getContextPath()+"/");
			return false;
		}
	}//end
	
}//class end
