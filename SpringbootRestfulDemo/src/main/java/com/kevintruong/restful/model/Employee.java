package com.kevintruong.restful.model;

public class Employee {
	private String empNo;
	private String empName;
	private String position;
	private int salary;
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee() {

	}

	public Employee(String empNo, String empName, String position,int salary) {
		this.empNo = empNo;
		this.empName = empName;
		this.position = position;
		this.salary = salary ;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
