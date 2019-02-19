package net.hb.bbs.reply;

public class ReplyVO {
	private int br_num;
	private String br_writer;
	private String br_content;
	private java.util.Date br_date;
	private int br_sabun;	
	
	private int rcnt;
	private int rrn;
	private int seq;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getRcnt() {
		return rcnt;
	}
	public void setRcnt(int rcnt) {
		this.rcnt = rcnt;
	}
	
	public int getRrn() {
		return rrn;
	}
	public void setRrn(int rrn) {
		this.rrn = rrn;
	}
	public int getBr_num() {
		return br_num;
	}
	public void setBr_num(int br_num) {
		this.br_num = br_num;
	}
	public String getBr_writer() {
		return br_writer;
	}
	public void setBr_writer(String br_writer) {
		this.br_writer = br_writer;
	}
	public String getBr_content() {
		return br_content;
	}
	public void setBr_content(String br_content) {
		this.br_content = br_content;
	}
	public java.util.Date getBr_date() {
		return br_date;
	}
	public void setBr_date(java.util.Date br_date) {
		this.br_date = br_date;
	}
	public int getBr_sabun() {
		return br_sabun;
	}
	public void setBr_sabun(int br_sabun) {
		this.br_sabun = br_sabun;
	}
	@Override
	public String toString() {		
		return super.toString();
	}
}
