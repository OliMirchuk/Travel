package ua.com.love_travel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.love_travel.entity.Country;


public interface CountryDao extends JpaRepository<Country, Integer>{
	
	Country findByCountryName(String countryName);
	
	@Query("select distinct c from Country c left join fetch c.cities")
	List<Country> findCountryWithCity();

	@Query("select distinct c from Country c left join fetch c.cities where c.id =:id")
	Country findCountryWithCity(@Param("id") int id);
	
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Country c WHERE c.countryName =:countryName")
	boolean countryExistsByCountryName(@Param("countryName") String countryName);
}
