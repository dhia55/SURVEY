package survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import survey.entity.users.TypeDigital;
import survey.service.Impl.TypeDigitalService;

@RestController
public class TypeDigitalController {
	
	
	@Autowired
    TypeDigitalService TypeDigitalService;

	
	@PostMapping("/addtype")
	public TypeDigital addtype(@RequestBody TypeDigital u)
	{	
		TypeDigitalService.addType(u);
	 return u;
	
	}
	
	@GetMapping("/getalltypes")
	public List<TypeDigital> getalltypes()
	{
		return TypeDigitalService.getAll();
	}
	
	@GetMapping("/gettypeid/{id}")
	public TypeDigital gettypeid(@PathVariable("id") int id)
	{
		return TypeDigitalService.get(id);
	}


}
