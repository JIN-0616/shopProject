package net.hb.crud.paging;

public class pageINF_oldConvert {
	int startpage, endpage, pageNUM, start, end, pageCount, temp;
		
	int Gtotal, Stotal;
	
	String pnum, skey, sval, returnpage;
	
	/*
	@RequestMapping("/list.do")
	public ModelAndView guest_select(HttpServletRequest request) { // MVC2 ListController.java
		ModelAndView mav = new ModelAndView();
		
		int startpage = 1, endpage = 10;
		String pnum = "";
		int pageNUM = 1, start = 1, end = 10;
		int pagecount = 1, temp = 0;
		String skey="", sval="", returnpage="";
		
		skey = request.getParameter("keyfield");
		sval = request.getParameter("keyword");		
		
		if(skey==""||skey==null||sval==""||sval==null) { //null초기화
			skey="title"; sval="";
		}		
		returnpage = "&keyfield="+skey+"&keyword="+sval;	
				
		pnum = request.getParameter("pageNum"); // <a href="list.do?pageNum=${i}">[${i}]</a>
		if (pnum == "" || pnum == null) {pnum = "1";}
		else {pageNUM = Integer.parseInt(pnum);}

		// [7클릭] 숫자 7을 pageNUM변수가 기억
		start = (pageNUM - 1) * 10 + 1;
		end = (pageNUM) * 10;		
		int Stotal = dao.dbCountSearch(skey, sval);
		int Gtotal = dao.dbCount(); // 레코드 전체갯수		
		if (Stotal % 10 == 0) {	pagecount = Stotal / 10;} //Gtotal대신 Stotal
		else {pagecount = (Stotal / 10) + 1;}

		// temp변수활용 [7]
		// startpage
		// endpage
		temp = (pageNUM - 1) % 10;
		startpage = pageNUM - temp;
		endpage = startpage + 9;  //[31]~~[40]
		if(endpage>pagecount) {endpage=pagecount;}
		List<GuestDTO> list = dao.dbSelect(start, end, skey, sval);
		mav.addObject("naver", list);
		mav.addObject("Gtotal", Gtotal);
		mav.addObject("Stotal", Stotal);
		mav.addObject("startpage", startpage);
		mav.addObject("endpage", endpage);
		mav.addObject("pagecount", pagecount);
		mav.addObject("pageNUM", pageNUM);
		mav.addObject("skey",skey);
		mav.addObject("sval",sval);
		mav.addObject("returnpage",returnpage);
		//mav.setViewName("guestList");
		mav.setViewName("./WEB-INF/views/guestList.jsp"); 
		return mav; // WEB_INF/views/guestList.jsp문서
	}
	*/
}
