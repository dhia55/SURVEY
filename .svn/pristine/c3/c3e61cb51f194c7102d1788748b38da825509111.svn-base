package survey.service;

import java.util.List;

import javax.mail.MessagingException;

import survey.entity.User;
import survey.entity.UserDigital;


public interface IUserService {
	
	public UserDigital addUser(UserDigital u);
	public List<UserDigital> getAll();
	public UserDigital get(long id);
	public Boolean delete(long id);
	public UserDigital update(UserDigital u);
	public UserDigital updatepassword(UserDigital u) throws MessagingException;
	public UserDigital findUserByFullname(String fullName);
	public UserDigital findUserByMail(String mail);


}
