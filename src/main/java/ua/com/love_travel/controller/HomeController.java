package ua.com.love_travel.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import org.springframework.web.bind.annotation.ResponseBody;

import ua.com.love_travel.dto.DtoUtilMapper;
import ua.com.love_travel.dto.TravelDTO;
import ua.com.love_travel.editor.CityEditor;
import ua.com.love_travel.editor.CountryEditor;
import ua.com.love_travel.editor.HotelEditor;
import ua.com.love_travel.editor.RoomEditor;
import ua.com.love_travel.editor.TravelEditor;
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
public class HomeController {

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
		binder.registerCustomEditor(Travel.class, new TravelEditor(travelService));
	}
	
	
	@RequestMapping(value={"/","/home"}, method=RequestMethod.GET)
	public String home(Model model, Principal principal){
		model.addAttribute("travels", travelService.findAll());
		model.addAttribute("cities", cityService.findAll());
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("rooms",  roomService.findAll());
		model.addAttribute("hotels", hotelService.findAll());
		return "views-base-home";
	}
	
	
	

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String loginprocesing(){
        return "redirect:/home";
    }
	
    @RequestMapping("/loginpage")
    public String login(){
    	return "views-base-loginpage";
    }
    @RequestMapping("/aboutus")
    public String aboutus(){
    	return "views-base-aboutus";
    }
    @RequestMapping("/contact")
    public String contact(){
    	return "views-base-contact";
    }
    @RequestMapping(value = "/logout" , method = RequestMethod.POST)
    public String logout(){
    	
    	return "redirect:/";
    }
    @RequestMapping(value = "/back" , method = RequestMethod.POST)
    public String back(){
    	
    	return "redirect:/";
    }
    
    @Transactional
	@RequestMapping(value = "/getTravels", method = RequestMethod.POST)
	public @ResponseBody String  gettravels(@RequestBody String  checked, Principal principal){
		return "from controller";

	}

	@RequestMapping(value = "/sortTravels", method = RequestMethod.POST)
	public @ResponseBody List<TravelDTO> sortTravels(@RequestBody String value){

		List<Travel> travels = travelService.sortTravels(Integer.parseInt(value));


		return DtoUtilMapper.travelToTravelDTO(travels);
	}





    
	
	
}

