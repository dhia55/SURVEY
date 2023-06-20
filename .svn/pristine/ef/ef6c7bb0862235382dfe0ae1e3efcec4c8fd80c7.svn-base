package survey.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import survey.entity.JwtRequest;
import survey.entity.UserDigital;
import survey.security.JwtTokenUtil;
import survey.service.UserService;

@RestController
public class JwtAuthentificationController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	JwtTokenUtil jwtUtil;

	@Autowired
	UserService userService;

	/*
	 * @GetMapping("/signin/{email}/{password}") public String
	 * authenticateUser(@PathVariable("email")String
	 * email,@PathVariable("password")String password) throws MessagingException,
	 * IOException, ServletException { User user=userService.findUserByMail(email);
	 * 
	 * 
	 * 
	 * if (user != null ||
	 * bCryptPasswordEncoder.matches(password,user.getPassword()) ) {
	 * 
	 * 
	 * Authentication authentication = authenticationManager.authenticate(new
	 * UsernamePasswordAuthenticationToken(email, password));
	 * SecurityContextHolder.getContext().setAuthentication(authentication);
	 * 
	 * return jwtUtil.generateJwtToken(authentication);
	 * 
	 * }
	 * 
	 * 
	 * return ""; }
	 */

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody JwtRequest jwtRequest)
			throws MessagingException, IOException, ServletException {
		UserDigital user = userService.findUserByMail(jwtRequest.getMail());

		
		if (user != null || bCryptPasswordEncoder.matches(jwtRequest.getPassword(), user.getPassword())) {
			
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getMail(), jwtRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);

			//return jwtUtil.generateJwtToken(authentication);
			return ResponseEntity.status(HttpStatus.OK).body(jwtUtil.generateJwtToken(authentication));

		}

		//return "";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
	}

}
