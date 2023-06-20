package survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import survey.entity.Question;
import survey.service.Impl.QuestionService;

@RestController
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/getallquestions")
	public List<Question> getAll()
	{
		return questionService.getAll();
	}
	
	
	@GetMapping("/getallquestionsByScript/{id}")
	public List<Question> getallquestionsByScript(@PathVariable("id") int id)
	{
		return questionService.getquestionsByScript(id);
	}
	

	
	@PostMapping("/addquestion/{id}")
	public Question addquestion(@PathVariable("id") int id,@RequestBody Question e)
	{	
		questionService.addQuestion(e,id);
	 return e;
	
	}
	
	@DeleteMapping("/deletequestion/{id}")
	public boolean delete(@PathVariable("id") int id)
	{
		return questionService.delete(id);
	}
	
	@PostMapping("/updatequestion")
	public Question updatequestion(@RequestBody Question u)
	{
	 return questionService.update(u);

	}
	
	@GetMapping("/getquestionbyid/{id}")
	public Question getquestionbyid(@PathVariable("id") int id)
	{
		return questionService.get(id);
	}

	@GetMapping("/getquestionsByScriptenq/{id}")
	public List<Question> getquestionsByScriptenq(@PathVariable("id") int id)
	{
		return questionService.getquestionsByScriptenq(id);
	}
	
	
	@GetMapping("/getquestionsByScriptenqLang/{id}/{lang}")
	public List<Question> getquestionsByScriptenqLang(@PathVariable("id") int id, @PathVariable("lang") String lang)
	{
		return questionService.getquestionsByScriptenqLang(id,lang);
	}
	
}
