package com.jm.air.controller;

import java.util.ArrayList;

import com.jm.air.service.FlightService;
import com.jm.model.vo.Flight;
import com.jm.model.vo.Member;
import com.jm.view.FlightMenu;

public class FlightController {
	private FlightService fs = new FlightService();

		public void searchFlight(String departure, String destination) {
			ArrayList<Flight> list = fs.searchFlight(departure, destination);
			
			if(list.isEmpty()) {
				new FlightMenu().displayNoData("비행편 조회 결과가 없습니다. 다시 검색해주세요.");
				new FlightMenu().searchFlight();
			} else {
				new FlightMenu().displayFlightList(list);
			}
		}
		
		public void makeReservation(Member m, String departure, String destination, int index) {
			ArrayList<Flight> list = fs.searchFlight(departure, destination);
			
			Flight f = list.get(index);
			
			int result = fs.makeReservation(m, f);
			
			if (result > 0) {
				new FlightMenu().displaySuccess("항공권 예매가 완료되었습니다. 예약 조회 메뉴에서 확인 가능합니다.");
			} else {
				new FlightMenu().displayFail("예매에 실패하였습니다. 다시 시도해주세요. ");
			}
		}
}
