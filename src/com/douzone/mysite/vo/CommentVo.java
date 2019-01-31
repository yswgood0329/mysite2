package com.douzone.mysite.vo;

public class CommentVo {
	private long no;
	private String content;
	private String writeDate;
	private int good;
	private long boardNo;
	private String userName;
	
	
	public CommentVo(long no, String content, String writeDate, int good, long boardNo, String userName) {
		this.no = no;
		this.content = content;
		this.writeDate = writeDate;
		this.good = good;
		this.boardNo = boardNo;
		this.userName = userName;
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


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	public String toString() {
		return "CommentVo [no=" + no + ", content=" + content + ", writeDate=" + writeDate + ", good=" + good
				+ ", boardNo=" + boardNo + ", userName=" + userName + ", getNo()=" + getNo() + ", getContent()="
				+ getContent() + ", getWriteDate()=" + getWriteDate() + ", getGood()=" + getGood() + ", getBoardNo()="
				+ getBoardNo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
