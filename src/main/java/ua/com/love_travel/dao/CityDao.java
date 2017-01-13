package ua.com.love_travel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.love_travel.entity.City;


public interface CityDao extends JpaRepository<City, Integer>{

	@Query("select distinct c from City c left join fetch c.hotels")
	List<City> findCityWithHotel();

	@Query("select distinct c from City c left join fetch c.hotels where c.id =:id")
	City findCityWithHotel(@Param("id") int id);
	

}
