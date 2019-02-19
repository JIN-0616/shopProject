package net.hb.crud.reply;

public class ReplyDTO {
	private int rhobby_idx;
	private String rwriter;
	private String rmemo;
	private int hobby_idx;
	private int rcnt;
	private int rrn;
	private int seq;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getRrn() {
		return rrn;
	}
	public void setRrn(int rrn) {
		this.rrn = rrn;
	}
	public int getRcnt() {
		return rcnt;
	}
	public void setRcnt(int rcnt) {
		this.rcnt = rcnt;
	}
	public int getRhobby_idx() {
		return rhobby_idx;
	}
	public void setRhobby_idx(int rhobby_idx) {
		this.rhobby_idx = rhobby_idx;
	}
	public String getRwriter() {
		return rwriter;
	}
	public void setRwriter(String rwriter) {
		this.rwriter = rwriter;
	}
	public String getRmemo() {
		return rmemo;
	}
	public void setRmemo(String rmemo) {
		this.rmemo = rmemo;
	}
	public int getHobby_idx() {
		return hobby_idx;
	}
	public void setHobby_idx(int hobby_idx) {
		this.hobby_idx = hobby_idx;
	}
}
