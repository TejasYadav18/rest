package com.pro.entity;

import javax.persistence.Entity;

@Entity(name="USER")
public class User {
	String name;
	String address;
	long mobileNo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
