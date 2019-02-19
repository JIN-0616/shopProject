package com.springlesson.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlesson.domain.Paging;
import com.springlesson.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
	
	@Inject
	private BoardService service;
		
	@RequestMapping("boardList.do")
	public String list(Model model,Paging paging) throws Exception{
		logger.info("boardList.do --loading");
		return "board/BoardList";
	}
	

	
}//class END
