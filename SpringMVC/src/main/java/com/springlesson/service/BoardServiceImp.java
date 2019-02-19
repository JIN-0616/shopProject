package com.springlesson.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.springlesson.dao.BoardDao;
import com.springlesson.dao.CommentsDao;
import com.springlesson.domain.Board;
import com.springlesson.domain.Likes;
import com.springlesson.domain.Paging;

@Service("BoardService")
public class BoardServiceImp implements BoardService{

	@Inject
	BoardDao boardDao;
	@Inject
	CommentsDao commentsDao;
	
	@Override
	public List<Board> readBoardList(Paging paging) throws Exception {
		return boardDao.selectBoardList(paging);
	}//end

	@Override
	public int selectCount() throws Exception {
		return boardDao.selectCount();
	}//end

	@Override
	public Board readBoard(int num) throws Exception {
		return boardDao.selectBoard(num);
	}//end

	@Override
	public void addBoard(Board board) throws Exception {
		boardDao.insertBoard(board);
	}//end

	@Override
	public void deleteBoard(int num) throws Exception {
		boardDao.deleteBoard(num);
		commentsDao.deleteAllComments(num);
	}//end

	@Override
	public void updateBoard(Board board) throws Exception {
		boardDao.updateBoard(board);
	}//end

	@Override
	public Board readBoardUpdateViews(Likes likes) throws Exception {
		int board_num = likes.getBoard_num();
		int mem_num = likes.getMem_num();
		Board board = boardDao.selectBoard(board_num);
		likes.setBoard_num(board_num);
		likes.setMem_num(mem_num);
		if(!boardDao.selectViews(likes)){
			//likes 라는 테이블이 '좋아요'인지 '조회수' 인지 모르겠다
			//boardDao.insertViews(likes);
		}
		return board;
	}//end

}//class end
