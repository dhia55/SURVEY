package survey.service;

import java.util.List;

import survey.entity.CategorieDigital;

public interface ICategorieDigitalService {
	
	public CategorieDigital addCategorieDigitall(CategorieDigital u);
	public CategorieDigital update(CategorieDigital u);
	public List<CategorieDigital> getAll();
	public CategorieDigital get(int id);
	public Boolean delete(int id);

}
