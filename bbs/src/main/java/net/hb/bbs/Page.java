package net.hb.bbs;


public class Page { 
	
	private int index; // 현재 페이지번호
	private int start; // 출력 페이지 시작 번호
	private int end;   // 출력 페이지 끝 번호
	
	private int total; // 리스트 총 갯수
	private int qtotal; //검색 리스트 갯수
	
	private int pagecount;  // 총 페이지 개수 [1] ~ [pagecount]
	private int startpage;  // [1]
	private int endpage;	// [10]

	private String skey;
	private String sval;
	private String returnpage;
	private int recnt;


	public int getRecnt() {
		return recnt;
	}

	public void setRecnt(int recnt) {
		this.recnt = recnt;
	}
	{	
		index = 1;
		setStart(index);
		setEnd(index);
		skey="title";
		sval="";
		returnpage = "&skey="+skey+"&sval"+sval;		
	}
	
	public Page() {}
	
	public String getSkey() {return skey;}
	public void setSkey(String skey) {this.skey = skey;}
	public String getSval() {return sval;}
	public void setSval(String sval) {this.sval = sval;}
	
	public int getStart() {	return start;}
	public void setStart(int index) {
		this.start = (index-1)*10+1;
	}
	public int getEnd() {return end;}
	public void setEnd(int index) {
		this.end = index * 10;
	}
	
	public int getQtotal() {return qtotal;}
	public void setQtotal(int qtotal) {this.qtotal = qtotal;}
    public int getIndex() {return index;}
    public void setIndex(int index) {this.index = index;}   
    public int getTotal() {return total;}
    public void setTotal(int total) {this.total = total;}
    public String getReturnpage() {return returnpage;}
    public void setReturnpage(String returnpage) {this.returnpage = returnpage;}
    public int getPagecount() {
		return pagecount;
	}

	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public int getStartpage() {
		return startpage;
	}

	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}

	public int getEndpage() {
		return endpage;
	}

	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}
    @Override
    public String toString() {
        return "Page index=" + index + ", total=" + total + "]";
    }
}
