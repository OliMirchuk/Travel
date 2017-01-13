package ua.com.love_travel.service;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import ua.com.love_travel.entity.Travel;
import ua.com.love_travel.entity.User;

public interface UserService {


	void save(User user) throws Exception;
	
	List<User> findAll();
	
	User findOne(int id);
	
	void delete(int id);
	
	void buyTravel(int idUser, int idTravel);

	User fetchUserWithTravel(int id);
	
	public void saveImage(Principal principal, MultipartFile multipartFile);
	
	User findByUUID(String uuid);
	
	void update(User user);

	void updateProfile(User user) /*throws Exception*/;
	
	public Cookie intoBasket(int id, HttpServletRequest request, HttpServletResponse response);
	
	List<Travel> userTravelsCookie(HttpServletRequest request);
	
	public void getOrder(Principal principal, String id, HttpServletRequest request, HttpServletResponse response);
    
    public void deleteCookieFromOrder(String id, HttpServletRequest request, HttpServletResponse response);

	
}
