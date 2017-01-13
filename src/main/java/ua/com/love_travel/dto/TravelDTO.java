package ua.com.love_travel.dto;

import java.time.LocalDate;



public class TravelDTO {
	private int id;
	private LocalDate day_start;
	private String type_traffic;
	private int days_trip;
	private int cost_travel;
	private String idCountry;
	private String idCity;
	private String idHotel;
	private String idRoom;
	
	public TravelDTO() {
		
		// TODO Auto-generated constructor stub
	}

	

	public TravelDTO( LocalDate day_start, String type_traffic,
			int days_trip, int cost_travel) {
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
	

	public String getType_traffic() {
		return type_traffic;
	}



	public void setType_traffic(String type_traffic) {
		this.type_traffic = type_traffic;
	}



	public int getCost_travel() {
		return cost_travel;
	}

	public void setCost_travel(int cost_travel) {
		this.cost_travel = cost_travel;
	}

	public String getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(String idCountry) {
		this.idCountry = idCountry;
	}

	public String getIdCity() {
		return idCity;
	}

	public void setIdCity(String idCity) {
		this.idCity = idCity;
	}

	public String getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}

	public String getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(String idRoom) {
		this.idRoom = idRoom;
	}



	@Override
	public String toString() {
		return "TravelDTO [id=" + id + ", day_start=" + day_start
				+ ", type_traffic=" + type_traffic + ", days_trip=" + days_trip
				+ ", cost_travel=" + cost_travel + ", idCountry=" + idCountry
				+ ", idCity=" + idCity + ", idHotel=" + idHotel + ", idRoom="
				+ idRoom + "]";
	}

	
}