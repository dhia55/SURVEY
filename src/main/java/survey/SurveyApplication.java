package survey;

import static spark.Spark.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;




@SpringBootApplication (exclude = {SecurityAutoConfiguration.class })
public class SurveyApplication extends SpringBootServletInitializer  {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SurveyApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(SurveyApplication.class, args);
	    /*  post("/receiveMsg", (req, res) -> {
	            res.type("application/xml");
	            Body body = new Body
	                    .Builder("kiki!!")
	                    .build();
	            Message sms = new Message
	                    .Builder()
	                    .body(body)
	                    .build();
	            MessagingResponse twiml = new MessagingResponse
	                    .Builder()
	                    .message(sms)
	                    .build();
	            return twiml.toXml();
	        });*/
		
		
	}
	
	/*@Bean
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
	}*/

}
