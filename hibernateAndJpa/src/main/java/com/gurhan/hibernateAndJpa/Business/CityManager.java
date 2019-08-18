package com.gurhan.hibernateAndJpa.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gurhan.hibernateAndJpa.DataAccess.ICityDal;
import com.gurhan.hibernateAndJpa.Entities.City;

@Service
public class CityManager implements ICityService {

	ICityDal cityDal;
	
	@Autowired
	public CityManager(ICityDal cityDal) {
		super();
		this.cityDal = cityDal;
	}

	@Override
	@Transactional
	public List<City> getAll() {
		// TODO Auto-generated method stub
		return this.cityDal.getAll();
	}

	@Override
	@Transactional
	public void add(City city) {

		this.cityDal.add(city);				
	}

	@Override
	@Transactional
	public void update(City city) {

		this.cityDal.update(city);		
	}

	@Override
	@Transactional
	public void delete(City city) {

		this.cityDal.delete(city);
	}

	@Override
	@Transactional
	public City getByID(int id) {

		return this.cityDal.getByID(id);
	}
}
