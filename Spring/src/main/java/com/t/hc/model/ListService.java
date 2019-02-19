package com.t.hc.model;

import java.util.List;

import com.t.hc.dto.ListDto;
import com.t.hc.vo.PagingVo;

public interface ListService {
	
	public List<ListDto> selectPaging(PagingVo paging);
	public int selectTotalPaging();
	
	
	
	public boolean listInsert(ListDto list);
	public boolean deleteAll();
	
}
