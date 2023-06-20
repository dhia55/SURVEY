package survey.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import survey.entity.User;
import survey.entity.UserDigital;





@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	private static final Logger logger = LogManager.getLogger(JwtUserDetailsService.class);
	
	@Autowired
	UserService UserService;

	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
		UserDigital u = UserService.findUserByMail(mail);
   
	if(u!=null)
	{
		logger.info("User found by email in the database:{} ", mail);
		//logger.info("User found by role in the database:{} ", u.getRole());
	}
	else
{
logger.error("User not found by email in the database");
throw new UsernameNotFoundException("User not found in the dtabase");

}

	
UserDetailsPrincipal userDetailsPrincipal =  new UserDetailsPrincipal(u);
return userDetailsPrincipal;
	}

}