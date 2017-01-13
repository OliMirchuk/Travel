package ua.com.love_travel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;






import org.springframework.transaction.annotation.Transactional;

import ua.com.love_travel.dao.HotelDao;
import ua.com.love_travel.dao.RoomDao;
import ua.com.love_travel.dao.TravelDao;
import ua.com.love_travel.entity.Hotel;
import ua.com.love_travel.entity.Room;
import ua.com.love_travel.entity.Travel;
import ua.com.love_travel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private TravelDao travelDao;
	
	public void save(Hotel hotel) {
		hotelDao.save(hotel);
	}

	public List<Hotel> findAll() {
		return  hotelDao.findAll();
	}

	public Hotel findOne(int id) {
		return  hotelDao.findOne(id);
	}
	@Transactional
	public void delete(int id) {
		Hotel hotel = hotelDao.findHotelWithRoom(id);
		
		for (Room room : hotel.getRooms()) {
			room.setHotel(null);
			roomDao.save(room);
		}
		for(Travel travel: hotel.getTravels()){
			travel.setHotel(null);
			travelDao.save(travel);
		}
		hotelDao.delete(hotel);
		
	}
	
	

	


}
