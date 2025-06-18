package com.jm.view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import com.jm.model.vo.Employee;
import com.jm.model.vo.Flight;
import com.jm.model.vo.Member;
import com.jm.model.vo.Reservation;
import com.jm.air.controller.EmployeeController;
import com.jm.air.controller.FlightController;
import com.jm.air.controller.MemberController;

public class FlightMenu {
	private Scanner sc = new Scanner (System.in);
	private FlightController fc = new FlightController();
	private MemberController mc = new MemberController();
	private EmployeeController ec = new EmployeeController();
	
	public void mainMenu() {
		
		System.out.println("*********자바항공에 오신 것을 환영합니다.*********");
		
		while(true) {
			System.out.println("***항공권 예약 및 조회는 로그인 후 이용가능합니다.***");
			System.out.println("원하시는 메뉴를 선택해주세요");
			System.out.println("1. 항공편 조회"); //출발지 도착지 입력 리스트 출력
			System.out.println("2. 회원 로그인"); //아이디 비번 입력 멤버 생성
			System.out.println("3. 회원가입"); //멤버 추가
			System.out.println("9. 프로그램 종료");
			System.out.println("0. 직원 메뉴"); //항공편 추가, 수정, 삭제
			System.out.print("메뉴 번호 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: 
				searchFlight();
				break;
			case 2: 
				logIn();
				break;
			case 3: 
				signIn();
				break;
			case 9: 
				System.out.println("방문해주셔서 감사합니다. 프로그램을 종료합니다.");
				System.exit(0);  
		        break;
			case 0:
				employeeMenu();
				break;
			default : 
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요. ");
			}
		}
	}
	
	public void searchFlight() {
		
		System.out.println("***항공편 조회***");
		System.out.println("*출발지 혹은 도착지에 대한민국의 공항(김포, 인천, 제주)이 포함되어있어야합니다.");
		System.out.println("*추후 더 다양한 항공편 제공을 위해 노력하겠습니다. ");
		System.out.println("대한민국 : 김포 / 인천 / 제주");
		System.out.println("일본 : 오사카 / 도쿄 / 삿포로");
		System.out.println("중국 : 상하이 / 베이징");
		System.out.println("미국 : 뉴욕 / 시카고");
		System.out.println("유럽 : 런던 / 파리");
		System.out.println("호주,뉴질랜드 : 시드니 / 오클랜드");
		System.out.print("출발지(Departure) : ");
		String departure = sc.next();
		sc.nextLine();
		System.out.print("도착지(Destination) : ");
		String destination = sc.next();
		sc.nextLine();
		
		fc.searchFlight(departure, destination);
		
	}
	
	public void logIn() {

			System.out.println("***로그인***");
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pwd = sc.nextLine();
			
			Member.currentUser = mc.logIn(id, pwd);

	}
	
	public void signIn() {

		boolean res;
		
		System.out.println("***회원가입***");
		System.out.println("아래 정보를 입력해주세요.");
		
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.next();
			sc.nextLine();
			
			res = mc.checkId (id); //중복있으면 true , 중복없으면 false
			
			if (!res) {
				System.out.println("사용가능한 아이디입니다");
				System.out.print("비밀번호 : ");
				String pwd = sc.nextLine();
				System.out.print("이름 : ");
				String name = sc.nextLine();
				System.out.print("생년월일(YYYYMMDD): ");
				String birth_date = sc.nextLine();
				System.out.print("핸드폰 번호('-'제외): ");
				String phone = sc.nextLine();
				System.out.print("여권번호 (예시: M000000001 (10자리)) : ");
				String pp_no = sc.nextLine();
				
				mc.signIn(id, pwd, name, birth_date, phone, pp_no);
				
				break;
			} else {
				System.out.println("이미 사용중인 아이디입니다. 다시 입력해주세요. ");
			}
		}
	}
	
	public void memberChoice() {
		
		while(true) {
			System.out.println("원하시는 메뉴를 선택해주세요");
			System.out.println("1. 항공편 조회");
			System.out.println("2. 항공권 예매");
			System.out.println("3. 예약 조회");
			System.out.println("4. 예약 취소");
			System.out.println("9. 로그아웃");
			System.out.print("메뉴 번호 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 :
				searchFlight();
				break;
			case 2 :
				makeReservation();
				break;
			case 3 :
				myReservation();
				break;
			case 4 :
				cancelReservation();
				break;
			case 9 :
				logout();
				break;
			default : 
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			}
			
		}
		
		
	}
	
	public void makeReservation() {

		System.out.println("***항공권 예매***");
		System.out.println("*출발지 혹은 도착지에 대한민국의 공항(김포, 인천, 제주)이 포함되어있어야합니다.");
		System.out.println("*추후 더 다양한 항공편 제공을 위해 노력하겠습니다. ");
		System.out.println("대한민국 : 김포 / 인천 / 제주");
		System.out.println("일본 : 오사카 / 도쿄 / 삿포로");
		System.out.println("중국 : 상하이 / 베이징");
		System.out.println("미국 : 뉴욕 / 시카고");
		System.out.println("유럽 : 런던 / 파리");
		System.out.println("호주,뉴질랜드 : 시드니 / 오클랜드");
		System.out.print("출발지(Departure) : ");
		String departure = sc.next();
		sc.nextLine();
		System.out.print("도착지(Destination) : ");
		String destination = sc.next();
		sc.nextLine();
		
		fc.searchFlight(departure, destination);
		
		System.out.print("원하시는 항공권을 선택해주세요 ('[]'안의 번호를 입력해주세요.) : ");
		int choice = sc.nextInt();
		sc.nextLine();
		int index = choice - 1;
		
		fc.makeReservation(Member.currentUser, departure, destination, index);
		
	}
	
	public void cancelReservation() {
		System.out.println("***항공권 예매 취소***");
		
		mc.myReservation(Member.currentUser);
		
		System.out.print("취소하실 항공편을 선택해주세요.([]안의 번호를 입력해주세요) : ");
		int choice = sc.nextInt();
		sc.nextLine();
		int index = choice-1;
		
		mc.cancelReservation(Member.currentUser, index);
		
	}
	
	public void myReservation() {
		
		System.out.println("***예약 조회***");
		
		mc.myReservation(Member.currentUser);
	
	}
	
	public void logout() {
		Member.currentUser = null;
		if(Member.currentUser == null) {
			System.out.println("로그아웃 되셨습니다. 첫 화면으로 돌아갑니다.");
			mainMenu();
		}
	}
	
	
	public void employeeMenu() {

		while (true) {
			System.out.print("사번 입력 : ");
			int emp_no = sc.nextInt();
			sc.nextLine();
			System.out.print("비밀번호 입력 : ");
			String emp_pwd = sc.nextLine();

			Employee.currentEmployee = ec.empLogIn(emp_no, emp_pwd);

			if (Employee.currentEmployee == null) {
				continue;
			}

			while (true) {
				System.out.println("***직원 메뉴***");
				System.out.println("1. 항공편 추가");
				System.out.println("2. 항공편 날짜 수정");
				System.out.println("3. 항공편 삭제");
				System.out.println("4. 예약 전체 조회");
				System.out.println("9. 메인화면으로 돌아가기 (로그아웃)");
				System.out.print("메뉴 번호: ");
				int menu = sc.nextInt();
				sc.nextLine();

				switch (menu) {
				case 1:
					addFlight();
					break;
				case 2:
					updateFlight();
					break;
				case 3:
					deleteFlight();
					break;
				case 4:
					showReservation();
					break;
				case 9:
					Employee.currentEmployee = null;
					System.out.println("로그아웃되셨습니다. 메인화면으로 돌아갑니다.");
					return;
				default:
					System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
				}
			}
		}
	}
	

	public void addFlight() {

		System.out.println("***항공편 추가***");

		while (true) {
			System.out.print("추가할 편명 (ex: K0001): ");
			String flight_no = sc.nextLine();
			Flight f = ec.checkFlight(flight_no);

			if (f == null) {
				System.out.print("출발지: ");
				String departure = sc.nextLine();
				System.out.print("도착지: ");
				String destination = sc.nextLine();
				System.out.print("출발 날짜(yyyy-mm-dd): ");
				String dep_date = sc.nextLine();
				Date sqlDateD = Date.valueOf(dep_date);
				System.out.print("도착 날짜(yyyy-mm-dd): ");
				String arrival_date = sc.nextLine();
				Date sqlDateA = Date.valueOf(arrival_date);
				System.out.print("좌석 수 : ");
				int seat_count = sc.nextInt();
				sc.nextLine();
				System.out.print("가격 : ");
				int price = sc.nextInt();
				sc.nextLine();

				ec.addFlight(flight_no, departure, destination, sqlDateD, sqlDateA, seat_count, price);
				break;
			} else {
				System.out.println("이미 존재하는 편명입니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void updateFlight() {

		System.out.println("***항공편 날짜 수정***");
		while (true) {
			System.out.print("수정할 편명: ");
			String flight_no = sc.nextLine();

			Flight f = ec.checkFlight(flight_no);

			if (f != null) {
				System.out.println(f.toString());
				System.out.println("현재 출발 날짜 : " + f.getDep_date());
				System.out.println("현재 도착 날짜 : " + f.getArrival_date());
				System.out.print("수정할 출발 날짜 (yyyy-mm-dd) : ");
				String dep_date = sc.nextLine();
				Date sqlDateD = Date.valueOf(dep_date);
				System.out.print("수정할 도착 날짜 (yyyy-mm-dd) :  ");
				String arrival_date = sc.nextLine();
				Date sqlDateA = Date.valueOf(arrival_date);

				ec.updateFlight(f, sqlDateD, sqlDateA);
				break;
			} else {
				System.out.println("존재하지 않는 편명입니다. 다시 입력해주세요. ");
			}
		}
	}
	
	public void deleteFlight() {

		System.out.println("***항공편 삭제***");

		while (true) {
			System.out.print("삭제할 항공편 명: ");
			String flight_no = sc.nextLine();

			Flight f = ec.checkFlight(flight_no);

			if (f != null) {
				System.out.println(f.toString());
				System.out.println("항공편을 삭제하면 해당 항공편 예약도 모두 취소됩니다.");
				System.out.print("해당 항공편을 삭제하시겠습니까? (y/n) : ");
				char res = sc.next().toLowerCase().charAt(0);
				if (res == 'y') {
					ec.deleteFlight(flight_no);
					break;
				} else if (res == 'n') {
					System.out.println("삭제가 취소되었습니다.");
					break;
				} else {
					System.out.println("잘못 입력하셨습니다. 'y' 또는 'n' 을 입력해주세요. ");
				}
			} else {
				System.out.println("존재하지 않는 편명입니다. 다시 입력해주세요.");
			}
		}
	}
	public void showReservation() {
		
		System.out.println("***개인정보유출에 주의하세요.***");
		System.out.println("***예약 전체 조회***");
		
		String position = Employee.currentEmployee.getPosition();
		if (position.equals("과장") || position.equals("팀장") || position.equals("부장") ) {
			ec.showReservation();
		} else {
			System.out.println("***예약 전체 조회는 과장,팀장,부장만 가능합니다.***");
		}
	}
	
	
	//--------------------------------응답화면----------------------------------//
	
	public void displayNoData(String message) {
		System.out.println("\n" + message);
	}
	
	public void displayFlightList(ArrayList<Flight> list) {
		for(int i=0; i<list.size(); i++) {
			System.out.println("["+(i+1)+"] " + list.get(i));
		}
	}
	
	public void displayReservationList(ArrayList<Reservation> list) {
		for(int i=0; i<list.size(); i++) {
			System.out.println("["+(i+1)+"] " + list.get(i));
		}
	}
	
	public void displaySuccess(String message) {
		System.out.println("\n" + message);
	}
	
	public void displayFail(String message) {
		System.out.println("\n" + message);
	}
}
