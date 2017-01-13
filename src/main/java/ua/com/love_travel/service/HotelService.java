package ua.com.love_travel.service;

import java.util.List;

import ua.com.love_travel.entity.Hotel;

public interface HotelService {

	void save(Hotel hotel);
	
	List<Hotel> findAll();
	
	Hotel findOne(int id);
	
	void delete(int id);

	/*void deleteRoomFromHotel(String idRoom);
	
	List<Hotel> findHotelWithRooms();
	
	void saveAndFlush(Hotel hotel);*/
}
