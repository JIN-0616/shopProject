package com.springlesson.domain;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	private int num;
	private String id;
	private String pwd;
	private String name;
	private int birth;
	private String email;
	private String phone;
	private String indate;
	private int admin;
	private boolean idCookie;
	private boolean loginCookie;
	private String photo;
	private String thumbnail;
	private boolean checked;
	private int mem_num;
	private MultipartFile newfile;
	
	public int getMem_num() {		return mem_num;	}
	public void setMem_num(int mem_num) {		this.mem_num = mem_num;	}
	public MultipartFile getNewfile() {		return newfile;	}
	public void setNewfile(MultipartFile newfile) {		this.newfile = newfile;	}
	public String getPhoto() {		return photo;	}
	public void setPhoto(String photo) {		this.photo = photo;	}
	public String getThumbnail() {		return thumbnail;	}
	public void setThumbnail(String thumbnail) {		this.thumbnail = thumbnail;	}
	public boolean isChecked() {		return checked;	}
	public void setChecked(boolean checked) {		this.checked = checked;	}
	public boolean isLoginCookie() {		return loginCookie;	}
	public void setLoginCookie(boolean loginCookie) {		this.loginCookie = loginCookie;	}
	public boolean isIdCookie() {		return idCookie;	}
	public void setIdCookie(boolean idCookie) {		this.idCookie = idCookie;	}
	public String getId() {		return id;	}
	public void setId(String id) {		this.id = id;	}
	public String getPwd() {		return pwd;	}
	public void setPwd(String pwd) {		this.pwd = pwd;	}
	public String getName() {		return name;	}
	public void setName(String name) {		this.name = name;	}
	public String getEmail() {		return email;	}
	public void setEmail(String email) {		this.email = email;	}
	public String getPhone() {		return phone;	}
	public void setPhone(String phone) {		this.phone = phone;	}
	public String getIndate() {		return indate;	}
	public void setIndate(String indate) {		this.indate = indate;	}
	public int getNum() {		return num;	}
	public void setNum(int num) {		this.num = num;	}
	public int getBirth() {		return birth;	}
	public void setBirth(int birth) {		this.birth = birth;	}
	public int getAdmin() {		return admin;	}
	public void setAdmin(int admin) {		this.admin = admin;	}
	
	@Override
	public String toString() {
		return "Member [num=" + num + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", birth=" + birth + ", email="
				+ email + ", phone=" + phone + ", indate=" + indate + ", admin=" + admin + ", idCookie=" + idCookie
				+ ", loginCookie=" + loginCookie + ", photo=" + photo + ", thumbnail=" + thumbnail + ", checked="
				+ checked + ", newfile=" + newfile + "]";
	}//end	
	
}//class end

