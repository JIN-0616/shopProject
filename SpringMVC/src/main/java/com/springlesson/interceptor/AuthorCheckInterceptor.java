package com.springlesson.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.springlesson.domain.LoginVo;

public class AuthorCheckInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean author = false;
		//request.getSession().getAttribute("LoginVo");
		LoginVo loginVo = null;
		loginVo = (LoginVo)WebUtils.getSessionAttribute(request, "LoginVo");
		String memId = request.getParameter("mem_id");
		if(loginVo != null){
			if(loginVo.getId().equals(memId)){
				author = true;
			}else{
				response.setContentType("text/html; charset=utf-8");
				response.getWriter().append("<script>"
										  + "alert('작성자만 수정 삭제 가능합니다.');"
										  + "window.history.back();"
										  + "</script>").flush();
			}
		}
		return author;
	}//end
}//class end
