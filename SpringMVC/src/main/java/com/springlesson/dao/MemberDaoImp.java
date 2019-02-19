package com.springlesson.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.springlesson.domain.LoginVo;
import com.springlesson.domain.Member;
import com.springlesson.domain.Paging;

@Repository
public class MemberDaoImp implements MemberDao{
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDaoImp.class);
	
	@Inject
	SqlSession sqlSession;
	
	private final static String MemberMapper = "com.springlesson.mappers.MemberMappers";

	@Override
	public Member selectMember(String id) throws Exception {
		return null;
	}

	@Override
	public void updateMember(Member member) throws Exception {
		
	}

	@Override
	public void deleteMember(String id) throws Exception {
		
	}

	@Override
	public int selectCount() throws Exception {
		return 0;
	}

	@Override
	public List<Member> selectMemberList(Paging paging) throws Exception {
		return null;
	}

	@Override
	public String selectId(String id) throws Exception {
		return null;
	}

	@Override
	public void insertMember(Member member) throws Exception {
		
	}

	@Override
	public LoginVo selectLogin(Member member) throws Exception {
		return null;
	}

	
	
}//class end
