package com.property.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.property.model.Branch;
import com.property.model.Flat;
import com.property.model.House;
import com.property.model.Property;
import com.property.service.BranchService;
import com.property.service.FlatService;
import com.property.service.HouseService;

public class FileManager {
	
	private BranchService bs;
	private HouseService hs;
	private FlatService fs;

	public void loadBranch() {
		bs = new BranchService();
		Branch branch;
		
	    String fileToParse = "F:\\property-sales\\src\\com\\property\\resource\\branches.csv";
	    BufferedReader fileReader = null;
	       
	      final String DELIMITER = ",";
	      try
	      {
	          String line = "";
	          fileReader = new BufferedReader(new FileReader(fileToParse));
	           
	          while ((line = fileReader.readLine()) != null) 
	          {
	              String[] tokens = line.split(DELIMITER);
	              int id = Integer.parseInt(tokens[0]);
	              String name = tokens[1];
	              String phoneNo = tokens[2];
	              String address = tokens[3];
	              String email = tokens[4];
	              String webAddress = tokens[5];
	              String username = tokens[6];
	              String password = tokens[7];
	              
	              branch = new Branch(id, name, phoneNo, address, email, webAddress, username, password);
	              bs.createBranch(branch);
	              System.out.println("End of a branch");
	          }
	      } 
	      catch (Exception e) {
	          e.printStackTrace();
	      } 
	      finally
	      {
	          try {
	              fileReader.close();
	          } catch (IOException e) {
	              e.printStackTrace();
	          }
	      }
	}
	
	public void writeBranch() {
		bs = new BranchService();
		  
	    BufferedWriter buffer = null;
	    try {
	    	FileWriter writer = new FileWriter("F:\\property-sales\\src\\com\\property\\resource\\branches.csv");
	    	
	    	buffer = new BufferedWriter(writer);
	    	for(Branch b : bs.getBranches()) {
	    		buffer.write(b.toString());
	    		buffer.write("\n");
	    	}
	    } catch (Exception e)  {
	    	e.printStackTrace();
	    } finally {
	    	{
	    		try {
	    			buffer.close();
	    		} catch(IOException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    }
	    
	}
	
	public void loadHouse() {
		
		hs = new HouseService();
		House house;
		
		String fileToParse = "F:\\property-sales\\src\\com\\property\\resource\\houses.csv";
	    BufferedReader fileReader = null;
	       
	      final String DELIMITER = ",";
	      try
	      {
	          String line = "";
	          fileReader = new BufferedReader(new FileReader(fileToParse));
	           
	          while ((line = fileReader.readLine()) != null) 
	          {
	              String[] tokens = line.split(DELIMITER);
	              int id = Integer.parseInt(tokens[0]);
	              String address = tokens[1];
	              int noOfRooms = Integer.parseInt(tokens[2]);
	              double sellingPrice = Double.parseDouble(tokens[3]);
	              double soldPrice = Double.parseDouble(tokens[4]);
	              int branchId = Integer.parseInt(tokens[5]);
	              int noOfFloors = Integer.parseInt(tokens[6]);
	              boolean hasGarden = tokens[7] == "True" ? true : false;
	              boolean hasGarage = tokens[8] == "True" ? true : false;
	              
	              house = new House(id, address, noOfRooms, sellingPrice, soldPrice, branchId, noOfFloors, hasGarden, hasGarage);
	              hs.createHouse(house);
	              System.out.println("End of a branch");
	          }
	      } 
	      catch (Exception e) {
	          e.printStackTrace();
	      } 
	      finally
	      {
	          try {
	              fileReader.close();
	          } catch (IOException e) {
	              e.printStackTrace();
	          }
	      }
	}
	
	public void writeHouse() {
		hs = new HouseService();
		
	    BufferedWriter buffer = null;
	    try {
	    	FileWriter writer = new FileWriter("F:\\property-sales\\src\\com\\property\\resource\\houses.csv");
	    	
	    	buffer = new BufferedWriter(writer);
	    	System.out.println(hs.getHouses());
	    	for(House h : hs.getHouses()) {
	    		System.out.println(hs.getHouses());
	    		if(hs.getHouses() == null) {
	    			break;
	    		}
	    		buffer.write(h.toString());
	    		buffer.write("\n");
	    	}
	    } catch (Exception e)  {
	    	e.printStackTrace();
	    } finally {
	    	{
	    		try {
	    			buffer.close();
	    		} catch(IOException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    }
	    
	}
	
public void loadFlat() {
		
		fs = new FlatService();
		Flat flat;
		
		String fileToParse = "F:\\property-sales\\src\\com\\property\\resource\\flats.csv";
	    BufferedReader fileReader = null;
	       
	      final String DELIMITER = ",";
	      try
	      {
	          String line = "";
	          fileReader = new BufferedReader(new FileReader(fileToParse));
	           
	          while ((line = fileReader.readLine()) != null) 
	          {
	              String[] tokens = line.split(DELIMITER);
	              int id = Integer.parseInt(tokens[0]);
	              String address = tokens[1];
	              int noOfRooms = Integer.parseInt(tokens[2]);
	              double sellingPrice = Double.parseDouble(tokens[3]);
	              double soldPrice = Double.parseDouble(tokens[4]);
	              int branchId = Integer.parseInt(tokens[5]);
	              int floorNo = Integer.parseInt(tokens[6]);
	              int monthlyCharge = Integer.parseInt(tokens[7]);
	              
	              flat = new Flat(id, address, noOfRooms, sellingPrice, soldPrice, branchId, floorNo, monthlyCharge);
	              fs.createFlat(flat);
	              System.out.println("End of a branch");
	          }
	      } 
	      catch (Exception e) {
	          e.printStackTrace();
	      } 
	      finally
	      {
	          try {
	              fileReader.close();
	          } catch (IOException e) {
	              e.printStackTrace();
	          }
	      }
	}
	

	public void writeFlat() {
		fs = new FlatService();
		BufferedWriter buffer = null;
		try {
			FileWriter writer = new FileWriter("F:\\property-sales\\src\\com\\property\\resource\\flats.csv");
    	
			buffer = new BufferedWriter(writer);
			for(Flat f : fs.getFlats()) {
				if(fs.getFlats() == null) {
	    			break;
	    		}
				buffer.write(f.toString());
				buffer.write("\n");
			}
		} catch (Exception e)  {
			e.printStackTrace();
		} finally {
			try {
				buffer.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
    
	}
	
	public void loadId() {
		
	    String fileToParse = "F:\\property-sales\\src\\com\\property\\resource\\ids.csv";
	    BufferedReader fileReader = null;
	       
	      final String DELIMITER = ",";
	      try
	      {
	          String line = "";
	          fileReader = new BufferedReader(new FileReader(fileToParse));
	           
	          while ((line = fileReader.readLine()) != null) 
	          {
	              String[] tokens = line.split(DELIMITER);
	              int branchCount = Integer.parseInt(tokens[0]);
	              int propertyCount = Integer.parseInt(tokens[1]);
	              Branch branch = new Branch();
	              branch.setCount(branchCount);
	              Property property = new Property();
	              property.setCount(propertyCount);
	          }
	      } 
	      catch (Exception e) {
	          e.printStackTrace();
	      } 
	      finally
	      {
	          try {
	              fileReader.close();
	          } catch (IOException e) {
	              e.printStackTrace();
	          }
	      }
	}
	
	public void writeId() {
		BufferedWriter buffer = null;
		try {
			FileWriter writer = new FileWriter("F:\\property-sales\\src\\com\\property\\resourceids.csv");
    	
			buffer = new BufferedWriter(writer);
				buffer.write(((Integer) new Branch().getCount()).toString() + "," + ((Integer) new Property().getCount()).toString());
				buffer.write("\n");
		} catch (Exception e)  {
			e.printStackTrace();
		} finally {
			try {
				buffer.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
		

