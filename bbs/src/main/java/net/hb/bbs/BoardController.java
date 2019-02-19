package net.hb.bbs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	@Autowired
	BoardDAO dao;
	
	@Autowired
	private ServletContext app;
	
	@RequestMapping("/list.do")
	public ModelAndView boardListView(Page p, @RequestParam(value="index",defaultValue="1") int index ) {
		ModelAndView mav = new ModelAndView("bbs");		
		p.setIndex(index);
		p.setStart(index);
		p.setEnd(index);
		int total = dao.dbCount();
		int qtotal = dao.dbCountQuery(p);
		p.setTotal(total);
		p.setQtotal(qtotal);
		
		int a = (qtotal%10 == 0) ? (qtotal/10) : (qtotal/10)+1;
		p.setPagecount(a);
		
		p.setStartpage(index - (index-1)%10);
		p.setEndpage(p.getStartpage()+9);
		
		if(p.getEndpage()>p.getPagecount()) {
			p.setEndpage(p.getPagecount());
		}
		
		List<BoardVO> list = dao.dbListQuery(p);		
		mav.addObject("list", list);		
		mav.addObject("p",p);
		return mav;
	}
	
	@RequestMapping("/write.do")
	public ModelAndView boardWrite() {
		ModelAndView mav = new ModelAndView("bbsInsert");		
		return mav;
	}
	
	
	@RequestMapping("/detail.do")
	public ModelAndView boardDetail(@RequestParam("idx") int no) {
		ModelAndView mav = new ModelAndView("bbsDetail");
		dao.dbCountPlus(no);
		BoardVO vo = dao.dbDetail(no);
		//logger.info(vo.toString());
		mav.addObject("vo",vo);
		return mav;		
	}
	
	
	@RequestMapping("/preEdit.do")
	public ModelAndView boardPreEdit(@RequestParam("idx") int no) {
		ModelAndView mav = new ModelAndView("bbsEdit");
		BoardVO vo = dao.dbDetail(no);
		mav.addObject("vo",vo);
		return mav;
	}
	
	@RequestMapping("/download.do")
	public String board_download(HttpServletRequest request, HttpServletResponse response) {
		String data = "";
		try {
			request.setCharacterEncoding("utf-8");
			String filename = request.getParameter("fidx");			
			data = request.getParameter("idx");
			String path = app.getRealPath("/resources/upload");
			System.out.println(path);
			
			String refilename = "";
			 StringBuffer sb = new StringBuffer();
             for (int i = 0; i < filename.length(); i++) {
                 char c = filename.charAt(i);
                 if (c > '~') {
                     sb.append(URLEncoder.encode("" + c, "UTF-8"));
                 } else {
                     sb.append(c);
                 }
             }
            refilename = sb.toString();
	
			response.setHeader("Content-Disposition", "attachment;filename=" + refilename);

			File file = new File(path, filename);

			InputStream is = new FileInputStream(file);
			OutputStream os = response.getOutputStream();
			byte[] b = new byte[(int) file.length()];

			is.read(b, 0, b.length);
			os.write(b);

			is.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/detail.do?idx=" + data;
	}
	@RequestMapping("/insert.do")
	public ModelAndView boardInsert(BoardVO vo, HttpServletResponse response) {		
		ModelAndView mav = new ModelAndView("redirect:/list.do");
//		if(vo == null) {
//			response.setContentType("text/html; charset=utf-8");
//			try {
//				response.getWriter().append("<script>"
//								+ "alert('잘못된 접근입니다.');"					        		
//								  + "</script>").flush();
//			} catch (IOException e) {				
//				e.printStackTrace();
//			}
//			return mav;
//		}
		String path = app.getRealPath("/resources/upload");
		String fname = vo.getB_file().getOriginalFilename();		
		File file = new File(path,fname);
		//String realPath = file.getAbsolutePath();		
		try {
			vo.getB_file().transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String filesize = "";
		if(file.exists()) {
			filesize = String.valueOf(file.length());
		}
		vo.setB_file1(fname);
		vo.setB_size1(filesize);
		dao.dbInsert(vo);
		return mav;
	}
	@RequestMapping("/edit.do")
	public ModelAndView boardEdit(BoardVO vo) {
		ModelAndView mav = new ModelAndView("redirect:/list.do");
		String path = app.getRealPath("resources/upload");	
		String fname = vo.getB_file().getOriginalFilename();
		File file = new File(path,fname);
		try {
			vo.getB_file().transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String filesize = "";
		if(file.exists()) {
			filesize = String.valueOf(file.length());
		}
		vo.setB_file1(fname);
		vo.setB_size1(filesize);	
		
		int result =dao.dbEdit(vo);
		logger.info(String.valueOf(result));
		return mav;
	}
	
	@RequestMapping("/delete.do")
	public ModelAndView boardDelete(@RequestParam("idx") int no) {
		ModelAndView mav = new ModelAndView("redirect:/list.do");
		dao.dbDelete(no);
		return mav;
	}
}
