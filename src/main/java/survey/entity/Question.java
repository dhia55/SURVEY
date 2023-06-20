package survey.entity;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTIONS")
public class Question {

	@Id
	@Column(name = "QUESTION_ID")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ORDRE")
	private int ordre;
	
	@Column(name = "TEXT_FR")
	private String textFr;
	
	@Column(name = "TEXT_AR")
	private String textAr;
	
	@Column(name = "TEXT_ENG")
	private String textEng;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCRIPT_ID", referencedColumnName = "SCRIPT_ID")
	private Script script;
	
	@Column(name = "QUESTION_SHORT_TEXT")
	private String questionShortTxt;
	
	@ManyToOne
	private CategorieDigital questionCategory;
	
	//@Column(name = "ANSWER_SCALE")
	@ManyToOne
	private Echelle answerScale;
	
	@Column(name = "ROTATION_WEIGHT")
	private int rotationWeight;

	@Column(name = "ACTUAL_WEIGHT")
	private int actualWeight;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
	private List<Reponse> reponses = new ArrayList<Reponse>();
  
	
	public List<Reponse> getReponses() {
		return reponses;
	}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public String getTextFr() {
		return textFr;
	}

	public void setTextFr(String textFr) {
		this.textFr = textFr;
	}

	public String getTextAr() {
		return textAr;
	}

	public void setTextAr(String textAr) {
		this.textAr = textAr;
	}

	public String getTextEng() {
		return textEng;
	}

	public void setTextEng(String textEng) {
		this.textEng = textEng;
	}

	public Script getScript() {
		return script;
	}

	public void setScript(Script script) {
		this.script = script;
	}

	public String getQuestionShortTxt() {
		return questionShortTxt;
	}

	public void setQuestionShortTxt(String questionShortTxt) {
		this.questionShortTxt = questionShortTxt;
	}



	public CategorieDigital getQuestionCategory() {
		return questionCategory;
	}

	public void setQuestionCategory(CategorieDigital questionCategory) {
		this.questionCategory = questionCategory;
	}
	
	

	/*public String getAnswerScale() {
		return answerScale;
	}

	public void setAnswerScale(String answerScale) {
		this.answerScale = answerScale;
	}*/

	public Echelle getAnswerScale() {
		return answerScale;
	}

	public void setAnswerScale(Echelle answerScale) {
		this.answerScale = answerScale;
	}

	public int getRotationWeight() {
		return rotationWeight;
	}

	public void setRotationWeight(int rotationWeight) {
		this.rotationWeight = rotationWeight;
	}
 
	public int getActualWeight() {
		return actualWeight;
	}

	public void setActualWeight(int actualWeight) {
		this.actualWeight = actualWeight;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", ordre=" + ordre + ", textFr=" + textFr + ", textAr=" + textAr + ", textEng="
				+ textEng + ", script=" + script + ", questionShortTxt=" + questionShortTxt + ", questionCategory="
				+ questionCategory + ", answerScale=" + answerScale + ", rotationWeight=" + rotationWeight
				+ ", actualWeight=" + actualWeight + ", reponses=" + reponses + "]";
	}

	public Question(int id, int ordre, String textFr, String textAr, String textEng, Script script,
			String questionShortTxt, CategorieDigital questionCategory, Echelle answerScale, int rotationWeight,
			int actualWeight, List<Reponse> reponses) {
		super();
		this.id = id;
		this.ordre = ordre;
		this.textFr = textFr;
		this.textAr = textAr;
		this.textEng = textEng;
		this.script = script;
		this.questionShortTxt = questionShortTxt;
		this.questionCategory = questionCategory;
		this.answerScale = answerScale;
		this.rotationWeight = rotationWeight;
		this.actualWeight = actualWeight;
		this.reponses = reponses;
	}

	public Question() {
		super();
	}
	
	

}
