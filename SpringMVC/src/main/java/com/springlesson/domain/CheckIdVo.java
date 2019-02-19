package com.springlesson.domain;

public class CheckIdVo {
	private String id;
	private boolean checkId;
	
	public String getId() {		return id;	}
	public void setId(String id) {		this.id = id;	}
	public boolean isCheckId() {		return checkId;	}
	public void setCheckId(boolean checkId) {		this.checkId = checkId;	}
	
	@Override
	public String toString() {
		return "CheckIdVo [id=" + id + ", checkId=" + checkId + "]";
	}//end
	
}//class end

