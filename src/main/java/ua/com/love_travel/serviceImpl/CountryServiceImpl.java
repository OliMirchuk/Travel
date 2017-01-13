package ua.com.love_travel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import org.springframework.transaction.annotation.Transactional;

import ua.com.love_travel.dao.CityDao;
import ua.com.love_travel.dao.CountryDao;
import ua.com.love_travel.dao.TravelDao;
import ua.com.love_travel.entity.City;
import ua.com.love_travel.entity.Country;
import ua.com.love_travel.entity.Travel;
import ua.com.love_travel.service.CountryService;


@Service
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	private CountryDao �ountryDao;
	@Autowired
	private CityDao cityDao;
	@Autowired
	private TravelDao travelDao;
	
	public void save(Country country) {
		 �ountryDao.save(country);
	}

	public List<Country> findAll() {
	 
		return �ountryDao.findAll();
	}

	public Country findOne(int id) {
		return �ountryDao.findOne(id);
	}
	@Transactional
	public void delete(int id) {
		Country country = �ountryDao.findCountryWithCity(id);
		
		for (City city : country.getCities()) {
			city.setCountry(null);
			cityDao.save(city);
		}
		for(Travel travel: country.getTravels()){
			travel.setCountry(null);
			travelDao.save(travel);
		}
		�ountryDao.delete(country);
	}

	public Country findByCountryName(String countryName) {
		return �ountryDao.findByCountryName(countryName);
	}

	@Override
	public Country findCountryWithCities(int id) {
		return �ountryDao.findCountryWithCity(id);
	}

	

	
	

}
