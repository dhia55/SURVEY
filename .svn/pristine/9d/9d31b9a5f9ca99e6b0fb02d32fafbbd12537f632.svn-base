package survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import survey.entity.RoleDigital;
import survey.service.RoleDigitalService;

@RestController
public class RoleDigitalController {
	
	@Autowired
	RoleDigitalService RoleDigitalService;
	
	@PostMapping("/addrole")
	public RoleDigital addrole(@RequestBody RoleDigital e)
	{	
		return RoleDigitalService.addRoleDigital(e);
	}
	
	@GetMapping("/getallroles")
	public List<RoleDigital> getAll()
	{
		return RoleDigitalService.getAll();
	}
	
	@GetMapping("/getroleyid/{id}")
	public RoleDigital getroleyid(@PathVariable("id") int id)
	{
		return RoleDigitalService.get(id);
	}

}
