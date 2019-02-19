package net.hb.crud;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	public BoardDTO() {
		
	}
	private int hobby_idx;
	private String name;
	private String title;
	private String content;
	private String gender;
	private String hobby;
	private String img_file_name;
	private MultipartFile upload_f;
	private int rn;
	private int mid;
	private int rcnt;
	
	public int getRcnt() {
		return rcnt;
	}

	public void setRcnt(int rcnt) {
		this.rcnt = rcnt;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	public MultipartFile getUpload_f() {
		return upload_f;
	}

	public void setUpload_f(MultipartFile upload_f) {
		this.upload_f = upload_f;
	}

	public int getHobby_idx() {
		return hobby_idx;
	}

	public void setHobby_idx(int hobby_idx) {
		this.hobby_idx = hobby_idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getImg_file_name() {
		return img_file_name;
	}

	public void setImg_file_name(String img_file_name) {
		this.img_file_name = img_file_name;
	}
}
