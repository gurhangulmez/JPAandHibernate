package com.gurhan.hibernateAndJpa.Business;

import java.util.List;

import com.gurhan.hibernateAndJpa.Entities.City;

public interface ICityService {

	List<City> getAll();
	void add(City city);
	void update(City city);	
	void delete(City city);	
	City getByID(int id);
}
