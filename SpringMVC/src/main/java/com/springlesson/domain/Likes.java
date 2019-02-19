package com.springlesson.domain;

public class Likes {
	private int num;
	private int board_num;
	private int mem_num;
	private int likes;
	
	@Override
	public String toString() {
		return "Likes [num=" + num + ", board_num=" + board_num + ", mem_num=" + mem_num + ", likes=" + likes + "]";
	}//end
	
	public int getNum() {		return num;	}
	public void setNum(int num) {		this.num = num;	}
	public int getBoard_num() {		return board_num;	}
	public void setBoard_num(int board_num) {		this.board_num = board_num;	}
	public int getMem_num() {		return mem_num;	}
	public void setMem_num(int mem_num) {		this.mem_num = mem_num;	}
	public int getLikes() {		return likes;	}
	public void setLikes(int likes) {		this.likes = likes;	}
	
}//class end

