package com.springlesson.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.springlesson.domain.LoginVo;

public class AjaxAuthorCheckInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(AjaxAuthorCheckInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//통신 방식이 POST와 GET을 제외하고 글쓴이만 수정 삭제 체크해라.
		//넘겨주는 값은 {\"login\":=-3}으로
		logger.info("====================AjaxAuthorCheckInterceptor===============================");
		LoginVo loginVo = (LoginVo)WebUtils.getSessionAttribute(request, "LoginVo");
		boolean author = false;
		String req_method = request.getMethod();
		if(req_method.equals("GET") || req_method.equals("POST")){
			author = true;
		}else{
			if(loginVo!=null){
				if(loginVo.getNum()==Integer.parseInt(request.getParameter("mem_num"))){
					author = true;						
				}else{
					response.setContentType("application/json; charset=utf-8");
					response.getWriter().append("{\"login\":-3}").flush();;
				}
			}else{
				response.setContentType("application/json; charset=utf-8");
				response.getWriter().append("{\"login\":-2}").flush();;
			}
		}
		return author;
	}//end
}//class end
