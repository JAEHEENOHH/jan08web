package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poseidon.dto.BoardDTO;
import com.poseidon.dto.MemberDTO;

public class AdminDAO extends AbstractDAO {

	   public List<MemberDTO> memberList(int grade) {
		      List<MemberDTO> list = new ArrayList<MemberDTO>();
		      Connection con = db.getConnection();
		      PreparedStatement pstmt = null;
		      ResultSet rs = null;
		      String sql = "SELECT mno, mid, mname, mdate, mgrade FROM member WHERE mgrade=?";

		      try {
		         pstmt = con.prepareStatement(sql);
		         pstmt.setInt(1, grade);
		         rs = pstmt.executeQuery();
		         while (rs.next()) {
		            MemberDTO e = new MemberDTO();
		            e.setMno(rs.getInt("mno"));
		            e.setMid(rs.getString("mid"));
		            e.setMname(rs.getString("mname"));
		            e.setMdate(rs.getString("mdate"));
		            e.setMgrade(rs.getInt("mgrade"));
		            list.add(e);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(rs, pstmt, con);
		      }
		      return list;
		   }
	public int memberUpdate(int grade, int mno) {
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE member SET mgrade=? WHERE mno=?";
		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, grade);
			pstmt.setInt(2, mno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, con);
		}
		return result;
	}
	
	  public List<MemberDTO> memberList() {
	      List<MemberDTO> list = new ArrayList<MemberDTO>();
	      Connection con = db.getConnection();
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = "SELECT mno, mid, mname, mdate, mgrade FROM member";

	      try {
	         pstmt = con.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	            MemberDTO e = new MemberDTO();
	            e.setMno(rs.getInt("mno"));
	            e.setMid(rs.getString("mid"));
	            e.setMname(rs.getString("mname"));
	            e.setMdate(rs.getString("mdate"));
	            e.setMgrade(rs.getInt("mgrade"));
	            list.add(e);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rs, pstmt, con);
	      }
	      return list;
	   }
	public List<BoardDTO> boardList() { //관리자 게시판 만들기
		List<BoardDTO> list = new ArrayList<BoardDTO>(); 
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT board_no, board_title, board_date, board_ip, board_del, m.mname, "
				+ "(SELECT count(*) FROM visitcount v WHERE v.board_no=b.board_no)as count,"
				+ "(SELECT count(*) FROM comment c WHERE c.board_no=b.board_no) as comment, "
				+ "FROM board b "
				+ "JOIN member m ON b.mno = m.mno";
			
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO e = new BoardDTO();
				e.setNo(rs.getInt("board_no"));
				e.setTitle(rs.getString("board_title"));
				e.setWrite(rs.getString("mname"));
				e.setDate(rs.getString("board_date"));
				e.setCount(rs.getInt("count"));
				e.setComment(rs.getInt("comment"));
				e.setIp(rs.getString("board_ip"));
				e.setDel(rs.getInt("board_del"));
				list.add(e);
			}
			System.out.println(list);
		} catch (SQLException e) {	
			e.printStackTrace();
		}finally {
			close(rs, pstmt, con);
		}
		return list;
	}
}