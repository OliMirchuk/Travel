package ua.com.love_travel.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String hotelName;
	private int stars;
	private String type_of_food;
	
	@ManyToOne
	private City city;
	
	@OneToMany(mappedBy = "hotel")
	private List<Travel> travels;
	
	@OneToMany(mappedBy = "hotel")
	private List<Room> rooms;
	
	public Hotel() {
		// TODO јвтоматически созданна€ заглушка конструктора
	}

	public Hotel(String hotelName, int stars, String type_of_food ) {
		super();
		this.hotelName = hotelName;
		this.stars = stars;
		this.type_of_food = type_of_food;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getType_of_food() {
		return type_of_food;
	}

	public void setType_of_food(String type_of_food) {
		this.type_of_food = type_of_food;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public List<Travel> getTravels() {
		return travels;
	}

	public void setTravels(List<Travel> travels) {
		this.travels = travels;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", hotelName=" + hotelName + ", stars="
				+ stars + ", type_of_food=" + type_of_food + "]";
	}

	

	

}
