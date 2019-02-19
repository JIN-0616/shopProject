package com.springlesson.service;

import java.util.List;

//import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.springlesson.domain.Board;
import com.springlesson.domain.Likes;
import com.springlesson.domain.Paging;

//@TransactionConfiguration(transactionManager="transcationManager", defaultRollback=true)
//@Commit
@Transactional(transactionManager="transactionManager")
public interface BoardService {
	public List<Board> readBoardList(Paging paging) throws Exception;
	public int selectCount() throws Exception;
	public Board readBoard(int num) throws Exception;
	public void addBoard(Board board) throws Exception;
	
	@Transactional(rollbackFor=Exception.class)
	public void deleteBoard(int num) throws Exception;
	public void updateBoard(Board board) throws Exception;
	
	//detail.do에서 호출
	//board 페이지를 넘겨주면서 BOARD TABLE에 views를 +1 업데이트 (한트랜젝션)
	@Transactional(rollbackFor=Exception.class)
	public Board readBoardUpdateViews(Likes likes) throws Exception;
}//end
