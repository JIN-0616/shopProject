package com.t.hc.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.t.hc.dto.ListDto;
import com.t.hc.vo.PagingVo;

@Repository
public class ListDaoImpl implements ListDao {
	
	private Logger logger = LoggerFactory.getLogger(ListDaoImpl.class);
	private final String NS = "com.t.hc.board.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<ListDto> selectPaging(PagingVo paging) {
		logger.info("selectPaging : " + paging);
		return sqlSession.selectList(NS+"selectPaging", paging);
	}

	@Override
	public int selectTotalPaging() {
		logger.info("selectTotalPaging");
		return sqlSession.selectOne(NS+"selectTotalPaging");
	}

	
	@Override
	public boolean listInsert(ListDto list) {
		logger.info("listInsert : " + list);
		return sqlSession.insert(NS+"listInsert", list)==1 ? true : false;
	}
	@Override
	public boolean deleteAll() {
		logger.info("deleteAll");
		return sqlSession.delete(NS+"deleteAll")==0 ? true : false;
	}

}
