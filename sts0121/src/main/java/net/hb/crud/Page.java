package net.hb.crud;

public class Page {	
	
	private int startpage = 1;
	private int endpage = 10;
	private String pnum = "";
	private int pageNUM = 1;
	private int start = 1;
	private int end = 10;
	private int pagecount = 1;
	private int temp = 0;	
	private String skey="";
	private String sval="";
	private String returnpage="";
	private int Stotal=0;
	private int Gtotal=0;
			
	
	public int getStotal() {
		return Stotal;
	}
	public void setStotal(int stotal) {
		Stotal = stotal;
	}
	public int getGtotal() {
		return Gtotal;
	}
	public void setGtotal(int gtotal) {
		Gtotal = gtotal;
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
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public int getPageNUM() {
		return pageNUM;
	}
	public void setPageNUM(int pageNUM) {
		this.pageNUM = pageNUM;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
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
	public String getReturnpage() {
		return returnpage;
	}
	public void setReturnpage(String returnpage) {
		this.returnpage = returnpage;
	}	

}
