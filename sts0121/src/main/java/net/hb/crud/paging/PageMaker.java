package net.hb.crud.paging;

public class PageMaker {
	private Criteria cri;
	private int totalCount;		//총 게시글 수
	private int startPage;		//화면에 보여질 마지막 페이지번호, 끝 페이지 번호
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum = 5;  //화면 하단에 보여지는 페이지 버튼의 수
	
	
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	private void calcData() {
		//끝 페이지 번호 = (현재 페이지 번호 / 화면에 보여질 페이지 번호의 갯수) * 화면에 보여질 페이지 번호의 갯수
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum) * displayPageNum);

		//마지막 페이지 번호 = 총 게시글 수 / 한 페이지당 보여줄 게시글의 갯수
		int tempEndPage = (int)(Math.ceil(totalCount)/(double)cri.getPerPageNum());
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		//시작 페이지 번호 = (끝 페이지 번호 - 화면에 보여질 페이지 번호의 갯수) + 1
		startPage = (endPage - displayPageNum)+1;		
		
		//이전 버튼 생성 여부 = 시작 페이지 번호 == 1 ? false : true
		prev = startPage == 1 ? false : true;
		
		//다음 버튼 생성 여부 = 끝 페이지 번호 * 한 페이지당 보여줄 게시글의 갯수 >= 총 게시글의 수 ? false : true
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;		
	}
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	
	

}
