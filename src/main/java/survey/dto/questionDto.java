package survey.dto;

import java.util.List;
import java.util.Map;

import org.apache.commons.math3.util.Pair;

import survey.entity.Question;

public class questionDto {
	
	private Question question;
	private String answerScale;
	private Map<Integer, String> answerCode;
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public String getAnswerScale() {
		return answerScale;
	}
	public void setAnswerScale(String answerScale) {
		this.answerScale = answerScale;
	}

	public Map<Integer,String> getAnswerCode() {
		return answerCode;
	}
	public void setAnswerCode(Map<Integer,String> answerCode) {
		this.answerCode = answerCode;
	}
	public questionDto() {
		super();
	}
	public questionDto(Question question, String answerScale, Map<Integer,String> answerCode) {
		super();
		this.question = question;
		this.answerScale = answerScale;
		this.answerCode = answerCode;
	}	


}
