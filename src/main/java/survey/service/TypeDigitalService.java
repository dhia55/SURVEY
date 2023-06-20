package survey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import survey.dao.TypeDigitalDao;
import survey.entity.TypeDigital;

@Service
public class TypeDigitalService implements ITypeDigitalService {
	
	@Autowired
	TypeDigitalDao TypeDigitalDao;

	@Override
	public TypeDigital addType(TypeDigital u) {

		return TypeDigitalDao.save(u);
	}

	@Override
	public TypeDigital update(TypeDigital u) {
		
		return TypeDigitalDao.save(u);
	}

	@Override
	public List<TypeDigital> getAll() {
		
		return TypeDigitalDao.findAll();
	}

	@Override
	public TypeDigital get(int id) {
		
		return TypeDigitalDao.findById(id).get();
	}

	@Override
	public Boolean delete(int id) {
		
		TypeDigitalDao.deleteById(id);
		return true;
	}

}
