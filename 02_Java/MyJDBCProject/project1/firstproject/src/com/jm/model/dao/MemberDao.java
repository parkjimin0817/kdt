package com.jm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.jm.air.common.JDBCTemplate.*;

import com.jm.model.vo.Member;
import com.jm.model.vo.Reservation;

public class MemberDao {
	
	public Member logIn(String id, String pwd, Connection conn) {
		ResultSet rset = null;
		Member m = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM MEMBER WHERE M_ID = ? AND M_PWD = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				m = new Member();
				m.setM_id(rset.getString("M_ID"));
				m.setM_pwd(rset.getString("M_PWD"));
				m.setName(rset.getString("NAME"));
				m.setBirth_date(rset.getString("BIRTH_DATE"));
				m.setPhone(rset.getString("PHONE"));
				m.setPp_no(rset.getString("PP_NO"));
				m.setMileage(rset.getInt("MILEAGE"));
			   }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return m;
	}
	
	public boolean checkId (String id, Connection conn) {
		ResultSet rset = null;
		boolean res = false;
		PreparedStatement pstmt = null;
	
		String sql = "SELECT M_ID FROM MEMBER WHERE M_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				res = true; //중복있으면 true
			} else { 
				res = false; //중복없으면 false
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		} 
		return res;
	}

	
	public int signIn (Member m, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MEMBER VALUES (?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getM_id());
			pstmt.setString(2, m.getM_pwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getBirth_date());
			pstmt.setString(5, m.getPhone());
			pstmt.setString(6, m.getPp_no());
			pstmt.setInt(7, m.getMileage());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Reservation> myReservation(Member m, Connection conn){
		ResultSet rset = null;
		ArrayList<Reservation> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM RESERVATION WHERE M_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getM_id());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Reservation r = new Reservation();
				r.setReservation_no(rset.getInt("RESERVATION_NO"));
				r.setM_id(rset.getString("M_ID"));
				r.setName(rset.getString("NAME"));
				r.setBirth_date(rset.getString("BIRTH_DATE"));
				r.setFlight_no(rset.getString("FLIGHT_NO"));
				r.setDeparture(rset.getString("DEPARTURE"));
				r.setDestination(rset.getString("DESTINATION"));
				r.setDep_date(rset.getDate("DEP_DATE"));
				r.setArrival_date(rset.getDate("ARRIVAL_DATE"));
				
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}
	
	public int cancelReservation (String id, String flight_no, Connection conn) {
		int result1 = 0;
		
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		
		String sql1 = "DELETE FROM RESERVATION WHERE M_ID = ? AND FLIGHT_NO = ?";
		String sql2 = "UPDATE FLIGHT SET SEAT_COUNT = SEAT_COUNT +1 WHERE FLIGHT_NO  = ?";	
		try {
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, id);
			pstmt1.setString(2, flight_no);
			
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setString(1, flight_no);
			
			result1 = pstmt1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt1);
			close(pstmt2);
		}
		return result1;
	}
	
	
	
}
