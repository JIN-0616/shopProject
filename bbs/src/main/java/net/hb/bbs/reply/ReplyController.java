package net.hb.bbs.reply;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReplyController {

	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Inject
	@Autowired
	ReplyDAO dao;

	@Autowired
	private ServletContext application;
	
	
	@RequestMapping("/reply_list.do")
	public ModelAndView reply_select(@RequestParam("idx") int idx) {
		ModelAndView mav = new ModelAndView();
		List<ReplyVO> rlist = dao.dbSelect(idx);
		if(rlist == null) {
			List<ReplyVO> a = null; 
			ReplyVO b = new ReplyVO();
			a.add(b);
			rlist = a;
		}
		mav.addObject("rlist", rlist);
		mav.setViewName("bbsReply");
		return mav;
	}
	
	@RequestMapping("/reply.do")
	public String reply_insert(ReplyVO vo) {
		logger.info(vo.toString());
		dao.dbInsert(vo);
		return "redirect:/detail.do?idx="+vo.getBr_sabun();
	}
	
	@RequestMapping("/reply_del.do")
	public String reply_delete(int idx, int bidx) {
		dao.dbDelete(idx);
		return "redirect:/detail.do?idx="+bidx;
	}
	
	@RequestMapping("/reply_preEdit.do")
	public ModelAndView reply_preEdit(int idx, int bidx) {
		ModelAndView mav = new ModelAndView();
		ReplyVO rvo = dao.dbDetail(idx);		
		mav.addObject("rvo",rvo);
		mav.setViewName("bbsReplyEdit");
		return mav;
	}
	@RequestMapping("/reply_edit.do")
	public String reply_edit(ReplyVO vo) {
		dao.dbEdit(vo);
		return "redirect:/detail.do?idx="+vo.getBr_sabun();
	}
}
