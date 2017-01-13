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
import ua.com.love_travel.dto.RoomDTO;
import ua.com.love_travel.entity.Room;
import ua.com.love_travel.service.HotelService;
import ua.com.love_travel.service.RoomService;

@Controller
public class RoomController {

	@Autowired
	private RoomService roomService;
	@Autowired
	private HotelService hotelService;
	
	
	
	@RequestMapping(value = "/newRoom", method = RequestMethod.GET)
	public String newRoom(Model model){
		
		model.addAttribute("hotelsDTOs", DtoUtilMapper.hotelToHotelDTO(hotelService.findAll()));
		return "views-admin-newRoom";
	}
	
	@RequestMapping(value = "/saveRoom", method = RequestMethod.POST)
	public @ResponseBody boolean saveRoom(@RequestBody Room room){		
		
		
		roomService.save(room);
		return true;
	}
	
	@RequestMapping(value = "/loadRoom", method = RequestMethod.POST)
    public @ResponseBody List<RoomDTO> saveRoom() {


       return DtoUtilMapper.roomToRoomDTO(roomService.findAll());

    }
	@RequestMapping(value = "/deleteRoom/{id}", method = RequestMethod.GET)
	public String newRoom(@PathVariable int id) {
		
		roomService.delete(id);
		
		return "redirect:/newRoom";
	}
}
