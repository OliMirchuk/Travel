package ua.com.love_travel.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class City {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String cityName;
	
	@ManyToOne
	private Country country;
	
	@OneToMany(mappedBy = "city")
	private List<Travel> travels;
	
	@OneToMany(mappedBy = "city")
	private List<Hotel> hotels;
	
	public List<Hotel> getHotels() {
		return hotels;
	}


	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}


	public City() {
		// TODO Auto-generated constructor stub
	}
	

	public City(String cityName) {
		super();
		this.cityName = cityName;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}


	public List<Travel> getTravels() {
		return travels;
	}


	public void setTravels(List<Travel> travels) {
		this.travels = travels;
	}


	@Override
	public String toString() {
		return "City [id=" + id + ", cityName=" + cityName + "]";
	}


	

	
	
	

	

}
