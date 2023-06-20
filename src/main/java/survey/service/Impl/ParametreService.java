package survey.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import survey.dao.ParametreDao;
import survey.dto.paramDto;
import survey.entity.Enquete;
import survey.entity.Parametre;
import survey.entity.Script;
import survey.service.IParametreService;

@Service
public class ParametreService implements IParametreService {
	
	@Autowired
	ParametreDao ParametreDao;
	
	@Autowired
    DigitalTargetService.EnqueteService EnqueteService;
	
	@Autowired
	survey.service.Impl.ScriptService ScriptService;

	@Override
	public Parametre addParam(Parametre b) {

		return ParametreDao.save(b);
	}

	@Override
	public List<Parametre> saveall(List<paramDto> liste, int id) {
		
		List<Parametre> listparm= new ArrayList<Parametre>();
	
		  Enquete e = EnqueteService.get(id);
	  	  Script s = ScriptService.get(e.getScript().getScriptId());
		
		//liste= new ArrayList<parametre>();
		for(int i=0;i<liste.size();i++)
		{
			System.out.println("rrr : "+i+liste.get(i).toString());
			Parametre p = new Parametre();
			p.setParamCode("param"+(i+1));
			p.setParamMeaning("["+ liste.get(i).getParamMeaning().toUpperCase()+"]");
			p.setParamDescription(liste.get(i).getParamMeaning());
			p.setScript(s);
			ParametreDao.save(p);
			listparm.add(p);
		}
	
		return listparm;
	}

	@Override
	public List<Parametre> getAll() {

		return ParametreDao.findAll();
	}

	@Override
	public Parametre get(int id) {


		return ParametreDao.findById(id).get();
	}

	@Override
	public Boolean delete(int id) {
	
		ParametreDao.deleteById(id);
		return true;
	}

	@Override
	public Parametre update(Parametre e) {
		e.setParamMeaning("["+ e.getParamDescription().toUpperCase()+"]");
		return ParametreDao.save(e);
	}

}
