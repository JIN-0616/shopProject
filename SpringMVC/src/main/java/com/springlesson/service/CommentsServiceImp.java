package com.springlesson.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.springlesson.dao.CommentsDao;
import com.springlesson.domain.Comments;

@Service("CommentsService")
public class CommentsServiceImp implements CommentsService{
	
	@Inject
	CommentsDao commentsDao;
	
	@Override
	public List<Comments> readCommentList(Map map) throws Exception {
		return commentsDao.selectCommentsList(map);
	}//end

	@Override
	public int readCount(int board_num) throws Exception {
		return commentsDao.selectCount(board_num);
	}//end
	
	@Override
	public int addComments(Comments comments) throws Exception {
		return commentsDao.insertComments(comments);
	}//end

	@Override
	public void removeComments(int num) throws Exception {
		commentsDao.deleteComments(num);
	}//end

	@Override
	public void removeAllComments(int board_num) throws Exception {
		commentsDao.deleteAllComments(board_num);
	}//end
}//class end
