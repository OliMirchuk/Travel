package ua.com.love_travel.service;

import java.util.List;

import ua.com.love_travel.entity.Country;

public interface CountryService {

	void save(Country country);
	
	List<Country> findAll();
	
	Country findOne(int id);
	
	void delete(int id);	
	
	Country findByCountryName(String countryName);
	
	Country findCountryWithCities(int id);
}
