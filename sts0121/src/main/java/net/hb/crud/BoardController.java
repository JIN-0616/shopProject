package net.hb.crud;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	@Autowired
	BoardDAO dao;

	@Autowired
	private ServletContext application;
		
	@RequestMapping(value = "/write.do", method = RequestMethod.GET)
	public String board_write(Locale locale, Model model) {
		return "board";
	}

	@RequestMapping("/insert.do")
	public String board_insert(BoardDTO dto) {

		String path = application.getRealPath("/resources/upload");
		String img = dto.getUpload_f().getOriginalFilename();
		File file = new File(path, img);
		String realPath = file.getAbsolutePath();
		logger.info(realPath);

		try {
			dto.getUpload_f().transferTo(file);

			// ---다른 Spring교재에서 사용하는 파일업로드 관련 메소드 들 -----
			// FileCopyUtils.copy(dto.getUpload_f().getBytes(), file);
			// File target=new File(path,img);
			// FileCopyUtils.copy(dto.getUpload_f().getBytes(), target);
			// dto.getUpload_f().transferTo(target);
		} catch (Exception ex) {
			System.out.println("파일에러:" + ex);
		}

		dto.setImg_file_name(img);
		System.out.println("컨트롤 넘어온파일=" + dto.getImg_file_name());

		dao.dbInsert(dto);
		return "redirect:list.do";
	}

//	@RequestMapping("/list.do")
//	public ModelAndView board_list(@RequestParam("keyfield") String skey, @RequestParam("keyword") String sval,
//									@RequestParam("start") int start, @RequestParam("end") int end) {
	@RequestMapping("/list.do")
	public ModelAndView board_list(@RequestParam(value="skey",defaultValue="",required=false) String skey,
									@RequestParam(value="sval",defaultValue="",required=false) String sval,
									@RequestParam(value="pageNum",defaultValue="1",required=false) int pnum ) {		
		ModelAndView mav = new ModelAndView();	
		int startpage = 1, endpage = 10;		
		int pageNUM = 1, start = 1, end = 10;
		int pagecount = 1, temp = 0;
		
		pageNUM = pnum;
		
		String returnpage="";				
		if(skey==""||skey==null||sval==""||sval==null) { 
			skey="title"; sval="";
		}		
		returnpage = "&keyfield="+skey+"&keyword="+sval;	
		
		logger.info(skey);
		logger.info(sval);
		start = (pageNUM - 1) * 10 + 1;
		end = (pageNUM) * 10;		
		int Stotal = dao.dbCount(skey, sval);
		int Gtotal = dao.dbCount(); 	
		if (Stotal % 10 == 0) {	pagecount = Stotal / 10;} 
		else {pagecount = (Stotal / 10) + 1;}

		temp = (pageNUM - 1) % 10;
		startpage = pageNUM - temp;
		endpage = startpage + 9;  //[31]~~[40]
		if(endpage>pagecount) {endpage=pagecount;}
		Map<String, Object> query = new HashMap();
		query.put("skey",skey);
		query.put("sval",sval);
		query.put("start",start);
		query.put("end",end);
										//skey,sval,start,end
		List<BoardDTO> list = dao.dbList(query);
		mav.addObject("list", list);	
		mav.addObject("Gtotal", Gtotal);
		mav.addObject("Stotal", Stotal);
		mav.addObject("startpage", startpage);
		mav.addObject("endpage", endpage);
		mav.addObject("pagecount", pagecount);
		mav.addObject("pageNUM", pageNUM);
		mav.addObject("skey",skey);
		mav.addObject("sval",sval);
		mav.addObject("returnpage",returnpage);
		mav.setViewName("boardList");
		return mav;
	}
	

	@RequestMapping("/detail.do")
	public String board_detail(@RequestParam("idx") String idx, Model model) {
		BoardDTO dto = dao.dbDetail(Integer.parseInt(idx));
		model.addAttribute("dto", dto);
		return "boardDetail";
	}

	@RequestMapping("/delete.do")
	public String board_delete(@RequestParam("idx") int idx) {
		dao.dbDelete(idx);
		return "redirect:list.do";
	}

	/*
	@RequestMapping("/edit.do")
	public String board_edit(@RequestParam("idx") int idx, Model model) {
		BoardDTO dto = dao.dbDetail(idx);
		model.addAttribute("dto", dto);
		return "boardEdit";
	}
	
	@RequestMapping("/editSave.do")
	public String board_editSave(BoardDTO dto) {
		String path = application.getRealPath("/resource/upload");
		String img = dto.getUpload_f().getOriginalFilename();
		File file = new File(path, img);
		try {
			FileCopyUtils.copy(dto.getUpload_f().getBytes(), file);
			File target = new File(path, img);
			FileCopyUtils.copy(dto.getUpload_f().getBytes(), target);
			dto.getUpload_f().transferTo(target);
		} catch (Exception ex) {
			System.out.println("파일에러:" + ex);
		}

		dto.setImg_file_name(img);
		System.out.println("컨트롤 넘어온파일=" + dto.getImg_file_name());

		dao.dbInsert(dto);
		return "redirect:list.do";
	}
*/
	@RequestMapping("/download.do")
	public String board_download(HttpServletRequest request, HttpServletResponse response) {
		String data = "";
		try {
			request.setCharacterEncoding("utf-8");
			//String filename = URLDEcoder.decode(request.getParameter("fidx"), "utf-8");
			String filename = request.getParameter("fidx");
			// 에러이유 the valid characters are defiend in RFC 7230 and RFC 3986
			data = request.getParameter("idx");
			System.out.println("\n다운로드 filename=" + filename + " idx=" + data);

			String path = application.getRealPath("/resources/upload");
			System.out.println(path);
			
			//filename = URLEncoder.encode(filename, "UTF-8");
			
			//---- google 크롬 한글파일 다운로드시 파일명 깨짐 해결방법 ----------------
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

			//---- ---------------- ---------------- ---------------- ----------------
			response.setHeader("Content-Disposition", "attachment;filename=" + refilename);
			System.out.println("filename "+filename);
			File file = new File(path, filename);

			InputStream is = new FileInputStream(file);
			OutputStream os = response.getOutputStream();
			byte[] b = new byte[(int) file.length()];

			is.read(b, 0, b.length);
			os.write(b);

			is.close();
			os.close();
		} catch (Exception e) {
		}

		return "redirect:/detail.do?idx=" + data;
	}

	@RequestMapping("/preEdit.do")
	public ModelAndView board_preEdit(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		int data = Integer.parseInt(request.getParameter("idx"));
		BoardDTO dto = dao.dbDetail(data);
		mav.addObject("dto", dto);
		mav.setViewName("boardEdit");
		return mav;
	}// end

	@RequestMapping("/edit.do")
	public String board_edit(BoardDTO dto) {
		String path = application.getRealPath("/resources/upload");
		System.out.println(path);
		MultipartFile mf = dto.getUpload_f();
		String img = mf.getOriginalFilename();

//		System.out.println("\nedit수정 넘어온이름=" + dto.getName());
//		System.out.println("edit수정 넘어온제목=" + dto.getTitle());
//		System.out.println("edit수정 넘어온내용=" + dto.getContent());
//		System.out.println("edit수정 넘어온성별=" + dto.getGender());
//		System.out.println("edit수정 넘어온취미=" + dto.getHobby());
//		System.out.println("edit수정 문자열파일=" + dto.getUpload_f());
//		System.out.println("edit수정 문자열파일=" + img);
		File file = new File(path, img);
		try {
			// dto.getUpload_f().transferTo(file);
			// FileCopyUtils클래스사용
			FileCopyUtils.copy(dto.getUpload_f().getBytes(), file);
		} catch (Exception ex) {
		}
		dto.setImg_file_name(img);

		dao.dbEdit(dto);
		return "redirect:/list.do";
	}// end
}
