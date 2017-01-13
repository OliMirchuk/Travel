package ua.com.love_travel.controller;

import java.time.LocalDate;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.com.love_travel.dto.DtoUtilMapper;
import ua.com.love_travel.dto.TravelDTO;
import ua.com.love_travel.editor.CityEditor;
import ua.com.love_travel.editor.CountryEditor;
import ua.com.love_travel.editor.HotelEditor;
import ua.com.love_travel.editor.RoomEditor;
import ua.com.love_travel.entity.City;
import ua.com.love_travel.entity.Country;
import ua.com.love_travel.entity.Hotel;
import ua.com.love_travel.entity.Room;
import ua.com.love_travel.entity.Travel;
import ua.com.love_travel.service.CityService;
import ua.com.love_travel.service.CountryService;
import ua.com.love_travel.service.HotelService;
import ua.com.love_travel.service.RoomService;
import ua.com.love_travel.service.TravelService;

@Controller
public class TravelController {

	@Autowired
	private TravelService travelService;
	@Autowired
	private CityService cityService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private HotelService hotelService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
		binder.registerCustomEditor(City.class, new CityEditor(cityService));
		binder.registerCustomEditor(Hotel.class, new HotelEditor(hotelService));
		binder.registerCustomEditor(Room.class, new RoomEditor(roomService));
	}
	
	@RequestMapping(value = "/newTravel", method = RequestMethod.GET)
	public String newTravel(Model model){
		
		model.addAttribute("travel", new Travel());
		model.addAttribute("travels", travelService.findAll());
		model.addAttribute("citiesDTOs", DtoUtilMapper.cityToCityDTO(cityService.findAll()));
		model.addAttribute("countriesDTOs", DtoUtilMapper.countriesToCountriesDTOs(countryService.findAll()));
		model.addAttribute("roomsDTOs",  DtoUtilMapper.roomToRoomDTO(roomService.findAll()));
		model.addAttribute("hotelsDTOs", DtoUtilMapper.hotelToHotelDTO(hotelService.findAll()));
		return "views-admin-newTravel";
	}
	
	
	@RequestMapping (value = "/saveTravel", method = RequestMethod.POST)
	public String saveTravel(@ModelAttribute Travel travel,
			@RequestParam String date ){
		
		
		travel.setDay_start(LocalDate.parse(date));
		
		
		
		travelService.save(travel);
		
		return "redirect:/newTravel";
	}
	
	@RequestMapping(value = "/loadTravel", method = RequestMethod.POST)
    public @ResponseBody List<TravelDTO> saveTravel() {


       return DtoUtilMapper.travelToTravelDTO(travelService.findAll());

    }

	@RequestMapping(value = "/deleteTravel/{id}", method = RequestMethod.GET)
	public String newTravel(@PathVariable int id) {

		travelService.delete(id);
		
		return "redirect:/newTravel";
	}
	
	

	@RequestMapping(value = "/updateTravel", method = RequestMethod.POST)
	public @ResponseBody TravelDTO updateTravel (@RequestBody String id){

		Travel travel = travelService.findOne(Integer.parseInt(id));

		return new TravelDTO( travel.getDay_start(), travel.getType_traffic(), travel.getDays_trip(), travel.getDays_trip());
	}


	
	
	
}
