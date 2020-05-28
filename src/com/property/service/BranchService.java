package com.property.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.property.model.Branch;

public class BranchService {
	
	private static List<Branch> branches = new ArrayList<>();
//	private Map<int, Branch> branches = new HashMap<>();
	
	public int getNoOfBranch() {
		return branches.size();
	}
	
	public List<Branch> getBranches() {
		return branches;
	}
	
	public Branch getBranch(int id) {
		for(Branch b : branches) {
			if ( b.getId() == id) {
				return b;
			}
		}
		return null;
	}
	
	public Branch getBranch(String username) {
		for(Branch b : branches) {
			if ( b.getUserName().equals(username)) {
				return b;
			}
		}
		return null;
	}

	public int getBranchId(String username) {
		for(Branch b : branches) {
			if (username.equals(b.getUserName())) {
				return b.getId();
			}
		}
		return -1;
	}
	
	public boolean createBranch(Branch branch) {
		if(branches.add(branch)) {
			return true;
		}
		return false;
	}
	
	public boolean updateBranch(int id, Branch branch) {
			if (getBranch(id) != null) {
				int i = branches.indexOf(getBranch(id));
				branch.setId(id);
				branches.set(i, branch);
				return true;
			}
		return false;
	}
	
	public boolean deleteBranch(int id) {
		for(Branch b: branches) {
			if (b.getId() == id) {
				branches.remove(b);
				System.out.println(b.toString());
				return true;
			}
		}
		return false;
	}
	
	public boolean exists(String username) {
		for (Branch b : branches) {
			if(b.getUserName().equals(username)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean exists(String username, String password) {
		for (Branch b : branches) {
			if(b.getUserName().equals(username) && b.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}
