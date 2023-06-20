package survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import survey.dto.paramDto;
import survey.entity.Parametre;
import survey.service.ParametreService;

@RestController
public class ParametreController {
	
	@Autowired
	ParametreService paramService;
	
	
	
	@GetMapping("/getallparams")
	public List<Parametre> getAll()
	{
		return paramService.getAll();
	}

	@PostMapping("/addparam")
	public Parametre addparam(@RequestBody Parametre p)
	{	
		return paramService.addParam(p);
	
	
	}
	
	@PostMapping("/saveall/{id}")
	public List<Parametre> saveall(@RequestBody List<paramDto> liste, @PathVariable("id") int id)
	{	
		return paramService.saveall(liste, id);
	
	
	}
	
	
	@DeleteMapping("/deleteparam/{id}")
	public boolean delete(@PathVariable("id") int id)
	{
		return paramService.delete(id);
	}
	
	@PostMapping("/updateparam")
	public Parametre updateparam(@RequestBody Parametre u)
	{
	 return paramService.update(u);

	}
	
	@GetMapping("/getparambyid/{id}")
	public Parametre getparambyid(@PathVariable("id") int id)
	{
		return paramService.get(id);
	}

}
