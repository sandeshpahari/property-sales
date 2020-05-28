package com.property.service;

import java.util.ArrayList;
import java.util.List;

import com.property.model.House;

public class HouseService {
	
	private static List<House> houses = new ArrayList<House>();
	
	public List<House> getHouses() {
		return houses;
	}
	
	public House getHouse(int id) {
		for(House h: houses) {
			if(h.getId() == id) {
				return h;
			}
		}
		return null;
	}
	
	public boolean createHouse(House house) {
		if(houses.add(house)) {
			return true;
		}
		return false;
	}
	
	public boolean updateHouse(int id, House house) {
		for(House h: houses) {
			if(h.getId() == id) {
				int i = houses.indexOf(h);
				house.setId(id);
				houses.set(i, house);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteHouse(int id)
	{
		for(House h : houses) {
			if(h.getId() == id) {
				houses.remove(h);
				return true;
			}
		}
		return false;
	}
}
