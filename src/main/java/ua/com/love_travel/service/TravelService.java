package ua.com.love_travel.service;

import java.util.List;

import ua.com.love_travel.entity.Travel;

public interface TravelService {

	void save(Travel hotel);
	
	List<Travel> findAll();
	
	Travel findOne(int id);
	
	void delete(int id);

	List<Travel> sortTravels(int value);

}
