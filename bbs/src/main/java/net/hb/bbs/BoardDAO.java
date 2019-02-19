package net.hb.bbs;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class BoardDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAO.class);
	
	@Autowired
	SqlSessionTemplate temp;
	
	public void dbCountPlus(int no) {
		temp.update("bbs.cntPlus",no);
	}
	public int dbCount() {
		int total = temp.selectOne("bbs.countAll");
		return total;
	}
	public int dbCountQuery(Page p) {
		int qtotal = temp.selectOne("bbs.countQuery", p);
		return qtotal;
	}
	public List<BoardVO> dbList(){
		List<BoardVO> list = temp.selectList("bbs.selectAll");
		return list;
	}
	public List<BoardVO> dbListQuery(Page p){
		List<BoardVO> list = temp.selectList("bbs.selectAllQuery", p);
		return list;
	}
	public void dbInsert(BoardVO vo) {		
		temp.insert("bbs.insert", vo);		
	}
	
	public int dbEdit(BoardVO vo) {
		int result = temp.update("bbs.edit", vo);
		return result;
		
	}
	public BoardVO dbDetail(int no) {
		BoardVO vo = temp.selectOne("bbs.detail", no);
		return vo;
	}
	public void dbDelete(int no) {
		temp.delete("bbs.delete",no);
	}
}
