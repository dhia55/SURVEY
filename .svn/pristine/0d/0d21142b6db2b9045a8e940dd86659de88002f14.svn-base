package survey.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import survey.security.JwtAuthenticationEntryPoint;
import survey.security.JwtRequestFilter;
import survey.service.JwtUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{		
		auth.authenticationProvider(daoAuthenticationProvider());
	}
	
	@Bean
	DaoAuthenticationProvider daoAuthenticationProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
	
	daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
	daoAuthenticationProvider.setUserDetailsService(userDetailsService());
	return daoAuthenticationProvider;
	}

	 @Bean
	    public UserDetailsService userDetailsService() {
	        return new JwtUserDetailsService();
	    }

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManagerBean();
	}
	@Bean
	public BCryptPasswordEncoder  getPasswordEncoder()
	{
		return new  BCryptPasswordEncoder();
	}


	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.cors().and().csrf().disable()
		.authorizeRequests().antMatchers("/signin").permitAll()
		.antMatchers("/addUser").permitAll()
		.anyRequest().authenticated().and().
		exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);


	}*/
	
	
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// We don't need CSRF for this example
		httpSecurity.cors().and().csrf().disable()
				// dont authenticate this particular request
				.authorizeRequests().antMatchers("/signin").permitAll()
				.antMatchers("/addUser").permitAll()
				.antMatchers("/decodedUrl/{token}").permitAll()
				.antMatchers("/getlangtype/{id}/{language}").permitAll()
				.antMatchers("/answered/{id}/{email}/{language}").permitAll()
				.antMatchers("/addResponses/{id}/{email}/{language}").permitAll()
				.antMatchers("/addResponsesSponSurvey/{id}/{language}").permitAll()
				.antMatchers("/generateLinkLang/{id}/{lang}").permitAll()
				.antMatchers("/decodedUrl/{decodedUrl}").permitAll()
				.antMatchers("/encodedUrl/{id}/{lang}").permitAll()
				// all other requests need to be authenticated
						.anyRequest().authenticated().and().
				// make sure we use stateless session; session won't be used to
				// store user's state.
						exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	
	
	
}