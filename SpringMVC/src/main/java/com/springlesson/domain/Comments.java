package com.springlesson.domain;

public class Comments {
	private int num;
	private int board_num;
	private String content;
	private String indate;
	private String mem_id;
	private String mem_name;
	private int mem_num;
	
	public int getMem_num() {		return mem_num;	}
	public void setMem_num(int mem_num) {		this.mem_num = mem_num;	}
	public String getMem_name() {		return mem_name;	}
	public void setMem_name(String mem_name) {		this.mem_name = mem_name;	}
	public int getNum() {		return num;	}
	public void setNum(int num) {		this.num = num;	}
	public int getBoard_num() {		return board_num;	}
	public void setBoard_num(int board_num) {		this.board_num = board_num;	}
	public String getContent() {		return content;	}
	public void setContent(String content) {		this.content = content;	}
	public String getIndate() {		return indate;	}
	public void setIndate(String indate) {		this.indate = indate;	}
	public String getMem_id() {		return mem_id;	}
	public void setMem_id(String mem_id) {		this.mem_id = mem_id;	}
}//class end

