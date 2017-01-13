package ua.com.love_travel.dto;

import java.util.ArrayList;
import java.util.List;


import ua.com.love_travel.entity.City;
import ua.com.love_travel.entity.Country;
import ua.com.love_travel.entity.Hotel;
import ua.com.love_travel.entity.Room;
import ua.com.love_travel.entity.Travel;
import ua.com.love_travel.entity.User;



public class DtoUtilMapper {
	
	public static List<UserDTO> usersToUsersDTO(List<User> users) {

		List<UserDTO> userDTOs = new ArrayList<UserDTO>();

		for (User user : users) {

			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setEmail(user.getEmail());
			
			userDTOs.add(userDTO);

		}

		return userDTOs;

	}
	
public static List<CountryDTO> countriesToCountriesDTOs(List<Country> countries){
		
		List<CountryDTO> countryDTOs = new ArrayList<CountryDTO>();
		
		for(Country country : countries){
			countryDTOs.add(new CountryDTO(country.getId(), country.getCountryName()));
		}
		return countryDTOs;
	}

	public static List<CityDTO> cityToCityDTO(List<City> cities){

		List<CityDTO> cityDTOs = new ArrayList<>();

		for (City city : cities) {
			cityDTOs.add(new CityDTO(city.getId(), city.getCityName()));
		}

		return cityDTOs;

	}



	public static List<HotelDTO> hotelToHotelDTO(List<Hotel> hotels){
		
		List<HotelDTO> hotelDTOs = new ArrayList<>();
		
		for (Hotel hotel : hotels) {
			hotelDTOs.add(new HotelDTO(hotel.getId(), hotel.getHotelName(), hotel.getStars(), hotel.getType_of_food()));
		}
		return hotelDTOs;
	}

	public static List<RoomDTO> roomToRoomDTO(List<Room> rooms){
		List<RoomDTO> roomDTOs = new ArrayList<>();
		for (Room room : rooms) {
			roomDTOs.add(new RoomDTO(room.getId(),room.getNumber_room(), room.getFloor(), room.getNumber_of_people(), room.getRoom_type()));
		}
		return roomDTOs;
	}

	public static List<TravelDTO> travelToTravelDTO(List<Travel> travels){
		List<TravelDTO> travelDTOs = new ArrayList<TravelDTO>();
		
		for (Travel travel : travels) {
			travelDTOs.add(new TravelDTO( travel.getDay_start(), travel.getType_traffic(), travel.getDays_trip(), travel.getCost_travel()));
		}
		return travelDTOs;
	}


}
	