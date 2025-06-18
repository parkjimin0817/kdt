package com.jm.air.controller;

import java.util.ArrayList;

import com.jm.air.service.MemberService;
import com.jm.model.vo.Member;
import com.jm.model.vo.Reservation;
import com.jm.view.FlightMenu;

public class MemberController {
	private MemberService ms = new MemberService();
	
	public Member logIn(String id, String pwd) {
		Member.currentUser = ms.logIn(id, pwd);
		
		if(Member.currentUser != null) {
			new FlightMenu().displaySuccess(Member.currentUser .getName() + "님 환영합니다!");
			new FlightMenu().memberChoice();
		}else {
			new FlightMenu().displayFail("아이디 혹은 비밀번호를 잘못입력하셨습니다. 다시 입력해주세요.");
			new FlightMenu().logIn();
		}
		return Member.currentUser;
	}
	
	public boolean checkId (String id) {
		boolean res = ms.checkId(id);
		return res; //중복있으면 true / 중복없으면 false
	}
	
	public void signIn(String id, String pwd, String name, String birth_date, String phone, String pp_no) {
		int mileage = 0;
		Member m = new Member (id, pwd, name, birth_date, phone, pp_no, mileage);
		int result = ms.signIn(m);
		
		if (result > 0) {
			new FlightMenu().displaySuccess("회원가입이 완료되었습니다!");
			new FlightMenu().logIn();
		} else {
			new FlightMenu().displayFail("회원가입에 실패하였습니다. 다시 시도해주세요.");
		}
	}
	
	public void myReservation(Member m) {
		ArrayList<Reservation> list = ms.myReservation(m);
		
		if(list.isEmpty()) {
			new FlightMenu().displayNoData("예약 조회 결과가 없습니다.");
		} else {
			new FlightMenu().displayReservationList(list);
		}
	}
	
	public void cancelReservation(Member m, int index) {
		ArrayList<Reservation> list = ms.myReservation(m);
		
		String m_id = list.get(index).getM_id();
		String flight_no = list.get(index).getFlight_no();
		
		int result = ms.cancelReservation(m_id, flight_no);
		
		if (result > 0) {
			new FlightMenu().displaySuccess("예약이 취소되었습니다. ");
		} else {
			new FlightMenu().displayFail("예약 취소에 실패하였습니다. 다시 시도해주세요.");
		}
	}
	
}
	