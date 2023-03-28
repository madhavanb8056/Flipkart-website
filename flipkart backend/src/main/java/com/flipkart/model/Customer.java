package com.flipkart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity

@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "mobile_number")
	private long mobileNumber;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "email")
	private String email;
	@Column(name = "address")
	private String address;
	@Column(name = "password")
	private String password;
	
	public Customer() {
	}
	
	public Customer(long id, long mobileNumber, String userName, String email, String address, String password) {
		super();
		this.id = id;
		this.mobileNumber = mobileNumber;
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.password = password;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	

}
