package net.hb.bbs;

//저장용
public class Page2 {
	private int pageCnt; // 출력 페이지번호 갯수
	private int index; // 출력 페이지번호
	private int pageStartNum; // 출력 페이지 시작 번호
	private int listCnt; // 출력 리스트 갯수
	private int total; // 리스트 총 갯수
	private String skey;
	private String sval;

	{	//초기화블럭
		pageCnt = 5;
		index = 0;
		pageStartNum = 1;
		listCnt = 5;
		skey="title";
		sval="";
	}
	
	public String getSkey() {
		return skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}

	public String getSval() {
		return sval;
	}

	public void setSval(String sval) {
		this.sval = sval;
	}

	public Page2() {}
	
	public int getStart() {
		return index*listCnt+1;
	}
	public int getLast() {
		return (index*listCnt)+listCnt;
	}
	public int getPageLastNum() {
		int remainListCnt = total-listCnt*(pageStartNum-1);
		int remainPageCnt = remainListCnt/listCnt;
		if(remainListCnt % listCnt != 0) {
			remainPageCnt++; // +1 안되는 이유는 뭔가			
		}
		int pageLastNum = 0;
		if(remainListCnt <= listCnt) {
			pageLastNum = pageStartNum;
		}else if(remainPageCnt <= pageCnt) {
			pageLastNum = remainPageCnt+pageStartNum-1;			
		}else {
			pageLastNum = pageCnt + pageStartNum-1;
		}
		return pageLastNum;
	}
	public boolean getLastChk() {
		int n = (int)Math.ceil((double)total/listCnt);
		return getPageLastNum()==n ? false : n==0 ? false : true;
	}
	
	public int getPageCnt() {
		return pageCnt;
	}	
	public void setPageCnt(int pageCnt) {
        this.pageCnt = pageCnt;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public int getPageStartNum() {
        return pageStartNum;
    }
    public void setPageStartNum(int pageStartNum) {
        this.pageStartNum = pageStartNum;
    }
    public int getListCnt() {
        return listCnt;
    }
    public void setListCnt(int listCnt) {
        this.listCnt = listCnt;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    @Override
    public String toString() {
        return "Page pageCnt=" + pageCnt + ", index=" + index + ", pageStartNum=" + pageStartNum + ", listCnt="
                + listCnt + ", total=" + total + "]";
    }
}
