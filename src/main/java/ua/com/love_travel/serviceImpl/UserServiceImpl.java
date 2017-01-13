package ua.com.love_travel.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.com.love_travel.dao.TravelDao;
import ua.com.love_travel.dao.UserDao;
import ua.com.love_travel.entity.Role;
import ua.com.love_travel.entity.Travel;
import ua.com.love_travel.entity.User;
import ua.com.love_travel.service.UserService;
import ua.com.love_travel.validator.Validator;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService{
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private TravelDao travelDao;
	
	@Autowired
	@Qualifier("userValidator")
	private Validator validator;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void save(User user) throws Exception {
		validator.validate(user);
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);
	}

	@Override
	public void updateProfile(User user) /*throws Exception*/{
		/*validator.validate(user);*/
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);
		
	}
	public List<User> findAll() {
	 
		return  userDao.findAll();
	}

	public User findOne(int id) {
		return  userDao.findOne(id);
	}

	public void delete(int id) {
		userDao.delete(id);
	}
	

	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		return userDao.findByName(name);
	}

	public User findByName(String name) {
		return userDao.findByName(name);
	}
	
	
	@Transactional
	public void buyTravel(int idUser, int idTravel) {
		User user = userDao.findOne(idUser);
		
		Travel travel = travelDao.findOne(idTravel);
		
		user.getTravels().add(travel);
	}

	public User fetchUserWithTravel(int id) {
		return userDao.fetchUserWithTravel(id);
	}

	@Transactional
	public void saveImage(Principal principal, MultipartFile multipartFile) {

	    User user = userDao.findOne(Integer.parseInt(principal.getName()));

	    String path = System.getProperty("catalina.home") + "/resources/"
	            + user.getName() + "/" + multipartFile.getOriginalFilename();

	    user.setPathImage("resources/" + user.getName() + "/" + multipartFile.getOriginalFilename());

	    File file = new File(path);

	    try {
	        file.mkdirs();
	        try {
	        	 FileUtils.cleanDirectory
	                    (new File(System.getProperty("catalina.home") + "/resources/" + user.getName() + "/"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        multipartFile.transferTo(file);
	    } catch (IOException e) {
	        System.out.println("error with file");
	    }
	    userDao.save(user);
	}
	
	public User findByUUID(String uuid) {
		return userDao.findByUUID(uuid);
	}

	
	public void update(User user) {
		userDao.save(user);
		
	}

	public Cookie intoBasket(int id, HttpServletRequest request, HttpServletResponse response) {
		request.getSession(false);
		Travel travel = travelDao.findOne(id);
		
		Cookie cookieTravel = new Cookie(travel.getHotel().getHotelName(), String.valueOf(travel.getId()));
		
		cookieTravel.setMaxAge(24 * 60 * 60 * 60);
		cookieTravel.setHttpOnly(true);
		cookieTravel.setPath("/");
		
		response.addCookie(cookieTravel);
		return cookieTravel;
	}

	public List<Travel> userTravelsCookie(HttpServletRequest request) {
		request.getSession(false);
		
		List<Travel> travels = new ArrayList<>();
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("JSESSIONID")) {
				
			} else {
				travels.add(travelDao.findOne(Integer.parseInt(cookie.getValue())));
			}
		}
		return travels;
	}
	@Transactional
	@Override
	public void getOrder(Principal principal, String id, HttpServletRequest request, HttpServletResponse response) {
		User user = userDao.fetchUserWithTravel(Integer.parseInt(principal.getName()));
		Travel travel = travelDao.findOne(Integer.parseInt(id));
		user.getTravels().add(travel);
		
		Cookie[] cookies = request.getCookies();
		sortCookie(cookies, id, response);
		
	}
	@Override
	public void deleteCookieFromOrder(String id, HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
        sortCookie(cookies, id, response);
		
	}
	public void sortCookie(Cookie[] cookies, String id, HttpServletResponse response) {
        for (int i = 0; i < cookies.length; i++) {
            if (id.equals(cookies[i].getValue())) {
                Cookie cookie = new Cookie(cookies[i].getName(), null);
                cookie.setPath("/");
                cookie.setValue(null);
                cookie.setHttpOnly(true);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
	}

	
	
	 public User innitalUserTravelsCountries(Principal principal) {

	        User user = userDao.fetchUserWithTravel(Integer.parseInt(principal.getName()));

	        for (Travel travel : user.getTravels()) {

	            Hibernate.initialize(travel.getCountry().getCities());

	        }
	        return user;


	    }


	    public List<Travel> clickOnBuuton(HttpServletRequest request){

	        request.getSession(false);

	        Cookie [] cookie = request.getCookies();

	        List<Travel> travels = new ArrayList<>();


	        for (Cookie cookie1 : cookie) {

	            travels.add(travelDao.findOne(Integer.parseInt(cookie1.getValue())));


	        }

	        return travels;

	    }



	
}
