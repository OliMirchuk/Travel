package ua.com.love_travel.service;

public interface MailSenderService {
	
	void sendMail(String content, String mailBody, String email);

}
