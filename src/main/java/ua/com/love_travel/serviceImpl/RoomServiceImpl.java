package ua.com.love_travel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.love_travel.dao.RoomDao;
import ua.com.love_travel.dao.TravelDao;
import ua.com.love_travel.entity.Room;
import ua.com.love_travel.entity.Travel;
import ua.com.love_travel.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private TravelDao travelDao;
	
	public void save(Room room) {
		roomDao.save(room);
	}

	public List<Room> findAll() {
	 
		return  roomDao.findAll();
	}

	public Room findOne(int id) {
		return roomDao.findOne(id);
	}
	@Transactional
	public void delete(int id) {
		Room room = roomDao.findOne(id);
		for(Travel travel: room.getTravels()){
			travel.setRoom(null);
			travelDao.save(travel);
		}
		roomDao.delete(id);
	}

	


}
