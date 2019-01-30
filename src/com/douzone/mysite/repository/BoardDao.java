package com.douzone.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.mysite.vo.BoardVo;

public class BoardDao {
	public List<BoardVo> getTitleList(){
		List<BoardVo> list = new ArrayList<BoardVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
//			String sql = "select	* "
//					   + "from		(select		* "
//					   +            "from 		board "
//					   +            "order 		by o_no) as a "
//					   + "order 	by g_no";
			
			String sql = "select	a.no, "
								 + "title, "
								 + "write_date, "
								 + "hit, "
								 + "g_no, "
								 + "o_no, "
								 + "depth, "
								 + "user_no "
								 
					   + "from		(select		* "
					   +            "from 		board "
					   +            "order 		by o_no) as a "
					   + "join user b on a.user_no = b.no "
					   + "order 	by g_no";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new BoardVo(rs.getLong("no"),
							rs.getString("title"),
							null, // rs.getString("context"),
							rs.getString("write_date"),
							rs.getInt("hit"),
							rs.getInt("g_no"),
							rs.getInt("o_no"),
							rs.getInt("depth"),
							rs.getLong("user_no")));
			}
			
			
		} catch (SQLException e) {
			System.out.println("Error : " + e);
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
	
	public void Delete(long no) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "delete from board where no=?";
			pstmt = conn.prepareStatement( sql );

			pstmt.setLong( 1, no );
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error :" + e);
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
	
	public BoardVo View(long num) {
//		System.out.println(num);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVo vo = null;
		
		try {
			conn = getConnection();
			
			String sql = "select 	*"
					   + "from 		board "
					   + "where 	no = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new BoardVo(rs.getLong("no"),
						rs.getString("title"),
						rs.getString("context"),
						rs.getString("write_date"),
						rs.getInt("hit"),
						rs.getInt("g_no"),
						rs.getInt("o_no"),
						rs.getInt("depth"),
						rs.getLong("user_no"));
			}
			
		} catch(SQLException e) {
			System.out.println("error(View) : " + e);
		} finally {
			// 자원 정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return vo;
	}
	
	public void Write(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into board value(null, ?, ?, current_date(), ?,?,?,?,?);";
			
			pstmt = conn.prepareStatement(sql);
			
			if(vo.getGroupNo() == 1) {
				gnoSetting(vo.getGroupNo());
				vo.setGroupNo(2);
			} else {
				dataModify(vo.getGroupNo(), vo.getOrderNo(), vo.getNo());
			}
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContext());
			pstmt.setInt(3, vo.getHit());
			pstmt.setInt(4, vo.getGroupNo());
			pstmt.setInt(5, vo.getOrderNo());
			pstmt.setInt(6, vo.getDepth());
			pstmt.setLong(7, vo.getUserNo());
			
			pstmt.executeUpdate();
			
			
			
		} catch(SQLException e) {
			System.out.println("error(write)" + e);
		} finally {
			// 자원 정리
			try {
				if( rs != null)
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
		
		
	}
	
	public void modify(long no, String title, String content) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
//			System.out.println(groupNo + " : " + orderNo + " : " + no);
			String sql = "update board set title = ?, context = ? where no = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setLong(3, no);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error(modify) : " + e);
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
	
	public void dataModify(int groupNo, int orderNo, long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			System.out.println(groupNo + " : " + orderNo + " : " + no);
			String sql = "update board set o_no = o_no + 1 where g_no = ? and o_no >= ? and no != ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, groupNo);
			pstmt.setInt(2, orderNo);
			pstmt.setLong(3, no);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error(dataModify) : " + e);
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
	
	public void gnoSetting(int groupNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
//			System.out.println(groupNo + " : " + orderNo + " : " + no);
			String sql = "update board set g_no = g_no + 1 where g_no >= 1";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error(gnoSetting) : " + e);
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
//	
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
