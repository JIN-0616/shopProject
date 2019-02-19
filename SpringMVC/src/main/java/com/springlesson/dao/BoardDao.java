package com.springlesson.dao;

import java.util.List;

import com.springlesson.domain.Board;
import com.springlesson.domain.Likes;
import com.springlesson.domain.Paging;

public interface BoardDao {
	public List<Board> selectBoardList(Paging paging) throws Exception;
	public int selectCount() throws Exception;
	public Board selectBoard(int num) throws Exception;
	public void insertBoard(Board board) throws Exception;
	public void deleteBoard(int num) throws Exception;
	public void updateBoard(Board board) throws Exception;
	public void insertViews(Likes likes) throws Exception;
	public boolean selectViews(Likes likes) throws Exception;
	public void updateLikes(Likes likes) throws Exception;
}//end
