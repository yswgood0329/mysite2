package com.douzone.mysite.vo;

public class CommentVo {
	private long no;
	private String content;
	private String writeDate;
	private int good;
	private long boardNo;
	private long userNo;
	
	
	public CommentVo(long no, String content, String writeDate, int good, long boardNo, long userNo) {
		this.no = no;
		this.content = content;
		this.writeDate = writeDate;
		this.good = good;
		this.boardNo = boardNo;
		this.userNo = userNo;
	}
	
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	public long getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(long boardNo) {
		this.boardNo = boardNo;
	}
	public long getUserNo() {
		return userNo;
	}
	public void setUserNo(long userNo) {
		this.userNo = userNo;
	}
	@Override
	public String toString() {
		return "CommentVo [no=" + no + ", content=" + content + ", writeDate=" + writeDate + ", good=" + good
				+ ", boardNo=" + boardNo + ", userNo=" + userNo + "]";
	}
	
	
}
