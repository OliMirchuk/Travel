package ua.com.love_travel.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.love_travel.entity.User;
import ua.com.love_travel.service.TravelService;
import ua.com.love_travel.service.UserService;
@Controller
public class CookieController {
	
	@Autowired
	public UserService userService;
	@Autowired
	public TravelService travelService;
	
	@RequestMapping(value = "/buyTravel/{id}", method = RequestMethod.GET)
	public String buyTravel(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {

		
		userService.intoBasket(Integer.parseInt(id), request, response);

		return "redirect:/";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(HttpServletRequest request, Principal principal, Model model) {
	
	User user = userService.findOne(Integer.parseInt(principal.getName()));
	
	model.addAttribute("user", user);
	model.addAttribute("travels", userService.userTravelsCookie(request));
	
	return "views-user-profile";
	
	}
	
	
	@RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET)
	public String getOrder(Principal principal, @PathVariable String id, HttpServletRequest request,
			HttpServletResponse response) {

		userService.getOrder(principal, id, request, response);

		return "redirect:/profile";
	}


	@RequestMapping(value = "/deleteFromOrder/{id}", method = RequestMethod.GET)
    public String deleteCookie(@PathVariable String id, HttpServletRequest request,
                               HttpServletResponse response) {

        userService.deleteCookieFromOrder(id, request, response);

        return "redirect:/profile";
    }


}
