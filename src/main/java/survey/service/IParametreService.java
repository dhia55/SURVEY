package survey.service;

import java.util.List;

import survey.dto.paramDto;
import survey.entity.Parametre;

public interface IParametreService {
	
	public Parametre addParam(Parametre b);
	public List<Parametre> saveall(List<paramDto> liste, int id);
	public List<Parametre> getAll();
	public Parametre get(int id);
	Boolean delete(int id);
	public Parametre update(Parametre e);

}
