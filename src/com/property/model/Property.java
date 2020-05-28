package com.property.model;

public class Property {
	
	private static int count = 1;
	
	protected int id;
	protected String address;
	protected int noOfRooms;
	protected double sellingPrice;
	protected double soldPrice;
	protected int branchId;
	
	public Property() {}
	
	public Property(String address, int noOfRooms, double sellingPrice, double soldPrice, int branchId) {
		this.id = count++;
		this.address = address;
		this.noOfRooms = noOfRooms;
		this.sellingPrice = sellingPrice;
		this.soldPrice = soldPrice;
		this.branchId = branchId;
	}
	
	public Property(int id, String address, int noOfRooms, double sellingPrice, double soldPrice, int branchId) {
		this.id = id;
		this.address = address;
		this.noOfRooms = noOfRooms;
		this.sellingPrice = sellingPrice;
		this.soldPrice = soldPrice;
		this.branchId = branchId;
	}
	
	public void setCount(int count) {
		Property.count = count;
	}
	
	public int getCount() {
		return Property.count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public double getSoldPrice() {
		return soldPrice;
	}

	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	
	
	
}
