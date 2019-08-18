package com.gurhan.hibernateAndJpa.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gurhan.hibernateAndJpa.Entities.City;

@Repository
public class HibernateCityDal implements ICityDal {

	private EntityManager entityManager;
	
	@Autowired
	public HibernateCityDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public HibernateCityDal()
	{
		
	}
	
	
	@Override
	@Transactional
	public List<City> getAll() {

		Session session = entityManager.unwrap(Session.class);

		List<City> cities = session.createQuery("from City",City.class).getResultList();
		return cities;
	}

	@Override
	public void add(City city) {
		
		//if city.id is not null saves, else updated.
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);		
	}

	@Override
	public void update(City city) {

		//if city.id is not null this method saves, else updates.
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);		
	}

	@Override
	public void delete(City city) {
		
		Session session = entityManager.unwrap(Session.class);
		city = session.get(City.class, city.getId());
		session.delete(city);		
	}


	@Override
	public City getByID(int id) {

		Session session = entityManager.unwrap(Session.class);
		City city = session.get(City.class, id);
		
		return city;		
	}

}
