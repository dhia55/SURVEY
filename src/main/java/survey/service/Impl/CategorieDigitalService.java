package survey.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import survey.entity.CategorieDigital;
import survey.dao.CategoryDigitalDao;
import survey.service.ICategorieDigitalService;

@Service
public class CategorieDigitalService implements ICategorieDigitalService {
	
	@Autowired
	CategoryDigitalDao CategoryDigitalDao;

	@Override
	public CategorieDigital addCategorieDigitall(CategorieDigital u) {

		return CategoryDigitalDao.save(u);
	}

	@Override
	public CategorieDigital update(CategorieDigital u) {

		return CategoryDigitalDao.save(u);
	}

	@Override
	public List<CategorieDigital> getAll() {

		return CategoryDigitalDao.findAll();
	}

	@Override
	public CategorieDigital get(int id) {

		return CategoryDigitalDao.findById(id).get();
	}

	@Override
	public Boolean delete(int id) {

		CategoryDigitalDao.deleteById(id);
		return true;
	}

}
