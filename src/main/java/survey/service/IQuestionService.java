package survey.service;

import java.util.List;

import survey.entity.Question;
public interface IQuestionService {
	
	public Question addQuestion(Question e, int id);
	public List<Question> getAll();
	public Question get(int id);
	public Boolean delete(int id);
	public Question update(Question e);
	public List<Question> getquestionsByScriptenq(int id);
	public List<Question> getquestionsByEnquete(int id);
	public List<Question> getquestionsByScript(int id);
	public List<Question> getquestionsByScriptenqLang(int id, String lang);
	public List<String> questionParams(int id);

}
