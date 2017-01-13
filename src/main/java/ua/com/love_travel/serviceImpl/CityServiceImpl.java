package ua.com.love_travel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.love_travel.dao.CityDao;
import ua.com.love_travel.dao.HotelDao;
import ua.com.love_travel.dao.TravelDao;
import ua.com.love_travel.entity.City;
import ua.com.love_travel.entity.Hotel;
import ua.com.love_travel.entity.Travel;
import ua.com.love_travel.service.CityService;


@Service
public class CityServiceImpl implements CityService{
	@Autowired
	private CityDao cityDao;
	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private TravelDao travelDao;
	
	public void save(City ñity) {
		cityDao.save(ñity);
	}

	public List<City> findAll() {
	 
		return cityDao.findAll();
	}

	public City findOne(int id) {
		return cityDao.findOne( id);
	}
	
	@Transactional
	public void delete(int id) {
		
		City city = cityDao.findCityWithHotel(id);
		for (Hotel hotel : city.getHotels()) {
			hotel.setCity(null);
			hotelDao.save(hotel);
		}
		for(Travel travel: city.getTravels()){
			travel.setCity(null);
			travelDao.save(travel);
		}
		cityDao.delete(city);
	}

	

	

}
