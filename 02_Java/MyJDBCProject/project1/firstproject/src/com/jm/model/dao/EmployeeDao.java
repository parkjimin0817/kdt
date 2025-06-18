package com.jm.model.dao;

import static com.jm.air.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jm.model.vo.Employee;
import com.jm.model.vo.Flight;
import com.jm.model.vo.Reservation;

public class EmployeeDao{
	
	
	public Employee empLogIn(int emp_no, String emp_pwd, Connection conn) {
		ResultSet rset = null;
		Employee e  = null;
		PreparedStatement pstmt = null;

		String sql = "SELECT * FROM EMPLOYEE WHERE EMP_NO = ? AND EMP_PWD = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp_no);
			pstmt.setString(2, emp_pwd);

			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				e = new Employee();
				e.setEmp_no(rset.getInt("EMP_NO"));
				e.setEmp_name(rset.getString("EMP_NAME"));
				e.setEmp_pwd(rset.getString("EMP_PWD"));
				e.setPosition(rset.getString("POSITION"));
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return e;
	}
	
	public Flight checkFlight(String flight_no, Connection conn) {
		ResultSet rset = null;
		Flight f = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM FLIGHT WHERE FLIGHT_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, flight_no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				f = new Flight();
				f.setFlight_no(rset.getString("FLIGHT_NO"));
				f.setDeparture(rset.getString("DEPARTURE"));
				f.setDestination(rset.getString("DESTINATION"));
				f.setDep_date(rset.getDate("DEP_DATE"));
				f.setArrival_date(rset.getDate("ARRIVAL_DATE"));
				f.setSeat_count(rset.getInt("SEAT_COUNT"));
				f.setPrice(rset.getInt("PRICE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return f;
	}
	
	public int addFlight(Flight f, Connection conn) {
		int result = 0 ;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO FLIGHT VALUES (?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, f.getFlight_no());
			pstmt.setString(2, f.getDeparture());
			pstmt.setString(3, f.getDestination());
			pstmt.setDate(4, f.getDep_date());
			pstmt.setDate(5, f.getArrival_date());
			pstmt.setInt(6, f.getSeat_count());
			pstmt.setInt(7, f.getPrice());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateFlight(String flight_no, Date dep_date, Date arrival_date, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE FLIGHT "
				+ "SET DEP_DATE = ?, "
				+ "ARRIVAL_DATE = ? "
				+ "WHERE FLIGHT_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setDate(1, dep_date);
			pstmt.setDate(2, arrival_date);
			pstmt.setString(3, flight_no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteFlight(String flight_no, Connection conn) {
		int result = 0;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		
		
		String sql1 = "DELETE FROM RESERVATION WHERE FLIGHT_NO = ? ";
		String sql2 = "DELETE FROM FLIGHT WHERE FLIGHT_NO = ? ";

		try {
			
			pstmt1 = conn.prepareStatement(sql2);
			pstmt1.setString(1, flight_no);
			result = pstmt1.executeUpdate();
			
			pstmt2 = conn.prepareStatement(sql1);
			pstmt2.setString(1, flight_no);
			pstmt2.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt1);
			close(pstmt2);
		}
		return result;
	}
	
	public ArrayList<Reservation> showReservation(Connection conn){
		ResultSet rset = null;
		ArrayList<Reservation> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM RESERVATION";
		
		try {
			pstmt = conn.prepareStatement(sql);
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
}
