package net.hb.crud.reply;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

@Repository
@Component
public class ReplyDAO {

	private static final Logger logger = LoggerFactory.getLogger(ReplyDAO.class);

	//org.mybatis.spring.SqlSessionTemplate
	@Autowired
	SqlSessionTemplate temp;
	
	public List<ReplyDTO> dbSelect(int idx) {
		List<ReplyDTO> list = temp.selectList("board_reply.selectAll", idx);
		return list;	
	}
		
	public void dbInsert(ReplyDTO dto) {
		temp.insert("board_reply.insert", dto);
	}// end


	public ReplyDTO dbDetail(int idx) {
		ReplyDTO dto = temp.selectOne("board_reply.detail", idx);
		return dto;
	}

	public int dbCount() {
		int cnt = (Integer) temp.selectOne("board_reply.countAll");
		return cnt;
	}// end

	public void dbDelete(int idx) {
		temp.delete("board_reply.del", idx);
	}

	public void dbEdit(ReplyDTO dto) {
		temp.update("board_reply.edit", dto);
	}

}// BoardDA end
