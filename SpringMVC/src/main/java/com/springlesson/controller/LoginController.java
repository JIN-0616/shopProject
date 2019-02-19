package com.springlesson.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springlesson.domain.Member;
import com.springlesson.service.MemberService;

@Controller
public class LoginController {
	
	@Inject
	private MemberService service;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginForm(){
		return "login/LoginForm";
	}//end
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(Member mem, HttpSession session, RedirectAttributes rttr
			, HttpServletResponse res, @CookieValue(value="idCookie",required=false) String idCookieVal) throws Exception{
		
	   return null;
	}
	
	
	
}//class End

