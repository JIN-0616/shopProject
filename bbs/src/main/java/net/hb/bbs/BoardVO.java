package net.hb.bbs;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public BoardVO() {
	
	}
	private int b_no;
	private int b_sabun;
	private String b_name;
	private String b_title;
	private int b_cnt;
	private String b_content;
	private String b_phone;
	private String b_pwd;
	private java.util.Date b_wdate;
	private String b_juso1;
	private String b_juso2;
	private String b_email;
	private String b_url;
	private MultipartFile b_file;
	private String b_file1;
	private String b_size1;
	private int rn;
	private int cnt;
	private int recnt;
	
	public int getCnt() {
		return cnt;
	}
	public int getRecnt() {
		return recnt;
	}
	public void setRecnt(int recnt) {
		this.recnt = recnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public int getB_sabun() {
		return b_sabun;
	}
	public void setB_sabun(int b_sabun) {
		this.b_sabun = b_sabun;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public int getB_cnt() {
		return b_cnt;
	}
	public void setB_cnt(int b_cnt) {
		this.b_cnt = b_cnt;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_phone() {
		return b_phone;
	}
	public void setB_phone(String b_phone) {
		this.b_phone = b_phone;
	}
	public String getB_pwd() {
		return b_pwd;
	}
	public void setB_pwd(String b_pwd) {
		this.b_pwd = b_pwd;
	}
	public java.util.Date getB_wdate() {
		return b_wdate;
	}
	public void setB_wdate(java.util.Date b_wdate) {
		this.b_wdate = b_wdate;
	}
	public String getB_juso1() {
		return b_juso1;
	}
	public void setB_juso1(String b_juso1) {
		this.b_juso1 = b_juso1;
	}
	public String getB_juso2() {
		return b_juso2;
	}
	public void setB_juso2(String b_juso2) {
		this.b_juso2 = b_juso2;
	}
	public String getB_email() {
		return b_email;
	}
	public void setB_email(String b_email) {
		this.b_email = b_email;
	}
	public String getB_url() {
		return b_url;
	}
	public void setB_url(String b_url) {
		this.b_url = b_url;
	}
	public MultipartFile getB_file() {
		return b_file;
	}
	public void setB_file(MultipartFile b_file) {
		this.b_file = b_file;
	}
	public String getB_file1() {
		return b_file1;
	}
	public void setB_file1(String b_file1) {
		this.b_file1 = b_file1;
	}
	public String getB_size1() {
		return b_size1;
	}
	public void setB_size1(String b_size1) {
		this.b_size1 = b_size1;
	}
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	@Override
	public String toString() {			
		return "[Page]\n"+"\tb_cnt = "+b_cnt+"\n\tb_content = "+b_content+"\n\tb_email = "+b_email+"\n\tb_file="+b_file+"\n\tb_file1="+b_file1
				+"\n\tb_juso1 = "+b_juso1+"\n\tb_juso2 = "+b_juso2 +"\n\tb_name = "+b_name +"\n\tb_no = "+b_no +"\n\tb_phone = "+b_phone
				+"\n\tb_pwd = "+b_pwd + "\n\tb_sabun = "+b_sabun+"\n\tb_size1 = "+b_size1+"\n\tb_title = "+b_title +"\n\tb_url = "+b_url
				+"\n\tb_wdate = "+b_wdate+"\n\tcnt = "+cnt + "\n\trn = "+rn+"\n----------------------------------------------------";
	}
}
