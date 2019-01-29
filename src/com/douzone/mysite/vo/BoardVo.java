package com.douzone.mysite.vo;

public class BoardVo {
	private long no;
	private String title;
	private String context;
	private String writeDate;
	private int hit;
	private int groupNo;
	private int orderNo;
	private int depth;
	private long userNo;
	
	public BoardVo() {};
	
	public BoardVo(long no, String title, String context, String writeDate, int hit, int groupNo, int orderNo,
			int depth, long userNo) {
		this.no = (no == 0) ? 0 : no;
		this.title = title;
		this.context = context;
		this.writeDate = writeDate;
		this.hit = hit;
		this.groupNo = groupNo;
		this.orderNo = orderNo;
		this.depth = depth;
		this.userNo = userNo;
	}
	
	public BoardVo(String title, String context, int hit, int groupNo, int orderNo,
			int depth, long userNo) {
//		this.no = (no == 0) ? 0 : no;
		this.title = title;
		this.context = context;
//		this.writeDate = writeDate;
		this.hit = hit;
		this.groupNo = groupNo;
		this.orderNo = orderNo;
		this.depth = depth;
		this.userNo = userNo;
	}
	
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public long getUserNo() {
		return userNo;
	}
	public void setUserNo(long userNo) {
		this.userNo = userNo;
	}

	
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", context=" + context + ", writeDate=" + writeDate + ", hit="
				+ hit + ", groupNo=" + groupNo + ", orderNo=" + orderNo + ", depth=" + depth + ", userNo=" + userNo
				+ "]";
	}


}
