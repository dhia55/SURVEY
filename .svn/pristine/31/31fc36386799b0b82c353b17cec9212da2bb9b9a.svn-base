package survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import survey.dto.responseDto;
import survey.entity.ResponseDigital;
import survey.service.ResponseDigitalService;

@RestController
public class ResponseDigitalController {
	
	@Autowired
	ResponseDigitalService responseService;
	
	@GetMapping("/getallresponses")
	public List<ResponseDigital> getAll()
	{
		return responseService.getAll();
	}

	@PostMapping("/addresponse/{id}/{email}")
	public ResponseDigital addresponse(@RequestBody ResponseDigital r, @PathVariable("email") String email,  @PathVariable("id") int id )
	{	
		return responseService.addResponseDigital(r,id,email);
	}
	
	
	@PostMapping("/addResponses/{id}/{email}/{language}")
	public List<ResponseDigital> addResponses(@RequestBody List<responseDto> r, @PathVariable("email") String email,  @PathVariable("id") int id, @PathVariable("language") String language )
	{	
		return responseService.addResponses(r,id,email,language);
	}
	
	@PostMapping("/addResponsesSponSurvey/{id}/{language}")
	public List<ResponseDigital> addResponsesSponSurvey(@RequestBody List<responseDto> r,  @PathVariable("id") int id, @PathVariable("language") String language )
	{	
		return responseService.addResponsesSponSurvey(r,id,language);
	}
	
	
	@GetMapping("/responseNumber/{id}")
	public int responseNumber(@PathVariable("id") int id)
	{
		return responseService.responseNumber(id);
	}
	
	@GetMapping("/answered/{id}/{email}/{language}")
	public Boolean answered(@PathVariable("email") String email,  @PathVariable("id") int id, @PathVariable("language") String language )
	{
		return responseService.answered(id,email,language);
	}
	
	@GetMapping("/avgResponse/{id}")
	public int avgResponse(@PathVariable("id") int id)
	{
		return responseService.avgResponse(id);
	}

}
