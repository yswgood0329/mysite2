package com.douzone.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.mysite.vo.CommentVo;

public class CommentDao {
	
	public List<CommentVo> getCommentList(long no){
		List<CommentVo> list = new ArrayList<CommentVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "select * from comment where board_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new CommentVo(
						rs.getLong("no"),
						rs.getString("content"),
						rs.getString("write_date"),
						rs.getInt("good"),
						rs.getLong("board_no"),
						rs.getLong("user_no")));
			}
			
		} catch (SQLException e) {
			System.out.println("error(CommentDao, getCommentList)" + e);
		} finally {
			// 자원 정리
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public void insertComment(String content, long boardNo, long userNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into comment value(null, ?, current_date(), 0, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, content);
			pstmt.setLong(2, boardNo);
			pstmt.setLong(3, userNo);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error(CommentDao, insertComment)" + e);
		} finally {
			// 자원 정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			//1. 드라이버 로딩
			Class.forName( "com.mysql.jdbc.Driver" );
			
			//2. 연결하기
			String url="jdbc:mysql://localhost/webdb?characterEncoding=utf8&serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch( ClassNotFoundException e ) {
			System.out.println( "드러이버 로딩 실패:" + e );
		} 
		
		return conn;
	}	
}
