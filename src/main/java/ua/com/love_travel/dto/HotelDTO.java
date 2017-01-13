package ua.com.love_travel.dto;

public class HotelDTO {

	private int id;
	private String hotelName;
	private int stars;
	private String type_of_food;
	private String idCity;
	
	
	public HotelDTO() {
		// TODO Auto-generated constructor stub
	}

	public HotelDTO(int id, String hotelName, int stars, String type_of_food) {
		super();
		this.id = id;
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


	public String getIdCity() {
		return idCity;
	}


	public void setIdCity(String idCity) {
		this.idCity = idCity;
	}


	public String getType_of_food() {
		return type_of_food;
	}

	public void setType_of_food(String type_of_food) {
		this.type_of_food = type_of_food;
	}

	@Override
	public String toString() {
		return "HotelDTO [id=" + id + ", hotelName=" + hotelName + ", stars="
				+ stars + ", type_of_food=" + type_of_food + ", idCity="
				+ idCity + "]";
	}

	
	
	
}
