package ua.com.love_travel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ua.com.love_travel.dao.TravelDao;
import ua.com.love_travel.entity.Travel;
import ua.com.love_travel.service.TravelService;

@Service
public class TravelServiceImpl implements TravelService{
	
	@Autowired
	private TravelDao travelDao;

	public void save(Travel travel) {
		travelDao.save(travel);
	}

	public List<Travel> findAll() {
	 
		return  travelDao.findAll();
	}

	public Travel findOne(int id) {
		return  travelDao.findOne(id);
	}
	
	public void delete(int id) {
		travelDao.delete(id);
	}

	@Override
	public List<Travel> sortTravels(int value) {
		return travelDao.sortTravels(value);
	}


	
	

}
