package survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import survey.entity.Echelle;
import survey.service.EchelleService;

@RestController
public class EchelleController {
	
	@Autowired
	EchelleService echelleService;
	
	@GetMapping("/getallechelles")
	public List<Echelle> getAll()
	{
		return echelleService.getAll();
	}
	
	@GetMapping("/getallsclaes")
	public List<String> getAllscales()
	{
		return echelleService.getallscales();
	}
	
	@GetMapping("/getallscalesdis")
	public List<Echelle> getallscalesdis()
	{
		return echelleService.getallscalesdis();
	}


	@PostMapping("/addechelle")
	public Echelle addechelle(@RequestBody Echelle e)
	{	
		echelleService.addEchelle(e);
	 return e;
	
	}
	
	@DeleteMapping("/deleteechelle/{id}")
	public boolean delete(@PathVariable("id") int id)
	{
		return echelleService.delete(id);
	}
	
	@PostMapping("/updateechelle")
	public Echelle updateechelle(@RequestBody Echelle u)
	{
	 return echelleService.update(u);

	}
	
	@GetMapping("/getechellebyid/{id}")
	public Echelle getechellebyid(@PathVariable("id") int id)
	{
		return echelleService.get(id);
	}


}
