package net.hb.crud.reply;

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
	
	
	@RequestMapping(value="/reply_list.do")
	public ModelAndView reply_select(@RequestParam("idx") int idx) {
		ModelAndView mav = new ModelAndView();
		List<ReplyDTO> list = dao.dbSelect(idx);
		if(list == null) {
			List<ReplyDTO> a = null; 
			ReplyDTO b = new ReplyDTO();
			a.add(b);
			list = a;
		}
		mav.addObject("list", list);
		mav.setViewName("board_reply");
		return mav;
	}
	
	@RequestMapping("/reply.do")
	public String reply_insert(ReplyDTO dto) {
		dao.dbInsert(dto);
		return "redirect:/detail.do?idx="+dto.getHobby_idx();
	}
	
	@RequestMapping("/reply_del.do")
	public String reply_delete(@RequestParam("idx") int idx, @RequestParam("hobby_idx") int hobby_idx) {
		dao.dbDelete(idx);
		return "redirect:/detail.do?idx="+hobby_idx;
	}
	
	@RequestMapping("/reply_preEdit.do")
	public ModelAndView reply_preEdit(@RequestParam("idx") int idx, @RequestParam("hobby_idx") int hobby_idx) {
		ModelAndView mav = new ModelAndView();
		ReplyDTO dto = dao.dbDetail(idx);
		logger.info(dto.getRwriter());
		logger.info(dto.getRmemo());
		mav.addObject("dto",dto);
		mav.setViewName("board_replyEdit");
		return mav;
	}
	@RequestMapping("/reply_edit.do")
	public String reply_edit(ReplyDTO dto) {
		dao.dbEdit(dto);
		return "redirect:/detail.do?idx="+dto.getHobby_idx();
	}	
	
}
