package com.Stream_Api;

import java.time.LocalDate;
//import java.util.function.Supplier;

public class Product {
	Integer id;
	String name;
	String type;
	Double qty;
	Double price;
	LocalDate expiryDate;
	Supplier suppiler;
	public Product(Integer id, String name, String type, Double qty, Double price, LocalDate expiryDate,
			Supplier suppiler) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.qty = qty;
		this.price = price;
		this.expiryDate = expiryDate;
		this.suppiler = suppiler;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", qty=" + qty + ", price=" + price
				+ ", expiryDate=" + expiryDate + ", suppiler=" + suppiler + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getQty() {
		return qty;
	}
	public void setQty(Double qty) {
		this.qty = qty;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Supplier getSuppiler() {
		return suppiler;
	}
	public void setSuppiler(Supplier suppiler) {
		this.suppiler = suppiler;
	}
	

}
