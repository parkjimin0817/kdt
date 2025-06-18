package com.jm.model.vo;

import java.util.Objects;

public class Member {
	private String m_id;
	private String m_pwd;
	private String name;
	private String birth_date;
	private String phone;
	private String pp_no;
	private int mileage;
	
	public static Member currentUser = null;
	
	public Member() {
		super();
	}

	public Member(String m_id, String m_pwd, String name, String birth_date, String phone, String pp_no, int mileage) {
		super();
		this.m_id = m_id;
		this.m_pwd = m_pwd;
		this.name = name;
		this.birth_date = birth_date;
		this.phone = phone;
		this.pp_no = pp_no;
		this.mileage = mileage;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pwd() {
		return m_pwd;
	}

	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPp_no() {
		return pp_no;
	}

	public void setPp_no(String pp_no) {
		this.pp_no = pp_no;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birth_date, m_id, m_pwd, mileage, name, phone, pp_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return birth_date == other.birth_date && Objects.equals(m_id, other.m_id) && Objects.equals(m_pwd, other.m_pwd)
				&& mileage == other.mileage && Objects.equals(name, other.name) && Objects.equals(phone, other.phone)
				&& Objects.equals(pp_no, other.pp_no);
	}

	@Override
	public String toString() {
		return "아이디: " + m_id + ", 비밀번호: " + m_pwd + ", 이름: " + name + ", 생년월일: " + birth_date
				+ ", 전화번호: " + phone + ", 여권번호: " + pp_no + ", 마일리지: " + mileage;
	}
	
	
	
	

}
