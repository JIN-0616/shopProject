package net.hb.crud.paging;

public class Criteria {
	
	private int page;	//현재 페이지번호
	private int perPageNum; // 한 페이지당 보여줄 게시글 갯수
	private int pageStart;
	private int pageEnd;
	private String skey;
	private String sval;
	
	public int getPageStart() { // 특정 페이지의 게시글 시작번호, 게시글 시작 행 번호		
		//현재 페이지의 게시글 시작 번호 = (현재 페이지 번호 - 1) * 페이지당 보여줄 게시글 갯수		
		return (this.page-1)*perPageNum;
	}
	
	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public String getSkey() {
		return skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}

	public String getSval() {
		return sval;
	}

	public void setSval(String sval) {
		this.sval = sval;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public Criteria() { // 기본 생성자 - 기본값 생성
		this.page = 1;	
		this.perPageNum =10;
		this.skey="";
		this.sval="";
		this.pageStart=(page-1)*perPageNum;
		this.pageEnd=pageStart+9;
	}
	
	public int getPage() {
		return page;
	}

	//페이지가 음수값이 되지 않게 설정. 음수가 되면 1페이지를 나타낸다.
	public void setPage(int page) { 
		if(page<=0) {		//넘어온 페이지가 1보다 작으면
			this.page = 1;	//기본값 세팅
		}else {		
			this.page = page; //그게 아니면 페이지 세팅
		}
	}

	public int getPerPageNum() {
		return perPageNum;
	}
	
	//페이지당 보여줄 게시글 수가 변하지 않게 설정했다.
	public void setPerPageNum(int pageCount) {
		int cnt = this.perPageNum;
		if(pageCount != cnt) {
			this.perPageNum = cnt;
		}else {
			this.perPageNum = pageCount;
		}
	}
	
	
}
