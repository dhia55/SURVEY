package survey.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ECHELLES")
public class Echelle {
	
	@Id
	@Column(name = "ECHELLE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ECHELLE")
	private Integer echelle;
	   
	@Column(name = "ANSWER_SCALE")
	private String answerScale;
	
	@Column(name = "ANSWER_CODE")
	private int answerCode;
	
	@Column(name = "CUSTOMER_ANSWER_ENG")
	private String customerAnswerEng;
	
	@Column(name = "CUSTOMER_ANSWER_FR")
	private String customerAnswerFr;
	
	@Column(name = "CUSTOMER_ANSWER_AR")
	private String customerAnswerAr;
	
	@Column(name = "ANSWER_SCORE")
	private int answerScore;
	
	@Column(name = "ANSWER_VALIDATION")
	private String answerValidation;
	
	public String getAnswerValidation() {
		return answerValidation;
	}

	public void setAnswerValidation(String answerValidation) {
		this.answerValidation = answerValidation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
   
	public String getAnswerScale() {
		return answerScale;
	}

	public void setAnswerScale(String answerScale) {
		this.answerScale = answerScale;
	}

	public int getAnswerCode() {
		return answerCode;
	}

	public void setAnswerCode(int answerCode) {
		this.answerCode = answerCode;
	}

	public String getCustomerAnswerEng() {
		return customerAnswerEng;
	}

	public void setCustomerAnswerEng(String customerAnswerEng) {
		this.customerAnswerEng = customerAnswerEng;
	}

	public String getCustomerAnswerFr() {
		return customerAnswerFr;
	}

	public void setCustomerAnswerFr(String customerAnswerFr) {
		this.customerAnswerFr = customerAnswerFr;
	}

	public String getCustomerAnswerAr() {
		return customerAnswerAr;
	}

	public void setCustomerAnswerAr(String customerAnswerAr) {
		this.customerAnswerAr = customerAnswerAr;
	}

	public int getAnswerScore() {
		return answerScore;
	}

	public void setAnswerScore(int answerScore) {
		this.answerScore = answerScore;
	}
		public Integer getEchelle() {
		return echelle;
	}

	public void setEchelle(Integer echelle) {
		this.echelle = echelle;
	}

}
