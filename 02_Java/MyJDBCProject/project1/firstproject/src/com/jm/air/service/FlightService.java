package com.jm.air.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.jm.air.common.JDBCTemplate.*;

import com.jm.model.dao.FlightDao;
import com.jm.model.vo.Flight;
import com.jm.model.vo.Member;


public class FlightService {
	private FlightDao fd = new FlightDao();
	
	public ArrayList<Flight> searchFlight(String departure, String destination){
		Connection conn = getConnection();
		ArrayList<Flight> list = fd.searchFlight(departure, destination, conn);
		close(conn);
		return list;
	}
	
	public int makeReservation(Member m, Flight f) {
	 	Connection conn = getConnection();
	 	int result = fd.makeReservation(m, f, conn);
	 	
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
	 	close(conn);
	 	return result;
	}


}
