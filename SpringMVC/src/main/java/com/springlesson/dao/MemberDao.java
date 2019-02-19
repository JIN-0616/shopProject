package com.springlesson.dao;

import java.util.List;

import com.springlesson.domain.LoginVo;
import com.springlesson.domain.Member;
import com.springlesson.domain.Paging;

public interface MemberDao {
/*
 * 메소드명 : 쿼리 명령어 + parameter or result + ALL(조건없이 다 삭제) OR LIST(조건으로 SELECT)
 * selectMemberList
 * deleteMemberAll
 * Dao는 한 테이블을 접근하는 원자화된 repository
 */
	public Member selectMember(String id) throws Exception;
	public void updateMember(Member member) throws Exception;
	public void deleteMember(String id) throws Exception;
	public int selectCount() throws Exception;
	public List<Member> selectMemberList(Paging paging) throws Exception;
	public String selectId(String id) throws Exception;
	public void insertMember(Member member) throws Exception;
	public LoginVo selectLogin(Member member) throws Exception;
}//end
