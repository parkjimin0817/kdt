package com.jm.air.controller;

import java.sql.Date;
import java.util.ArrayList;

import com.jm.air.service.EmployeeService;
import com.jm.model.vo.Employee;
import com.jm.model.vo.Flight;
import com.jm.model.vo.Reservation;
import com.jm.view.FlightMenu;

public class EmployeeController {
	private EmployeeService es = new EmployeeService();

	public Employee empLogIn(int emp_no, String emp_pwd) {
		Employee e = es.empLogIn(emp_no, emp_pwd);

		if (e != null) {
			new FlightMenu().displaySuccess(e.getPosition() + " " + e.getEmp_name() + "님 안녕하세요. 원하시는 메뉴를 선택해주세요.");
		} else {
			new FlightMenu().displayFail("직원 로그인에 실패했습니다. 다시 시도해주세요.");
		}

		return e;
	}

	public Flight checkFlight(String flight_no) {
		Flight f = es.checkFlight(flight_no);

		return f;

	}

	public void addFlight(String flight_no, String departure, String destination, Date sqlDateD, Date sqlDateA,
			int seat_count, int price) {
		Flight f = new Flight(flight_no, departure, destination, sqlDateD, sqlDateA, seat_count, price);

		int result = es.addFlight(f);

		if (result > 0) {
			new FlightMenu().displaySuccess("비행편이 성공적으로 추가되었습니다.");
		} else {
			new FlightMenu().displayFail("비행편 추가에 실패했습니다. 다시 시도해주세요.");
		}

	}

	public void updateFlight(Flight f, Date dep_date, Date arrival_date) {
		String flight_no = f.getFlight_no();
		int result = es.updateFlight(flight_no, dep_date, arrival_date);

		if (result > 0) {
			new FlightMenu().displaySuccess("날짜가 성공적으로 수정되었습니다.");
		} else {
			new FlightMenu().displayFail("날짜 수정을 실패했습니다. 다시 시도해주세요.");
		}
	}

	public void deleteFlight(String flight_no) {
		int result = es.deleteFlight(flight_no);

		if (result > 0) {
			new FlightMenu().displaySuccess("비행편이 성공적으로 삭제되었습니다.");
		} else {
			new FlightMenu().displayFail("비행편 삭제에 실패했습니다. 다시 시도해주세요.");
		}
	}

	public void showReservation() {
		ArrayList<Reservation> list = es.showReservation();

		if (list.isEmpty()) {
			new FlightMenu().displayNoData("예약이 존재하지 않습니다.");
		} else {
			new FlightMenu().displayReservationList(list);
		}
	}
}
