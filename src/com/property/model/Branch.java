package com.property.model;

public class Branch {
	
	private static int count = 1;
	
	private int id;
	private String name;
	private String phoneNo;
	private String address;
	private String email;
	private String webAddress;
	private String userName;
	private String password;
	
	public Branch() {}
	
	public Branch(String name, String phoneNo, String address, String email, String webAddress, String userName,
			String password) {
		this.id = count++;
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
		this.email = email;
		this.webAddress = webAddress;
		this.userName = userName;
		this.password = password;
	}
	
	public Branch(int id, String name, String phoneNo, String address, String email, String webAddress, String userName,
			String password) {
		this.id = id;
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
		this.email = email;
		this.webAddress = webAddress;
		this.userName = userName;
		this.password = password;
	}
	
	public void setCount(int count) {
		Branch.count = count;
	}
	
	public int getCount() {
		return Branch.count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return this.id + "," +  this.name + "," + this.phoneNo + "," + this.address + "," + this.email + "," + this.webAddress + "," + this.userName +  "," + this.password;
	}
	
	
	

}
