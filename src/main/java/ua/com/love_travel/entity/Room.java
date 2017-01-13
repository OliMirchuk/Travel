package ua.com.love_travel.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int number_room;
	private int floor;
	private int number_of_people;
	private String room_type;
	
	@ManyToOne
	private Hotel hotel;
	
	@OneToMany(mappedBy = "room")
	private List<Travel> travels;
	
	public Room() {
		// TODO јвтоматически созданна€ заглушка конструктора
	}

	public Room(int number_room, int floor, int number_of_people, String room_type) {
		super();
		this.number_room = number_room;
		this.floor = floor;
		this.number_of_people = number_of_people;
		this.room_type = room_type;
		
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNumber_room() {
		return number_room;
	}


	public void setNumber_room(int number_room) {
		this.number_room = number_room;
	}


	public int getFloor() {
		return floor;
	}


	public void setFloor(int floor) {
		this.floor = floor;
	}


	public int getNumber_of_people() {
		return number_of_people;
	}


	public void setNumber_of_people(int number_of_people) {
		this.number_of_people = number_of_people;
	}


	public String getRoom_type() {
		return room_type;
	}


	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Travel> getTravels() {
		return travels;
	}

	public void setTravels(List<Travel> travels) {
		this.travels = travels;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", number_room=" + number_room + ", floor="
				+ floor + ", number_of_people=" + number_of_people
				+ ", room_type=" + room_type + "]";
	}

	

	

}
