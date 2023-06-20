package survey.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.utility.RandomString;
import survey.dto.passwordDto;
import survey.entity.users.UserDigital;
import survey.service.Impl.UserService;

@RestController
public class UserController {

	private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/addUser")
	public UserDigital addUser(@RequestBody UserDigital u) {

		userService.addUser(u);
		return u;

	}

	@PostMapping("/updateUser")
	public UserDigital updateuser(@RequestBody UserDigital u) {
		return userService.update(u);

	}

	@GetMapping("/getUserbyid/{id}")
	public UserDigital getuser(@PathVariable("id") int id) {
		return userService.get(id);

	}

	@DeleteMapping("/deleteuser/{id}")
	public boolean deleteuser(@PathVariable("id") int id) {
		return userService.delete(id);
	}

	@GetMapping("/getallusers")
	public List<UserDigital> getAll() {
		return userService.getAll();
	}

	@PostMapping(
			"/forgotPassword/{email}")
	public String processForgotPassword(@PathVariable("email") String email) throws MessagingException {
		String token = RandomString.make(30);
		userService.updateResetPasswordToken(token, email);

		return "done";
	}

	@PostMapping("/reset_password/{token}")
	@ResponseBody
	public void showResetPasswordForm(@PathVariable("token") String token, @RequestBody passwordDto password) {
		UserDigital user = userService.getByResetPasswordToken(token);
		if (user != null) {

			userService.updatePassword(user, password);
			logger.info("You have successfully changed your password");
		} else {
			logger.info("Wrong token");

		}

	}

	@GetMapping("/userInfo")
	public UserDigital getuserInfo() {

		UserDigital u = userService.findUserByMail(SecurityContextHolder.getContext().getAuthentication().getName());
		// System.out.println("user :"+u.toString());
		return u;

	}

	@PostMapping("/newpassword")
	public UserDigital newpassword(@RequestBody UserDigital u) throws MessagingException {

		userService.updatepassword(u);
		return u;

	}

}
