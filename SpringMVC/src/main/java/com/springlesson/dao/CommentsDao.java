package com.springlesson.dao;

import java.util.List;
import java.util.Map;

import com.springlesson.domain.Comments;

public interface CommentsDao {
	public List<Comments> selectCommentsList(Map map) throws Exception;
	public int insertComments(Comments comments) throws Exception;
	public void deleteComments(int num) throws Exception;
	public void deleteAllComments(int board_num) throws Exception;
	public int selectCount(int board_num) throws Exception;
}//end
