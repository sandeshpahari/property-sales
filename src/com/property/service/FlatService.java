package com.property.service;

import java.util.ArrayList;
import java.util.List;

import com.property.model.Flat;

public class FlatService {
	
	private static List<Flat> flats = new ArrayList<Flat>();
	
	public Flat getFlat(int id) {
		for(Flat f: flats) {
			if(f.getId() == id) {
				return f;
			}
		}
		return null;
	}
	
	public List<Flat> getFlats() {
		return flats;
	}
	
	public boolean createFlat(Flat flat) {
		if(flats.add(flat)) {
			return true;
		}
		return false;
	}
	
	public boolean updateFlat(int id, Flat flat) {
		for(Flat f: flats) {
			if(f.getId() == id) {
				int i = flats.indexOf(f);
				flat.setId(id);
				flats.set(i, flat);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteFlat(int id) {
		for(Flat f: flats) {
			if (f.getId() == id) {
				flats.remove(f);
				return true;
			}
		}
		return false;
	}
}
