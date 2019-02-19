package com.springlesson.domain;

import org.springframework.web.multipart.MultipartFile;

public class Board {
	private int num;
	private String mem_id;
	private String mem_num;
	private String title;
	private String content;
	private String passwd;
	private String indate;
	private String filename;
	private String views;
	private String view_cnt;
	private MultipartFile newfile;
	
	public String getView_cnt() {		return view_cnt;	}
	public void setView_cnt(String view_cnt) {		this.view_cnt = view_cnt;	}
	public MultipartFile getNewfile() {		return newfile;	}
	public void setNewfile(MultipartFile newfile) {		this.newfile = newfile;	}
	public String getMem_num() {		return mem_num;	}
	public void setMem_num(String mem_num) {		this.mem_num = mem_num;	}
	public int getNum() {		return num;	}
	public void setNum(int num) {		this.num = num;	}
	public String getMem_id() {		return mem_id;	}
	public void setMem_id(String mem_id) {		this.mem_id = mem_id;	}
	public String getTitle() {		return title;	}
	public void setTitle(String title) {		this.title = title;	}
	public String getContent() {		return content;	}
	public void setContent(String content) {		this.content = content;	}
	public String getPasswd() {		return passwd;	}
	public void setPasswd(String passwd) {		this.passwd = passwd;	}
	public String getIndate() {		return indate;	}
	public void setIndate(String indate) {		this.indate = indate;	}
	public String getFilename() {		return filename;	}
	public void setFilename(String filename) {		this.filename = filename;	}
	public String getViews() {		return views;	}
	public void setViews(String views) {		this.views = views;	}
}//class end

