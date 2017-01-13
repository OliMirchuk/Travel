package ua.com.love_travel.dto;

public class CityDTO {
	
	private int id;
	private String cityName;
	private String idCountry;
	
	public CityDTO() {
		
	}

	public CityDTO(int id, String cityName) {
		super();
		this.id = id;
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

	public String getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(String idCountry) {
		this.idCountry = idCountry;
	}

	@Override
	public String toString() {
		return "CityDTO [cityName=" + cityName + ", idCountry=" + idCountry
				+ "]";
	}
	
	
	
}
