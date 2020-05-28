package com.property.model;

public class House extends Property {
	private int noOfFloors;
	private boolean hasGarden;
	private boolean hasGarage;
	
	public House() {
		super();
	}
	
	public House(String address, int noOfRooms, double sellingPrice, double soldPrice, int branchId, int noOfFloors, boolean hasGarden, boolean hasGarage) {
		super(address, noOfRooms, sellingPrice, soldPrice, branchId);
		this.noOfFloors = noOfFloors;
		this.hasGarden = hasGarden;
		this.hasGarage = hasGarage;
	}
	
	public House(int id, String address, int noOfRooms, double sellingPrice, double soldPrice, int branchId, int noOfFloors, boolean hasGarden, boolean hasGarage) {
		super(id, address, noOfRooms, sellingPrice, soldPrice, branchId);
		this.noOfFloors = noOfFloors;
		this.hasGarden = hasGarden;
		this.hasGarage = hasGarage;
	}

	public int getNoOfFloors() {
		return noOfFloors;
	}

	public void setNoOfFloors(int noOfFloors) {
		this.noOfFloors = noOfFloors;
	}

	public boolean getHasGarden() {
		return hasGarden;
	}

	public void setHasGarden(boolean hasGarden) {
		this.hasGarden = hasGarden;
	}

	public boolean getHasGarage() {
		return hasGarage;
	}

	public void setHasGarage(boolean hasGarage) {
		this.hasGarage = hasGarage;
	}
	
	public String toString() {
		return this.id + "," + this.address + "," + this.noOfRooms + "," + this.sellingPrice + "," + this.soldPrice + "," + this.branchId + "," + this.noOfFloors + "," + this.hasGarden + "," + this.hasGarage;
	}
	
	
}
