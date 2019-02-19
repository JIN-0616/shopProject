package net.hb.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public class GuestDAO {
	
	@Autowired
	SqlMapClientTemplate temp; // guest.xml문서의 id가져오기
	
	public void dbInsert(GuestDTO dto) { //guest_insert(dto)
		temp.insert("guest.add",dto); //guest네임스페이스 add <insert id=add
		//ibatis데이터메칭 #값# <--->  mybatis #{}  <---> el태그 ${}
		System.out.println("guest 테이블 데이터 저장성공");
	}
		
	public List<GuestDTO> dbSelect(int start, int end){ //start,end
		//DTO개체화 후 setvalue("value")
		GuestDTO dto = new GuestDTO();
		dto.setStart(start);
		dto.setEnd(end);
		@SuppressWarnings("unchecked")
		List<GuestDTO> list = temp.queryForList("guest.selectAll",dto);			
		return list;
	}
	// 원본을 시작행, end행, 검색필드, 키워드 재활용
	public List<GuestDTO> dbSelect(int start, int end, String skey, String sval){
		GuestDTO dto = new GuestDTO();
		dto.setStart(start);
		dto.setEnd(end);
		dto.setSkey(skey);
		dto.setSval(sval);
		@SuppressWarnings("unchecked")
		List<GuestDTO> list = temp.queryForList("guest.selectAll",dto);			
		return list;
	}
	public int dbCount(String skey, String sval) {//검색+조회결과도 개체로 받아서 형변환
		GuestDTO dto = new GuestDTO();
		dto.setSkey(skey);
		dto.setSval(sval);
		int cnt = (Integer)temp.queryForObject("guest.countAll",dto);
		return cnt;
	}
	
	public int dbCount() {//조회결과도 개체로 받아서 형변환
		int cnt = (Integer)temp.queryForObject("guest.countAll");
		return cnt;
	}
	
	public GuestDTO dbDetail(int data) {
		GuestDTO dto = null; //temp.queryForObject("guest.detail",data);
		dto = (GuestDTO) temp.queryForObject("guest.detail",data);
		return dto;		
	}
	public void dbDelete(int data) {
		temp.delete("guest.del",data);
		System.out.println("guest 테이블 데이터 삭제 성공");
	}
	
	public void dbEdit(GuestDTO dto) {
		temp.update("guest.edit",dto);
		System.out.println("guest 테이블 데이터 수정 성공");
	}	
}
