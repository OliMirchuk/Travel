package ua.com.love_travel.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.love_travel.entity.Travel;

public interface TravelDao extends JpaRepository<Travel, Integer>{

	@Query("select t from Travel t where t.cost_travel >= :value")
    List<Travel> sortTravels(@Param("value") int value);
}
