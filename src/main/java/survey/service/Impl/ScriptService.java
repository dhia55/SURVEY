package survey.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import survey.dao.ScriptDao;
import survey.entity.Question;
import survey.entity.Script;
import survey.service.IScriptService;

@Service
public class ScriptService implements IScriptService {
	
	@Autowired
	ScriptDao ScriptDao;
	
	@Autowired
    survey.service.Impl.QuestionService QuestionService;

	@Override
	public int addScript(Script s) {
	
		ScriptDao.save(s);
		return s.getScriptId();
	}

	@Override
	public List<Script> getAll() {
	
		List<Script> scripts = ScriptDao.findAll();
		for(int i =0; i<scripts.size();i++)
		{
			List<Question> list = QuestionService.getquestionsByScript(scripts.get(i).getScriptId());
			//scripts.get(i).setQuestionNumbers(list.size());
			ScriptDao.save(scripts.get(i));
		}
		
		
		return scripts;
	}

	@Override
	public Script get(int id) {

		return ScriptDao.findById(id).get();
	}

	@Override
	public Boolean delete(int id) {

		
		ScriptDao.deleteById(id);
		return true;
	}

	@Override
	public Script update(Script s) {


		return ScriptDao.save(s);
	}

}
