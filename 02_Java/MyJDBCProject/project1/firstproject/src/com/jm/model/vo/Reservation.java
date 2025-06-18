package com.jm.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Reservation {
	private int reservation_no;
	private String m_id;
	private String name;
	private String birth_date;
	private String flight_no;
	private String departure;
	private String destination;
	private Date dep_date;
	private Date arrival_date;
	
	public Reservation() {
		super();
	}

	public Reservation(int reservation_no, String m_id, String name, String birth_date, String flight_no,
			String departure, String destination, Date dep_date, Date arrival_date) {
		super();
		this.reservation_no = reservation_no;
		this.m_id = m_id;
		this.name = name;
		this.birth_date = birth_date;
		this.flight_no = flight_no;
		this.departure = departure;
		this.destination = destination;
		this.dep_date = dep_date;
		this.arrival_date = arrival_date;
	}

	public int getReservation_no() {
		return reservation_no;
	}

	public void setReservation_no(int reservation_no) {
		this.reservation_no = reservation_no;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getFlight_no() {
		return flight_no;
	}

	public void setFlight_no(String flight_no) {
		this.flight_no = flight_no;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDep_date() {
		return dep_date;
	}

	public void setDep_date(Date dep_date) {
		this.dep_date = dep_date;
	}

	public Date getArrival_date() {
		return arrival_date;
	}

	public void setArrival_date(Date arrival_date) {
		this.arrival_date = arrival_date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrival_date, birth_date, dep_date, departure, destination, flight_no, m_id, name,
				reservation_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(arrival_date, other.arrival_date) && Objects.equals(birth_date, other.birth_date)
				&& Objects.equals(dep_date, other.dep_date) && Objects.equals(departure, other.departure)
				&& Objects.equals(destination, other.destination) && Objects.equals(flight_no, other.flight_no)
				&& Objects.equals(m_id, other.m_id) && Objects.equals(name, other.name)
				&& reservation_no == other.reservation_no;
	}

	@Override
	public String toString() {
		return "예약번호: " + reservation_no + ", 아이디: " + m_id + ", 성명: " + name + ", 생년월일: "
				+ birth_date + ",  편명: " + flight_no + ", 출발지: " + departure + ", 도착지: " + destination
				+ ", 출발날짜: " + dep_date + ", 도착날짜: " + arrival_date;
	}
	


	
	
}
