package ua.com.love_travel.controller;

import java.security.Principal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import ua.com.love_travel.dto.DtoUtilMapper;
import ua.com.love_travel.entity.User;
import ua.com.love_travel.service.MailSenderService;
import ua.com.love_travel.service.UserService;
import ua.com.love_travel.validator.UserValidationMassages;

@Controller
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MailSenderService mailSenderService;
	
	
	
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("userDTOs",DtoUtilMapper.usersToUsersDTO(userService.findAll()));
		
		return "views-user-newUser";
	}
	
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String newUser(@PathVariable int id) {
		
		userService.delete(id);
		
		return "redirect:/newUser";
		
	}
	
	@RequestMapping(value = "/saveImage", method =RequestMethod.POST)
	public String saveImage(Principal principal, @RequestParam MultipartFile image){
		userService.saveImage(principal, image);
		
		return "redirect:/profile";
	}  
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user, Model model) {

		String uuid = UUID.randomUUID().toString();
		
		user.setUUID(uuid);
		
		try {
			userService.save(user);
		} catch (Exception e) {
			if(e.getMessage().equals(UserValidationMassages.EMPTY_USERNAME_FIELD)||
					e.getMessage().equals(UserValidationMassages.NAME_ALREADY_EXIST)){
				model.addAttribute("usernameException", e.getMessage());
			}else if(e.getMessage().equals(UserValidationMassages.EMPTY_PASSWORD_FIELD)){
				model.addAttribute("passwordException", e.getMessage());
			}else if(e.getMessage().equals(UserValidationMassages.EMPTY_EMAIl_FIELD )||
					e.getMessage().equals(UserValidationMassages.EMAIL_ALREADY_EXIST)){
				model.addAttribute("emailException", e.getMessage());
			}else if(e.getMessage().equals(UserValidationMassages.EMPTY_PHONE_FIELD) ||
					e.getMessage().equals(UserValidationMassages.PHONE_ALREADY_EXIST)){
				model.addAttribute("phoneException", e.getMessage());
			}
			return "views-user-newUser";
		}
		String theme = "thank's for registration";
		String massage = "gl & hf http://localhost:8080/My_Travel/confirm/"+uuid;
		
		mailSenderService.sendMail(theme, massage, user.getEmail());
		
		return "views-base-home";
	}
	
	@RequestMapping(value = "/confirm/{uuid}", method = RequestMethod.GET)
	public String confirm(@PathVariable String uuid){
		
		
		User user = userService.findByUUID(uuid);
		user.setEnabled(true);
		
		userService.update(user);
		
		return"redirect:/";
	}

	 @RequestMapping(value = "/updateProfile", method = RequestMethod.GET)
	    public String updateProfile(Principal principal, Model model){
	        User user = userService.findOne(Integer.parseInt(principal.getName()));
	        model.addAttribute("user", user);
	        return "views-user-updateProfile";
	    }

	    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	    public String updateProfile(Principal principal, @RequestParam String name,
	                                @RequestParam String email,
	                                @RequestParam String phone,
	                                @RequestParam String password){
	        User user = userService.findOne(Integer.parseInt(principal.getName()));

	        user.setName(name);
	        user.setEmail(email);
	        user.setPhone(phone);
	        user.setPassword(password);

	        userService.updateProfile(user);

	        return "redirect:/profile";
	    }

	    @RequestMapping(value = "/saveUsers", method = RequestMethod.POST)
	    public void updateProfile(@RequestBody  User user) throws Exception {
	        System.out.println(user);
	        userService.save(user);
	    }
}
