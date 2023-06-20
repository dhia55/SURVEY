package survey.service;

import java.util.List;

import survey.entity.Script;
public interface IScriptService {
	
	public int addScript(Script s);
	public List<Script> getAll();
	public Script get(int id);
	public Boolean delete(int id);
	public Script update(Script s);

}
