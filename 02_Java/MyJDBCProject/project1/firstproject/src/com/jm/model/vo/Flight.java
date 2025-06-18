package com.jm.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Flight {
	private String flight_no;
	private String departure;
	private String destination;
	private Date dep_date;
	private Date arrival_date;
	private int seat_count;
	private int price;
	
	public Flight() {
		super();
	}

	public Flight(String flight_no, String departure, String destination, Date dep_date, Date arrival_date,
			int seat_count, int price) {
		super();
		this.flight_no = flight_no;
		this.departure = departure;
		this.destination = destination;
		this.dep_date = dep_date;
		this.arrival_date = arrival_date;
		this.seat_count = seat_count;
		this.price = price;
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

	public int getSeat_count() {
		return seat_count;
	}

	public void setSeat_count(int seat_count) {
		this.seat_count = seat_count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrival_date, dep_date, departure, destination, flight_no, price, seat_count);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		return Objects.equals(arrival_date, other.arrival_date) && Objects.equals(dep_date, other.dep_date)
				&& Objects.equals(departure, other.departure) && Objects.equals(destination, other.destination)
				&& Objects.equals(flight_no, other.flight_no) && price == other.price && seat_count == other.seat_count;
	}

	@Override
	public String toString() {
		return "편명: " + flight_no + ", 출발지: " + departure + ", 도착지: " + destination
				+ ", 출발 날짜: " + dep_date + ", 도착 날짜: " + arrival_date + ", 남은 좌석 수: " + seat_count
				+ ", 가격: " + price ;
	}


	
	
	
	
	

}
