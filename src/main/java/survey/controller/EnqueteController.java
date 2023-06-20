package survey.controller;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import survey.dto.questionDto;
import survey.entity.Enquete;
import survey.service.EnqueteService;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
@RestController
public class EnqueteController {
	
	private static final Logger logger = LogManager.getLogger(EnqueteController.class);
	
	@Autowired
	EnqueteService enqueteService;
	

	
	@GetMapping("/getallenquetes")
	public List<Enquete> getAll()
	{
		return enqueteService.getAll();
	}
	
	@GetMapping("/getAllbyenddate")
	public List<Enquete> getAllbyenddate()
	{
		return enqueteService.getAllbyenddate();
	}
	
	
	@GetMapping("/getAllbydate")
	public List<Enquete> getAllbydate()
	{
		return enqueteService.getAllbydate();
	}
	
	@GetMapping("/getenquetesByUser")
	public List<Enquete> getenquetesByUser()
	{
		return enqueteService.getenquetesByUser();
	}
	
	@GetMapping("/getAllbydateUser")
	public List<Enquete> getAllbydateUser()
	{
		return enqueteService.getAllbydateUser();
	}

	@PostMapping("/addenquete/{id}")
	public Enquete addenquete(@RequestBody Enquete e,@PathVariable("id") int id)
	{	
		enqueteService.addEnquete(e,id);
	 return e;
	
	}
	
	@DeleteMapping("/deleteenquete/{id}")
	public boolean delete(@PathVariable("id") int id)
	{
		return enqueteService.delete(id);
	}
	
	@PostMapping("/updateenquete")
	public Enquete updateenquete(@RequestBody Enquete u)
	{
	 return enqueteService.update(u);

	}
	
	@PostMapping("/endenquete/{id}")
	public Enquete endenquete(@PathVariable("id") int id)
	{
	 return enqueteService.arrete(id);

	}

	@GetMapping("/getenquetes")
	public Enquete getByStatus(@RequestBody String status)
	{
		return enqueteService.findByStatus(status);
	}
	
	@GetMapping("/getenquetebyid/{id}")
	public Enquete getenquetebyid(@PathVariable("id") int id)
	{
		return enqueteService.get(id);
	}
	
	
	  @GetMapping(value = "/sendSMS")
      public ResponseEntity<String> sendSMS() {

			Twilio.init("ACe33fc9c798582b4670c2f842a7109653","563923a876b8c6891465c65bdaef2b82");
	        Message message = Message.creator(
	                new com.twilio.type.PhoneNumber("whatsapp:+21694578034"),
	                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
	                "heyy")
	            .create();

              return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
      }  
	  
		@GetMapping("/getlangtype/{id}/{language}")
		public List<questionDto> getlangtype(@PathVariable("id") int id, @PathVariable("language") String language)
		{
			return enqueteService.getlangtype(id, language);
		}

		
		//resurvey
		@GetMapping("/getallenquetesresurvey")
		public List<Enquete> getAllresurvey()
		{
			return enqueteService.getAllresurvey();
		}
		
		@GetMapping("/getAllNNresurvey")
		public List<Enquete> getAllNNresurvey()
		{
			return enqueteService.getAllNNresurvey();
		}
		
		@GetMapping("/getAllbyenddateresurvey")
		public List<Enquete> getAllbyenddateresurvey()
		{
			return enqueteService.getAllbyenddateresurvey();
		}

		@GetMapping("/getenquetebyDateresurvey/{d1}/{d2}")
		public List<Enquete> getenquetebyDate(@PathVariable String d1,@PathVariable String d2) throws ParseException {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);

			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(d1);
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(d2);

			return enqueteService.getAllDDresurvey(date,date1);
		}
		
		
		
		
		
}
