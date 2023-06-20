package survey.service;

import java.util.List;

import survey.entity.Echelle;


public interface IEchelleService {
	
	public Echelle addEchelle(Echelle e);
	public List<Echelle> getAll();
	public Echelle get(int id);
	Boolean delete(int id);
	public Echelle update(Echelle e);
	public List<String> getallscales();
	public List<Echelle> getallscalesdis();

}
