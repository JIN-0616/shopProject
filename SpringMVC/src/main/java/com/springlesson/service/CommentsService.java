package com.springlesson.service;

import java.util.List;
import java.util.Map;

import com.springlesson.domain.Comments;

public interface CommentsService {
	public List<Comments> readCommentList(Map map) throws Exception;
	public int addComments(Comments comments) throws Exception;
	public void removeComments(int num) throws Exception;
	public void removeAllComments(int board_num) throws Exception;
	public int readCount(int board_num) throws Exception;
}//end
