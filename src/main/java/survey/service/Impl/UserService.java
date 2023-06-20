package survey.service.Impl;

import java.util.List;

import javax.mail.MessagingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import survey.dao.UserDigitalDao;
import survey.dto.passwordDto;
import survey.entity.users.UserDigital;
import survey.service.IUserService;

@Service
public class UserService implements IUserService {
	
	private static final Logger logger = LogManager.getLogger(UserService.class);
	
	@Autowired
	UserDigitalDao UserDao;
	
	@Autowired
	private EmailSenderService emailSenderService;

	@Override
	public UserDigital addUser(UserDigital u) {
		u.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
	
		logger.info("Saving new user in the database:{} ", u.getMail());
			return UserDao.save(u);
			 
	}

	@Override
	public List<UserDigital> getAll() {
		logger.info("Get all users from database ");
		return UserDao.findAll();
	}

	@Override
	public UserDigital get(long id) {
		logger.info("Get user by id from database:{} ", id);
		return UserDao.findById(id).get();
	}

	@Override
	public Boolean delete(long id) {
		logger.info("Deleting user by id from database:{} ", id);
		UserDao.deleteById(id);
		return true;
	}

	@Override
	public UserDigital update(UserDigital u) {
		//u.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));

		logger.info("Updating user in the database:{} ", u.getUsername());
			return UserDao.save(u);
	}

	@Override
	public UserDigital findUserByFullname(String fullName) {

		return UserDao.findByfullname(fullName);
	}

	@Override
	public UserDigital findUserByMail(String mail) {

		return UserDao.findByMail(mail);
	}
	
	public  void updateResetPasswordToken(String token, String email) throws MessagingException   {
		UserDigital user = UserDao.findByMail(email);
        if(user != null)
        {
        	  user.setResetToken(token);
        	  UserDao.save(user);
              String resetPasswordLink = "http://localhost:4200/change-password/" + token;
          	emailSenderService.sendMailWithAttachment(email,
          			"Hello, \n"
          			+ "You have requested to reset password. \n"
          			+ "Click the link bellow to change your password:\n"
          			+ resetPasswordLink +"\n"
          			+"Ignore the email if you remember your password",
          			"Forget password",
          			"C:\\PFE\\notes.txt");
        }
        else
          logger.info("Could not found any user by email");
        
    }
     
   public  UserDigital getByResetPasswordToken(String token) {
        return UserDao.findByResetToken(token);
    }
     
    public  void updatePassword(UserDigital user, passwordDto newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        logger.info("user"+user.toString());
        logger.info("new password"+newPassword);
        String encodedPassword = passwordEncoder.encode(newPassword.getPassword());
        user.setPassword(encodedPassword);
         
        user.setResetToken(null);
        UserDao.save(user);
    }

	@Override
	public UserDigital updatepassword(UserDigital u) throws MessagingException {
		logger.info("newpassword"+u.getPassword());
		emailSenderService.sendMailWithAttachment(u.getMail(),
      			"Hello, \n"
      			+ "You have requested to get your password. \n"
      			+ "Password : " +  u.getPassword(),
      			"New password",
      			"D:\\PFE\\Ooredoo logo.png");
		u.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
		UserDao.save(u);
		return u;
	}

}
