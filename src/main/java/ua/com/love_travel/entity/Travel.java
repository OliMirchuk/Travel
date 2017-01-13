package ua.com.love_travel.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Travel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate day_start;
	private String type_traffic;
	private int days_trip;
	private int cost_travel;

	@ManyToOne
	private Country country;
	
	@ManyToOne
	private City city;
	
	@ManyToOne
	private Hotel hotel;
	
	@ManyToOne
	private Room room;
	
	@ManyToMany
	@JoinTable(name = "user_travel", joinColumns = @JoinColumn(name = "travel_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;
	
	public Travel() {
		// TODO јвтоматически созданна€ заглушка конструктора
	}
	
	public Travel(LocalDate day_start, String type_traffic, int days_trip,
			int cost_travel) {
		super();
		this.day_start = day_start;
		this.type_traffic = type_traffic;
		this.days_trip = days_trip;
		this.cost_travel = cost_travel;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public LocalDate getDay_start() {
		return day_start;
	}

	public void setDay_start(LocalDate day_start) {
		this.day_start = day_start;
	}

	
	public int getDays_trip() {
		return days_trip;
	}

	public void setDays_trip(int days_trip) {
		this.days_trip = days_trip;
	}

	public int getCost_travel() {
		return cost_travel;
	}

	public void setCost_travel(int cost_travel) {
		this.cost_travel = cost_travel;
	}

	public String getType_traffic() {
		return type_traffic;
	}

	public void setType_traffic(String type_traffic) {
		this.type_traffic = type_traffic;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}


	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}


}
