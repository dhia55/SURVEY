package survey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import survey.dao.EchelleDao;
import survey.entity.Echelle;

@Service
public class EchelleService implements IEchelleService {
	
	@Autowired
	EchelleDao EchelleDao;

	@Override
	public Echelle addEchelle(Echelle e) {
	
		return EchelleDao.save(e);
	}

	@Override
	public List<Echelle> getAll() {

		
		return EchelleDao.getall();
	}

	@Override
	public Echelle get(int id) {

		return EchelleDao.findById(id).get();
	}

	@Override
	public Boolean delete(int id) {

		EchelleDao.deleteById(id);
		 return true;
	}

	@Override
	public Echelle update(Echelle e) {
	
		return EchelleDao.save(e);
	}

	@Override
	public List<String> getallscales() {

		
		return EchelleDao.getallscales();
	}

	@Override
	public List<Echelle> getallscalesdis() {
		
		return EchelleDao.getallscalesdis();
	}

}
