package com.property.utils;

import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.property.model.Flat;
import com.property.model.House;
import com.property.service.BranchService;

public class Validator {
	
	private BranchService bs = new BranchService();
	
	private static String user;
	

	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		Validator.user = user;
	}


	public String validateLogin(String userName, String password) {
		if(userName.equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(new JFrame(),"Enter User Name and password","Alert",JOptionPane.WARNING_MESSAGE);
			return "";
		}
		if(userName.equals("admin") && password.equals("admin")) {
			Validator.user = userName;
			return userName;
		}
		
		if(bs.exists(userName, password)) {
			Validator.user = userName;
			return userName;
		}
		JOptionPane.showMessageDialog(new JFrame(),"Incorrect UserName or Password","Alert",JOptionPane.WARNING_MESSAGE);
		return "";
	}
	
	public boolean validateAddBranch(String name, String phoneNo, String address, String email, String webAddress, String userName, String password, String rePassword) {
		if(validateBranch(name, phoneNo, address, email, webAddress, userName, password, rePassword) && userNameExists(userName)) {
			return true;
		}
		return false;
	}
	
	public boolean validateBranch(String name, String phoneNo, String address, String email, String webAddress, String userName, String password, String rePassword) {
		if(
				name.equals("")
				|| phoneNo.equals("")
				|| address.equals("")
				|| email.equals("")
				|| webAddress.equals("")
				|| userName.equals("")
				|| password.equals("")
				|| rePassword.equals("")
			) {
			JOptionPane.showMessageDialog(new JFrame(),"All fields are compulsary.","Alert", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(!password.equalsIgnoreCase(rePassword)) {
			JOptionPane.showMessageDialog(new JFrame(),"Password and Re-Password doesnot match.","Alert", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	
	public boolean userNameExists(String userName) {
		if(bs.exists(userName)) {
			JOptionPane.showMessageDialog(new JFrame(),"User Name already exists.","Alert", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	
	public Flat validateFlat(String address, String noOfRooms, String sellingPrice, String soldPrice, String floorNo, String monthlyCharge) {
			if(
					address.equals("")
					|| noOfRooms.equals("")
					|| sellingPrice.equals("")
					|| floorNo.equals("")
					|| monthlyCharge.equals("")
						) {
				JOptionPane.showMessageDialog(new JFrame(),"All Fields are compulsary.","Alert", JOptionPane.WARNING_MESSAGE);
				return null;
			}
			try {
				int rooms = Integer.parseInt(noOfRooms);
				double sp = Double.parseDouble(sellingPrice);
				double solp = Double.parseDouble(soldPrice);
				int fn = Integer.parseInt(floorNo);
				int mc = Integer.parseInt(monthlyCharge);
				return new Flat(address, rooms, sp, solp, bs.getBranchId(user), fn, mc);
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(new JFrame(),"Invalid Input. Enter Numbers where required.","Alert", JOptionPane.WARNING_MESSAGE);
				return null;
			}

	}


	public House validateHouse(String address, String noOfRooms, String sellingPrice, String soldPrice, String noOfFloors, boolean hasGarden, boolean hasGarage) {
		if (
				address.equals("")
				|| noOfRooms.equals("")
				|| sellingPrice.equals("")
				|| noOfFloors.equals("")
				) {
			JOptionPane.showMessageDialog(new JFrame(),"All Fields are compulsary.","Alert", JOptionPane.WARNING_MESSAGE);
			return null;
		}
		try {
			int rooms = Integer.parseInt(noOfRooms);
			double sp = Double.parseDouble(sellingPrice);
			double solp = Double.parseDouble(soldPrice);
			int fn = Integer.parseInt(noOfFloors);
			return new House(address, rooms, sp, solp, bs.getBranchId(user), fn, hasGarden, hasGarden);
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(new JFrame(),"Invalid Input. Enter Numbers where required.","Alert", JOptionPane.WARNING_MESSAGE);
		}
		return null;
	}
	
	public void closeWindow(WindowEvent e) {
		new FileManager().writeBranch();
		new FileManager().writeHouse();
		new FileManager().writeFlat();
		new FileManager().writeId();
		JOptionPane.showMessageDialog(null,"Exiting the system.");
		System.exit(0);
	}
}
