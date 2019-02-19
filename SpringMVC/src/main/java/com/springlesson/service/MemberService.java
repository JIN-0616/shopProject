package com.springlesson.service;

import java.util.List;

//import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.springlesson.domain.LoginVo;
import com.springlesson.domain.Member;
import com.springlesson.domain.MemberAlbum;
import com.springlesson.domain.Paging;

//@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional(transactionManager ="transactionManager")
public interface MemberService {
	/* 출력 = read, 추가 = add, 삭제 = remove, 변경 = modify
	 * 메소드명 : 쿼리 명령어 + parameter or result + ALL(조건없이 다 삭제) OR LIST(조건으로 SELECT)
	 * selectMemberList
	 * deleteMemberAll
	 * Dao는 한 테이블을 접근하는 원자화된 repository
	 */
	@Transactional(readOnly = true)
	public Member readMember(String id) throws Exception;
	public int readCount() throws Exception;
	public boolean readIdFlag(String id) throws Exception;
	public List<Member> readMemberList(Paging paging) throws Exception;
	public LoginVo readLogin(Member member) throws Exception;

	@Transactional(rollbackFor=Exception.class)
	public void modifyMember(Member mem, MemberAlbum albumVo) throws Exception;
	@Transactional(rollbackFor=Exception.class)
	public void removeMember(String id) throws Exception;
	@Transactional(rollbackFor=Exception.class)
	public void addMember(Member member, MemberAlbum albumVo) throws Exception;
}//end
