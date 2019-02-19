package net.hb.bbs.reply;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class ReplyDAO {

	private static final Logger logger = LoggerFactory.getLogger(ReplyDAO.class);

	//org.mybatis.spring.SqlSessionTemplate
	@Autowired
	SqlSessionTemplate temp;
	
	public List<ReplyVO> dbSelect(int idx) {
		List<ReplyVO> list = temp.selectList("bbsreply.selectAll", idx);
		return list;	
	}
		
	public void dbInsert(ReplyVO vo) {
		temp.insert("bbsreply.insert", vo);
	}// end


	public ReplyVO dbDetail(int idx) {
		ReplyVO vo = temp.selectOne("bbsreply.detail", idx);
		return vo;
	}

	public int dbCount() {
		int cnt = (Integer) temp.selectOne("bbsreply.countAll");
		return cnt;
	}// end

	public void dbDelete(int idx) {
		temp.delete("bbsreply.delete", idx);
	}

	public void dbEdit(ReplyVO vo) {
		temp.update("bbsreply.edit", vo);
	}
	
	
}
