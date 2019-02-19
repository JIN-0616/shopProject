package com.springlesson.dao;

import com.springlesson.domain.MemberAlbum;

public interface MemberAlbumDao {
	public int deleteMemberAll(String id) throws Exception;
	public int insertMemberAlbum(MemberAlbum albumVo); 
}//end
