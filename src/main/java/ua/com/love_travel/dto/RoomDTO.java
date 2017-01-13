package ua.com.love_travel.dto;

public class RoomDTO {
	
	private int id;
	private int number_room;
	private int floor;
	private int number_of_people;
	private String room_type;
	private String idHotel;
	
	public RoomDTO() {
		
	}


	public RoomDTO(int id, int number_room, int floor, int number_of_people,
			String room_type) {
		super();
		this.id = id;
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

	public String getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}

	public int getFloor() {
		return floor;
	}


	public void setFloor(int floor) {
		this.floor = floor;
	}


	@Override
	public String toString() {
		return "RoomDTO [number_room=" + number_room + ", number_of_people="
				+ number_of_people + ", room_type=" + room_type + ", idHotel="
				+ idHotel + "]";
	}
	
	
}
