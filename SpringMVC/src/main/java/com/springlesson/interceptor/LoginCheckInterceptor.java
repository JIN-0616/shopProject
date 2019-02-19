package com.springlesson.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.springlesson.domain.LoginVo;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(LoginCheckInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("=======================preHandle start=========================");
		LoginVo loginVo = (LoginVo)request.getSession().getAttribute("LoginVo");
		if(loginVo!=null){
			return true;
		}else{
			response.sendRedirect(request.getContextPath()+"/errorLogin.do");
			return false;
		}
		//인터셉터가 두개 동작할 때 return true에서 문제가 발생한다.
		//문제가 있을 시 redirect -> return false;
	}//end
}//class end
