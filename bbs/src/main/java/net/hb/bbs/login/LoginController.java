package net.hb.bbs.login;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
	
	@Autowired
	LoginDAO loginDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="home.do",method=RequestMethod.GET)
	 public ModelAndView home(){
		ModelAndView mav = new ModelAndView("home");
		return mav;  //views/login.jsp문서
	}//end

	@RequestMapping(value="login.do",method=RequestMethod.GET)
	 public String login(Model model){
		return "login";  //views/login.jsp문서
	}//end
	//LoginVO dto, HttpServletResponse response, HttpSession session
	@RequestMapping(value="loginprocess.do", method=RequestMethod.POST)
	public ModelAndView loginprocess(HttpSession session,HttpServletResponse response, LoginVO dto) throws IOException	{
		String returnPageUrl = "";
		if(session.getAttribute("LOGIN") != null) {
			session.removeAttribute("LOGIN");
		}
		LoginVO vo = loginDAO.login(dto);
		
		if(vo != null) {
			session.setAttribute("LOGIN", vo);
			session.setAttribute("userid", vo.getUserid());
			returnPageUrl = "redirect:/list.do";
			//로그인전에 페이지 혹은 요청으로 이동 처리
			if(session.getAttribute("uri") != null) {
				returnPageUrl = (String)session.getAttribute("uri");
				session.removeAttribute("uri");
			}
		}else {
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().append("<script>"
							+ "alert('LoginController 아이디 비밀번호가 일치하지않습니다.');"
				        		 + "window.history.back();"
							  + "</script>").flush();
			returnPageUrl = "redirect:/login.do";
		}
		logger.info(returnPageUrl);
		ModelAndView mav = new ModelAndView("redirect:/"+returnPageUrl);
		return mav;
	}
	
	@RequestMapping(value="logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session){
		//세션 초기화
		session.invalidate(); 
		//시작페이지로 리다이렉트
		return "redirect:/index.jsp";
	}//end
	
}//LoginController class END