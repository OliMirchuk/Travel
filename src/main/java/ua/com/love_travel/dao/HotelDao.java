package ua.com.love_travel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.love_travel.entity.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Integer>{

	@Query("select distinct h from Hotel h left join fetch h.rooms")
	List<Hotel> findHotelWithRoom();

	@Query("select distinct h from Hotel h left join fetch h.rooms where h.id =:id")
	Hotel findHotelWithRoom(@Param("id") int id);
	
}
