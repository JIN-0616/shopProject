package com.t.hc.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t.hc.dto.ListDto;
import com.t.hc.vo.PagingVo;

@Service
public class ListServiceImpl implements ListService {
	
	@Autowired
	private ListDao dao;
	
	@Override
	public List<ListDto> selectPaging(PagingVo paging) {
		return dao.selectPaging(paging);
	}

	@Override
	public int selectTotalPaging() {
		return dao.selectTotalPaging();
	}

	
	
	@Override
	public boolean listInsert(ListDto list) {
		return dao.listInsert(list);
	}
	@Override
	public boolean deleteAll() {
		return dao.deleteAll();
	}

}
