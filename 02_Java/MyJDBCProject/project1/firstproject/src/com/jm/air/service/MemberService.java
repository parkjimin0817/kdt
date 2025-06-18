package com.jm.air.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.jm.air.common.JDBCTemplate.*;

import com.jm.model.dao.MemberDao;
import com.jm.model.vo.Member;
import com.jm.model.vo.Reservation;

public class MemberService {
	private MemberDao md = new MemberDao();
	
	public Member logIn(String id, String pwd) {
		Connection conn = getConnection();
		Member m = md.logIn(id, pwd,conn);
		close(conn);
		return m;
	}
	
	public boolean checkId (String id) {
		Connection conn = getConnection();
		boolean res = md.checkId(id, conn);
		close(conn);
		return res;
	}
	
	public int signIn (Member m) {
		Connection conn = getConnection();
		int result = md.signIn(m, conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public ArrayList<Reservation> myReservation(Member m){
		Connection conn = getConnection();
		ArrayList<Reservation> list = md.myReservation(m, conn);
		close(conn);
		return list;
	}
	
	public int cancelReservation (String id, String flight_no) {
		Connection conn = getConnection();
		int result = md.cancelReservation(id, flight_no, conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	


}
