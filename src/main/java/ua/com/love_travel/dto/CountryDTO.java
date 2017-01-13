package ua.com.love_travel.dto;

public class CountryDTO {

	private int id;
	private String countryName;

	public CountryDTO() {
		// TODO Auto-generated constructor stub
	}

	public CountryDTO(int id, String countryName) {
		super();
		this.id = id;
		this.countryName = countryName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	
}
