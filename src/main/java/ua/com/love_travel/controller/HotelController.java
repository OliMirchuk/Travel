package ua.com.love_travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





import org.springframework.web.bind.annotation.ResponseBody;


import ua.com.love_travel.dto.DtoUtilMapper;
import ua.com.love_travel.dto.HotelDTO;
import ua.com.love_travel.entity.Hotel;
import ua.com.love_travel.service.CityService;
import ua.com.love_travel.service.HotelService;

@Controller
public class HotelController {

	@Autowired
	private HotelService hotelService;
	@Autowired
	private CityService cityService;
	
	
	
	
	@RequestMapping(value = "/newHotel",method = RequestMethod.GET)
	public String newHotel(Model model){
				
		model.addAttribute("citiesDTOs", DtoUtilMapper.cityToCityDTO(cityService.findAll()));
		return "views-admin-newHotel";
	}
	
	
	
	@RequestMapping(value = "/saveHotel", method = RequestMethod.POST)
	public @ResponseBody boolean saveHotel(@RequestBody Hotel hotel ){
		
		hotelService.save(hotel);
		return true;
	}
	 @RequestMapping(value = "/loadHotel", method = RequestMethod.POST)
	    public @ResponseBody List<HotelDTO> saveHotel() {


	       return DtoUtilMapper.hotelToHotelDTO(hotelService.findAll());

	    }

	
	@RequestMapping(value = "/deleteHotel/{id}", method = RequestMethod.GET)
	public String newHotel(@PathVariable String id) {
		
		hotelService.delete(Integer.parseInt(id));
		
		return "redirect:/newHotel";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
