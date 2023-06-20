package survey.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrosConfiguration {
	
	@Bean
	public WebMvcConfigurer corsConfigurer()
	{
		return new WebMvcConfigurer()
				{
			@Override
			public void addCorsMappings(CorsRegistry registry)
			{
				registry.addMapping("/**")
              .allowedOriginPatterns("*")
              .allowCredentials(true)
              .maxAge(180)
              .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS");
			}
				};
	}

}
