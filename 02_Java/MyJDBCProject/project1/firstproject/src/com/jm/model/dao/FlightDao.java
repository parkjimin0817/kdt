package com.jm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jm.model.vo.Flight;
import com.jm.model.vo.Member;


import static com.jm.air.common.JDBCTemplate.*;

public class FlightDao {
	
	public ArrayList<Flight> searchFlight(String departure, String destination, Connection conn){
		ResultSet rset =  null;
		ArrayList<Flight> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM FLIGHT WHERE DEPARTURE = ? AND DESTINATION = ?";
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, departure);
			pstmt.setString(2, destination);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Flight f = new Flight();
				f.setFlight_no(rset.getString("FLIGHT_NO"));
				f.setDeparture(rset.getString("DEPARTURE"));
				f.setDestination(rset.getString("DESTINATION"));
				f.setDep_date(rset.getDate("DEP_DATE"));
				f.setArrival_date(rset.getDate("ARRIVAL_DATE"));
				f.setSeat_count(rset.getInt("SEAT_COUNT"));
				f.setPrice(rset.getInt("PRICE"));
				
				list.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}
	
	public int makeReservation(Member m, Flight f, Connection conn) {
		int result1 = 0;

		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;

		String sql1 = "INSERT INTO RESERVATION (RESERVATION_NO, M_ID, NAME, BIRTH_DATE, FLIGHT_NO, DEPARTURE, DESTINATION, DEP_DATE, ARRIVAL_DATE)"
				+ "VALUES (RN_S.NEXTVAL,?,?,?,?,?,?,?,?)";
		String sql2 = "UPDATE FLIGHT SET SEAT_COUNT = SEAT_COUNT-1 WHERE FLIGHT_NO = ?";

		try {
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, m.getM_id());
			pstmt1.setString(2, m.getName());
			pstmt1.setString(3, m.getBirth_date());
			pstmt1.setString(4, f.getFlight_no());
			pstmt1.setString(5, f.getDeparture());
			pstmt1.setString(6, f.getDestination());
			pstmt1.setDate(7, f.getDep_date());
			pstmt1.setDate(8, f.getArrival_date());

			int insertResult = pstmt1.executeUpdate();

			pstmt2 = conn.prepareStatement(sql2);

			if (insertResult > 0) {
				pstmt2.setString(1, f.getFlight_no());
				result1 = pstmt2.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt1);
			close(pstmt2);
		}
		return result1;
	}
}
