package com.springlesson.domain;

public class MemberAlbum {
	//MemberAlbum 테이블이 select 되는 시점은 member가 select 될 때 join되서 같이 select 된다.
	//insert와 delete는 Member talbe이 dao에서 insert, delete, update될 때 같이 호출된다.
	//form에서 Member가 등록될 때 newFile이 있으면 MemberAlbum의 insert를 호출
	//form에서 Member가 업데이트될 때 newFile이 있으면 update시 MemberAlbum의 (기존DB)delete와 (새로운DB)insert를 호출
	//Member 삭제시 MEMBER_ALBUM delete 호출
	private int num;
	private int mem_num;
	private String photo;
	private String thumbnail;
	public int getNum() {		return num;	}
	public void setNum(int num) {		this.num = num;	}
	public int getMem_num() {		return mem_num;	}
	public void setMem_num(int mem_num) {		this.mem_num = mem_num;	}
	public String getPhoto() {		return photo;	}
	public void setPhoto(String photo) {		this.photo = photo;	}
	public String getThumbnail() {		return thumbnail;	}
	public void setThumbnail(String thumbnail) {		this.thumbnail = thumbnail;	}
	
	@Override
	public String toString() {
		return "MemberAlbum [num=" + num + ", mem_num=" + mem_num + ", photo=" + photo + ", thumbnail=" + thumbnail + "]";
	}//end
	
}//class end

