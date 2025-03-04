package com.ig.model;

public class Scholar {
	private Integer rollno;
	private String name;
	private String email;
	private String mobile;
	public Scholar(Integer rollno, String name, String email, String mobile) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}
	public Integer getRollno() {
		return rollno;
	}
	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	

}
