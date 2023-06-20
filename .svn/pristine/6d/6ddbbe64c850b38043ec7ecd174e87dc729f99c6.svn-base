package survey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import survey.dao.RoleDao;
import survey.dao.RoleDigitalDao;
import survey.entity.Role;
import survey.entity.RoleDigital;

@Service
public class RoleDigitalService implements IRoleDigitalService {
	
	@Autowired
	RoleDigitalDao RoleDigitalDao;

	@Override
	public RoleDigital addRoleDigital(RoleDigital u) {
		// TODO Auto-generated method stub
		return RoleDigitalDao.save(u);
	}

	@Override
	public RoleDigital update(RoleDigital u) {

		return RoleDigitalDao.save(u);
	}

	@Override
	public List<RoleDigital> getAll() {

		return RoleDigitalDao.findAll();
	}

	@Override
	public RoleDigital get(int id) {

		return RoleDigitalDao.findById(id).get();
	}

	@Override
	public Boolean delete(int id) {

		RoleDigitalDao.deleteById(id);
		 return true;
	}


}
