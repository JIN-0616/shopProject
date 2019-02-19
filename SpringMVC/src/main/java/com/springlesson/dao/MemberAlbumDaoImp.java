package com.springlesson.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.springlesson.domain.MemberAlbum;

@Repository
public class MemberAlbumDaoImp implements MemberAlbumDao{
	
	@Inject
	SqlSession sqlSession;
	
	private final static String MemberAlbumMapper = "com.springlesson.mappers.MemberAlbumMappers";

	@Override
	public int deleteMemberAll(String id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertMemberAlbum(MemberAlbum albumVo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}//class end
