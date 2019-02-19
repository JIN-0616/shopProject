package com.springlesson.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
//import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.springlesson.dao.MemberAlbumDao;
import com.springlesson.dao.MemberDao;
import com.springlesson.domain.LoginVo;
import com.springlesson.domain.Member;
import com.springlesson.domain.MemberAlbum;
import com.springlesson.domain.Paging;

//@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional(transactionManager="transactionManager")
@Service("MemberService")//Component(bean), Repository(Dao), Controller(servlet)
public class MemberServiceImp implements MemberService{
	
	@Inject
	private MemberDao memberDao; //실제로 구현한 @Repository MemberDaoImp인데 MemberDao를 dataType으로 사용
	@Inject
	private MemberAlbumDao albumDao;

	@Override
	public Member readMember(String id) throws Exception {
		return memberDao.selectMember(id);
	}//end

	@Override
	public int readCount() throws Exception {
		return memberDao.selectCount();
	}//end

	@Override
	public boolean readIdFlag(String id) throws Exception {
		return (memberDao.selectId(id)!=null)?true:false;
	}//end

	@Override
	public LoginVo readLogin(Member member) throws Exception {
		return memberDao.selectLogin(member);
	}//end

	@Override
	public List<Member> readMemberList(Paging paging) throws Exception {
		return memberDao.selectMemberList(paging);
	}//end
	
	@Transactional
	@Override
	public void modifyMember(Member member, MemberAlbum albumVo) throws Exception {
		memberDao.updateMember(member);
		albumDao.deleteMemberAll(member.getId());
		if(albumVo!=null){
			albumDao.insertMemberAlbum(albumVo);
		}
	}//end
	
	@Transactional
	@Override
	public void removeMember(String id) throws Exception {
		memberDao.deleteMember(id);
		albumDao.deleteMemberAll(id);
	}//end

	@Transactional
	@Override
	public void addMember(Member member, MemberAlbum albumVo) throws Exception {
		memberDao.insertMember(member);		

		if(albumVo!=null){
			albumVo.setMem_num(member.getNum());
			albumDao.insertMemberAlbum(albumVo);
		}
	}//end

}//class end
