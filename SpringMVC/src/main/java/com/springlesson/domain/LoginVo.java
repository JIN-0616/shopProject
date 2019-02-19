package com.springlesson.domain;

public class LoginVo {
	private String id;
	private int num;
	private int login; //0 (id or pwd가 틀린것)
	private char admin;
	private String name;
	private String thumbnail;
	private String photo;
	
	@Override
	public String toString() {
		
		String msg="LoginVo [id=" + id + ", num=" + num + ", login=" + login + ", admin=" + admin + ", name=" + name
				+ ", thumbnail=" + thumbnail + ", photo=" + photo + "]";
		System.out.println( " LOginVo.java " + "name=" + name);
		return msg;
	}//end
	
	public String getThumbnail() {		return thumbnail;	}
	public void setThumbnail(String thumbnail) {		this.thumbnail = thumbnail;	}
	public String getPhoto() {		return photo;	}
	public void setPhoto(String photo) {		this.photo = photo;	}
	public String getId() {		return id;	}
	public void setId(String id) {		this.id = id;	}
	public int getNum() {		return num;	}
	public void setNum(int num) {		this.num = num;	}
	public int getLogin() {		return login;	}
	public void setLogin(int login) {		this.login = login;	}
	public char getAdmin() {		return admin;	}
	public void setAdmin(char admin) {		this.admin = admin;	}
	public String getName() {		return name;	}
	public void setName(String name) {		this.name = name;	}
}//class End
