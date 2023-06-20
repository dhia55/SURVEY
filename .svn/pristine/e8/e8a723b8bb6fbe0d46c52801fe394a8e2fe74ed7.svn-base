package survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import survey.entity.Script;
import survey.service.ScriptService;



@RestController
public class ScriptController {
	
	@Autowired
	ScriptService scriptService;
	
	
	
	@GetMapping("/getallscripts")
	public List<Script> getAll()
	{
		return scriptService.getAll();
	}

	@PostMapping("/addscript")
	public int addscript(@RequestBody Script s)
	{	
		return scriptService.addScript(s);
	
	
	}
	
	@DeleteMapping("/deletescript/{id}")
	public boolean delete(@PathVariable("id") int id)
	{
		return scriptService.delete(id);
	}
	
	@PostMapping("/updatescript")
	public Script updatescript(@RequestBody Script u)
	{
	 return scriptService.update(u);

	}
	
	@GetMapping("/getscriptbyid/{id}")
	public Script getscriptbyid(@PathVariable("id") int id)
	{
		return scriptService.get(id);
	}
	

}
