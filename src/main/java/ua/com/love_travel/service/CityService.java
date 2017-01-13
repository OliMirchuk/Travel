package ua.com.love_travel.service;

import java.util.List;

import ua.com.love_travel.entity.City;

public interface CityService {

	void save(City city);
	
	List<City> findAll();
	
    City findOne(int id);
	
	void delete(int id);	

}
