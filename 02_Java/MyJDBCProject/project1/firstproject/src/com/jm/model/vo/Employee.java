package com.jm.model.vo;

import java.util.Objects;

public class Employee {
	private int emp_no;
	private String emp_name;
	private String emp_pwd;
	private String position;
	
	public static Employee currentEmployee = null;
	
	public Employee() {
		super();
	}

	public Employee(int emp_no, String emp_name, String emp_pwd, String position) {
		super();
		this.emp_no = emp_no;
		this.emp_name = emp_name;
		this.emp_pwd = emp_pwd;
		this.position = position;
	}

	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_pwd() {
		return emp_pwd;
	}

	public void setEmp_pwd(String emp_pwd) {
		this.emp_pwd = emp_pwd;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emp_name, emp_no, emp_pwd, position);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(emp_name, other.emp_name) && emp_no == other.emp_no
				&& Objects.equals(emp_pwd, other.emp_pwd) && Objects.equals(position, other.position);
	}

	@Override
	public String toString() {
		return "Employee [emp_no=" + emp_no + ", emp_name=" + emp_name + ", emp_pwd=" + emp_pwd + ", position="
				+ position + "]";
	}
	
	
	
	

}
