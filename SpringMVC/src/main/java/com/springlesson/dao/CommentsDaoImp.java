package com.springlesson.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.springlesson.domain.Comments;

@Repository
public class CommentsDaoImp implements CommentsDao{
	
	@Inject
	SqlSession sqlSession;
	
	private final static String CommentsMapper = "com.springlesson.mappers.CommentsMappers";

	@Override
	public List<Comments> selectCommentsList(Map map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertComments(Comments comments) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteComments(int num) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllComments(int board_num) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int selectCount(int board_num) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}//class end