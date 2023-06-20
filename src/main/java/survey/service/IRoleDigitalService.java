package survey.service;

import java.util.List;

import survey.entity.users.RoleDigital;

public interface IRoleDigitalService {
	
	public RoleDigital addRoleDigital(RoleDigital u);
	public RoleDigital update(RoleDigital u);
	public List<RoleDigital> getAll();
	public RoleDigital get(int id);
	public Boolean delete(int id);
	

}
