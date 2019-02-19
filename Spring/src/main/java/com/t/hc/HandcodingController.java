package com.t.hc;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.t.hc.dto.ListDto;
import com.t.hc.model.ListService;
import com.t.hc.vo.PagingVo;

@Controller
public class HandcodingController {
	
	private Logger logger = LoggerFactory.getLogger(HandcodingController.class);
	
	@Autowired
	private ListService service;
	
	// 3. Controller
	@RequestMapping(value="/paging.do", method={RequestMethod.POST,RequestMethod.GET})
	public String paging(Model model, PagingVo paging){
		logger.info("paging : " + paging);
		List<ListDto> lists = service.selectPaging(paging);
		paging.setTotal(service.selectTotalPaging());
		model.addAttribute("lists", lists);
		model.addAttribute("p", paging);
		return "paging";
	}
	
	
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public String list(String num){
		logger.info("list : " + num);
		Random ran = new Random();
		for (int i = 0; i < Integer.parseInt(num); i++) {
			service.listInsert(new ListDto(ran.nextInt(100000000)+""));
		}
		return "redirect:/paging.do";
	}
	@RequestMapping(value="/remove.do")
	public String remove(){
		logger.info("remove");
		service.deleteAll();
		return "redirect:/paging.do";
	}	
}