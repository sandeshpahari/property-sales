package com.property.model;

public class Flat extends Property {

	private int floorNo;
	private int monthlyCharge;
	public Flat() {
		super();
	}
	public Flat(String address, int noOfRooms, double sellingPrice, double soldPrice, int branchId, int floorNo, int monthlyCharge) {
		super(address, noOfRooms, sellingPrice, soldPrice, branchId);
		this.floorNo = floorNo;
		this.monthlyCharge = monthlyCharge;
	}
	
	public Flat(int id, String address, int noOfRooms, double sellingPrice, double soldPrice, int branchId, int floorNo, int monthlyCharge) {
		super(id, address, noOfRooms, sellingPrice, soldPrice, branchId);
		this.floorNo = floorNo;
		this.monthlyCharge = monthlyCharge;
	}
	
	public int getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	public int getMonthlyCharge() {
		return monthlyCharge;
	}
	public void setMonthlyCharge(int monthlyCharge) {
		this.monthlyCharge = monthlyCharge;
	}
	
	@Override
	public String toString() {
		return this.id + "," + this.address + "," + this.noOfRooms + "," + this.sellingPrice + "," + this.soldPrice + "," + this.branchId + "," + this.floorNo + "," + this.monthlyCharge;
	}
	
	
}
