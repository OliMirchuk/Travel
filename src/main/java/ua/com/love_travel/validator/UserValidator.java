package ua.com.love_travel.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ua.com.love_travel.dao.UserDao;
import ua.com.love_travel.entity.User;

@Component("userValidator")
public class UserValidator implements Validator {

	
	@Autowired
	private UserDao userDao;

	public void validate(Object object) throws Exception{
		
		User user = (User) object;
		if(user.getName().isEmpty()){
			throw new UserValidationException(UserValidationMassages.EMPTY_USERNAME_FIELD);
		}
		if(userDao.findByName(user.getName()) != null){
			throw new UserValidationException(UserValidationMassages.NAME_ALREADY_EXIST);
		}
		if(userDao.userExistsByEmail(user.getEmail())){
			throw new UserValidationException(UserValidationMassages.EMAIL_ALREADY_EXIST);
		}
		if(user.getEmail().isEmpty()){
			throw new UserValidationException(UserValidationMassages.EMPTY_EMAIl_FIELD);
		}
		if(user.getPassword().isEmpty()){
			throw new UserValidationException(UserValidationMassages.EMPTY_PASSWORD_FIELD);
		}
		if(user.getPhone().isEmpty()){
			throw new UserValidationException(UserValidationMassages.EMPTY_PHONE_FIELD);
		}
		if(userDao.findByPhone(user.getPhone()) != null){
			throw new UserValidationException(UserValidationMassages.PHONE_ALREADY_EXIST);
		}
	}
	
	
}
