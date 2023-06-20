package survey.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REJECTS")
public class Rejet {

	@EmbeddedId
	private RejetID rejetId;
	
 	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENQ_ID", referencedColumnName = "ENQ_ID",insertable = false, updatable = false)
	private Enquete enquete;
	
	
	@Column(name = "CURRENT_QUESTION")
	private int currentQuestion;
	
	@Column(name = "LANGUAGE")
	private String language;
	
	@Column(name = "PARAM1")
	private String param1;
	
	@Column(name = "PARAM2")
	private String param2;
	
	@Column(name = "PARAM3")
	private String param3;
	
	@Column(name = "MSISDN_INTERACTION")
	private String msisdnInteraction;
	
	@Column(name = "QUESTION_ID")
	private int questionId;

	@Column(name = "ATTEMPT")
	private int attempt;
	
	@Column(name = "CREATION_DATE")
	private Date creationDate;
	
	@Column(name = "FILE_NAME")
	private String fileName;
	
	@Column(name = "PARAM4")
	private String param4;
	
	@Column(name = "PARAM5")
	private String param5;
	
	@Column(name ="ORIGINAL_ENQ_ID")
	private int originalEnqId;
	
	@Column(name = "PARAM6")
	private String param6;
	
	@Column(name = "PARAM7")
	private String param7;
	
	@Column(name = "PARAM8")
	private String param8;
	
	@Column(name = "PARAM9")
	private String param9;
	
	@Column(name = "PARAM10")
	private String param10;
	
	@Column(name = "MOTIFS")
	private String motifInsatisfaction;
	
	public int getAttempt() {
		return attempt;
	}

	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public Enquete getEnquete() {
		return enquete;
	}

	public void setEnquete(Enquete enquete) {
		this.enquete = enquete;
	}

	public int getCurrentQuestion() {
		return currentQuestion;
	}

	public void setCurrentQuestion(int currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}

	public String getMsisdnInteraction() {
		return msisdnInteraction;
	}

	public void setMsisdnInteraction(String msisdnInteraction) {
		this.msisdnInteraction = msisdnInteraction;
	}

	
	public Rejet(RejetID rejetId, int currentQuestion) {
		this.rejetId = rejetId;
		this.currentQuestion = currentQuestion;
	}

	public Rejet() {
		
	}

	public Rejet(RejetID rejetId, int currentQuestion, String language, String param1, String param2,
			String param3, String msisdnInteraction, int questionId, String fileName, Date creationDate, String param4, String param5, int originalEnqId,
			String param6, String param7, String param8, String param9, String param10, String motifInsatisfaction) {
		this.rejetId = rejetId;
		this.currentQuestion = currentQuestion;
		this.language = language;
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = param3;
		this.msisdnInteraction = msisdnInteraction;
		this.questionId = questionId;
		this.fileName = fileName;
		this.creationDate = creationDate;
		this.param4 = param4;
		this.param5 = param5;
		this.originalEnqId = originalEnqId;
		this.param6 = param6;
		this.param7 = param7;
		this.param8 = param8;
		this.param9 = param9;
		this.param10 = param10;
		this.motifInsatisfaction = motifInsatisfaction;
	}

	public RejetID getRejetId() {
		return rejetId;
	}

	public void setRejetId(RejetID rejetId) {
		this.rejetId = rejetId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getParam4() {
		return param4;
	}

	public void setParam4(String param4) {
		this.param4 = param4;
	}

	public String getParam5() {
		return param5;
	}

	public void setParam5(String param5) {
		this.param5 = param5;
	}

	public int getOriginalEnqId() {
		return originalEnqId;
	}

	public void setOriginalEnqId(int originalEnqId) {
		this.originalEnqId = originalEnqId;
	}

	public String getParam6() {
		return param6;
	}

	public void setParam6(String param6) {
		this.param6 = param6;
	}

	public String getParam7() {
		return param7;
	}

	public void setParam7(String param7) {
		this.param7 = param7;
	}

	public String getParam8() {
		return param8;
	}

	public void setParam8(String param8) {
		this.param8 = param8;
	}

	public String getParam9() {
		return param9;
	}

	public void setParam9(String param9) {
		this.param9 = param9;
	}

	public String getParam10() {
		return param10;
	}

	public void setParam10(String param10) {
		this.param10 = param10;
	}

	public String getMotifInsatisfaction() {
		return motifInsatisfaction;
	}

	public void setMotifInsatisfaction(String motifInsatisfaction) {
		this.motifInsatisfaction = motifInsatisfaction;
	}
	
	
	
}
