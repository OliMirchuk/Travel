package ua.com.love_travel.service;

import java.util.List;

import ua.com.love_travel.entity.Room;

public interface RoomService {
	
	void save(Room room);
	
	List<Room> findAll();
	
	Room findOne(int id);
	
	void delete(int id);

	
	
}
