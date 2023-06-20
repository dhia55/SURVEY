package survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



import survey.service.Impl.TargetService;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;

@RestController
public class TarguetController {
	
	@Autowired
	TargetService TargetService;
	
	
	
	   @PostMapping("/sendbywhatss/{id}")
		  // @ResponseBody
		   public String sendbywhatss(@PathVariable("id")  int id) {
		TargetService.sendbywhatss(id);


		     return "done";
		   }

	   @PostMapping("/receiveMsg")
	   public String replay()
	   {
		 Body body = new Body
                 .Builder("heyyy!!")
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
	   }
}
