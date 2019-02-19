package net.hb.bbs.login;

public class LoginVO {
	private String userid;
	private String pwd;
	private String username; //유저명 
	private int usergrade;
	private boolean flagCookie;
		
	public boolean isFlagCookie() {
		return flagCookie;
	}
	public void setFlagCookie(boolean flagCookie) {
		this.flagCookie = flagCookie;
	}
	public String getUserid() {	return userid;	}
	public void setUserid(String userid) {this.userid = userid;	}
	
	public String getPwd() { return pwd;}
	public void setPwd(String pwd) {	this.pwd = pwd;	}
	
	public String getUsername() {return username;	}
	public void setUsername(String username) {this.username = username;	}
	public int getUsergrade() {	return usergrade;	}
	public void setUsergrade(int usergrade) {	this.usergrade = usergrade;	}

	@Override
	public String toString() {
		return "Login [userid=" + userid + ", pwd=" + pwd + "]";
	}//end
	
}//LoginDTO class End
