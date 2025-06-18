package com.jm.air.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import com.jm.model.dao.EmployeeDao;
import com.jm.model.vo.Employee;
import com.jm.model.vo.Flight;
import com.jm.model.vo.Reservation;

import static com.jm.air.common.JDBCTemplate.*;

public class EmployeeService {
	private EmployeeDao ed = new EmployeeDao();
	
	
	public Employee empLogIn(int emp_no, String emp_pwd) {
		Connection conn = getConnection();
		Employee e = ed.empLogIn(emp_no, emp_pwd, conn);
		close(conn);
		return e;
	}
	
	public Flight checkFlight(String flight_no) {
		Connection conn = getConnection();
		Flight f = ed.checkFlight(flight_no, conn);
		close(conn);
		return f;
	}
	
	public int addFlight(Flight f) {
		Connection conn = getConnection();
		int result = ed.addFlight(f, conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
		
	}
	public int updateFlight(String flight_no, Date dep_date, Date arrival_date) {
		Connection conn = getConnection();
		int result = ed.updateFlight(flight_no, dep_date, arrival_date, conn);
		
		if (result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
		
	}
	
	public int deleteFlight(String flight_no) {
		Connection conn = getConnection();
		int result = ed.deleteFlight(flight_no, conn);
		
		if (result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
//	public boolean checkPosition(int emp_no) {
//		Connection conn = getConnection();
//		boolean res = ed.checkPosition();
//		close(conn);
//		return res;
//	}
	
	public ArrayList<Reservation> showReservation() {
		Connection conn = getConnection();
		ArrayList<Reservation> list = ed.showReservation(conn);
		close(conn);
		return list;
	}

}
