package com.Stream_Api;

public class Supplier {
	Integer id;
	String sname;
	public Supplier(Integer id, String sname) {
		super();
		this.id = id;
		this.sname = sname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	

}
