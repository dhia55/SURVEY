package survey.service;

import java.util.List;

import survey.entity.users.TypeDigital;

public interface ITypeDigitalService {
	

	public TypeDigital addType(TypeDigital u);
	public TypeDigital update(TypeDigital u);
	public List<TypeDigital> getAll();
	public TypeDigital get(int id);
	public Boolean delete(int id);

}
