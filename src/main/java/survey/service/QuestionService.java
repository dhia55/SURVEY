package survey.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import survey.dao.EnqueteDao;
import survey.dao.QuestionDao;
import survey.dao.ScriptDao;
import survey.entity.Enquete;
import survey.entity.Question;
import survey.entity.Script;

@Service
public class QuestionService implements IQuestionService {
	
	private static final Logger logger = LogManager.getLogger(QuestionService.class);
	
	@Autowired
	QuestionDao QuestionDao;
	
	@Autowired
	ScriptDao ScriptDao;
	
	@Autowired
	EnqueteDao EnqueteDao;

	@Override
	public Question addQuestion(Question e, int id) {
		if(e!=null)
		{
		Script s = ScriptDao.findById(id).get();
        e.setScript(s);
		}
		return QuestionDao.save(e);
	}

	@Override
	public List<Question> getAll() {
		
		return QuestionDao.findAll();
	}

	@Override
	public Question get(int id) {
		
		return QuestionDao.findById(id).get();
	}

	@Override
	public Boolean delete(int id) {
		QuestionDao.deleteById(id);
		return true;
	}

	@Override
	public Question update(Question e) {
		
		return QuestionDao.save(e);
	}

	@Override
	public List<Question> getquestionsByEnquete(int id) {
		Enquete e = EnqueteDao.findById(id).get();
		Script s = e.getScript();
		int i = s.getScriptId();
		return  QuestionDao.findByscript(i);
	}

	@Override
	public List<Question> getquestionsByScript(int id) {
		Script s= ScriptDao.findById(id).get();
		int i=s.getScriptId();
		return QuestionDao.findByscript(i);
	}

	@Override
	public List<Question> getquestionsByScriptenq(int id) {
		Enquete e = EnqueteDao.findById(id).get();
		Script s = e.getScript();
		int i = s.getScriptId();
		return  QuestionDao.findByscript(i);
	}

	@Override
	public List<Question> getquestionsByScriptenqLang(int id, String lang) {
	

		List<Question> questions = new ArrayList<Question>();

		List<Question> getallquestions = getquestionsByScriptenq(id);
		
		for(int i=0; i<getallquestions.size();i++)
		{
			Question question = new Question();


			if(lang.equals("Arabe"))
			{

				question.setId(getallquestions.get(i).getId());
				question.setTextAr(getallquestions.get(i).getTextAr());
				question.setAnswerScale(getallquestions.get(i).getAnswerScale());
				question.setOrdre(getallquestions.get(i).getOrdre());
				question.setScript(getallquestions.get(i).getScript());
				questions.add(questions.size(), question);
			}
			
			else if(lang.equals("Français"))
			{

				question.setId(getallquestions.get(i).getId());
				question.setTextFr(getallquestions.get(i).getTextFr());
				question.setAnswerScale(getallquestions.get(i).getAnswerScale());
				question.setOrdre(getallquestions.get(i).getOrdre());
				question.setScript(getallquestions.get(i).getScript());
				questions.add(questions.size(), question);
			}
			else
			{

				question.setId(getallquestions.get(i).getId());
				question.setTextEng(getallquestions.get(i).getTextEng());
				question.setAnswerScale(getallquestions.get(i).getAnswerScale());
				question.setOrdre(getallquestions.get(i).getOrdre());
				question.setScript(getallquestions.get(i).getScript());
				questions.add(questions.size(), question);
			}
			
//			questions.add(question);
		}
		return questions;
	}

	@Override
	public List<String> questionParams(int id) {
		logger.info( QuestionDao.questionParams(id));
		return QuestionDao.questionParams(id);
	}

}
