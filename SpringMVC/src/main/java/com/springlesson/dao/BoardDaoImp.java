package com.springlesson.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.springlesson.domain.Board;
import com.springlesson.domain.Likes;
import com.springlesson.domain.Paging;

@Repository
public class BoardDaoImp implements BoardDao{
	
	@Inject
	SqlSession sqlSession;
	
	private final static String BoardMapper = "com.springlesson.mappers.BoardMappers";

	@Override
	public List<Board> selectBoardList(Paging paging) throws Exception {
		List<Object> obj = sqlSession.selectList(BoardMapper+".selectBoardlist", paging);
		List<Board> vo;
		for (Object obj : vo) {
			obj
		}
		return ;
	}

	@Override
	public int selectCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Board selectBoard(int num) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertBoard(Board board) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(int num) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBoard(Board board) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertViews(Likes likes) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean selectViews(Likes likes) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateLikes(Likes likes) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}//class end
