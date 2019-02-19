package com.springlesson.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.springlesson.domain.LoginVo;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter{
	// /member/* 요청을 검사해서 admin = 1인 사람만 접근할 수 있도록 해라.
	private static final Logger logger = LoggerFactory.getLogger(AdminCheckInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//LoginVo loginVo = (LoginVo)request.getSession().getAttribute("LoginVo");
		boolean adminCheck = false;
		LoginVo loginVo = (LoginVo)WebUtils.getSessionAttribute(request, "LoginVo");
		if(loginVo!=null){
			if(loginVo.getAdmin() == '1'){
				adminCheck = true;
			}
		}else{
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().append("<script>"
									  + "alert('로그인 후 이용할 수 있습니다.');"
									  + "window.location = '"+request.getContextPath()+"/login.do';"
									  + "</script>").flush();		
		}
		return adminCheck;
	}//end
	
	
	/*
       else{
				response.setContentType("text/html; charset=utf-8");
				response.getWriter().append("<script>"
										  + "alert('관리자권한이 없습니다.');"
										  + "window.history.back();"
										  + "</script>").flush();
			}	 */
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}//end
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}//end
}//class end