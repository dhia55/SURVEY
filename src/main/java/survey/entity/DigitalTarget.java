package survey.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity

public class DigitalTarget {

  @EmbeddedId
  private DigitalTargetID digitalTargetID;


  private int currentQuestion;


  private String language;


  private String param1;


  private String param2;


  private String param3;


  private String msisdnInteraction;


  private int questionId;


  private int attempt;


  private Date creationDate;


  private int originalEnqId;

  private String param4;

  private String param5;

  private String param6;

  private String param7;

  private String param8;

  private String param9;

  private String param10;

  private String motifInsatisfaction;

  private String etat;

  private String AnswerStatus;

  private int sendMailResurvey;

  private String emailCustomer;


  public DigitalTarget() {
    super();
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


  public int getQuestionId() {
    return questionId;
  }


  public void setQuestionId(int questionId) {
    this.questionId = questionId;
  }


  public int getAttempt() {
    return attempt;
  }


  public void setAttempt(int attempt) {
    this.attempt = attempt;
  }


  public Date getCreationDate() {
    return creationDate;
  }


  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }


  public int getOriginalEnqId() {
    return originalEnqId;
  }


  public void setOriginalEnqId(int originalEnqId) {
    this.originalEnqId = originalEnqId;
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


  public String getEtat() {
    return etat;
  }


  public void setEtat(String etat) {
    this.etat = etat;
  }


  public int getSendMailResurvey() {
    return sendMailResurvey;
  }


  public void setSendMailResurvey(int sendMailResurvey) {
    this.sendMailResurvey = sendMailResurvey;
  }


  public String getEmailCustomer() {
    return emailCustomer;
  }


  public void setEmailCustomer(String emailCustomer) {
    this.emailCustomer = emailCustomer;
  }


  public String getAnswerStatus() {
    return AnswerStatus;
  }


  public void setAnswerStatus(String answerStatus) {
    AnswerStatus = answerStatus;
  }


  public DigitalTarget(DigitalTargetID digitalTargetID, int currentQuestion, String language, String param1,
                       String param2, String param3, String msisdnInteraction, int questionId, int attempt, Date creationDate,
                       int originalEnqId, String param4, String param5, String param6, String param7, String param8, String param9,
                       String param10, String motifInsatisfaction, String etat, int sendMailResurvey, String emailCustomer) {
    super();
    this.digitalTargetID = digitalTargetID;
    this.currentQuestion = currentQuestion;
    this.language = language;
    this.param1 = param1;
    this.param2 = param2;
    this.param3 = param3;
    this.msisdnInteraction = msisdnInteraction;
    this.questionId = questionId;
    this.attempt = attempt;
    this.creationDate = creationDate;
    this.originalEnqId = originalEnqId;
    this.param4 = param4;
    this.param5 = param5;
    this.param6 = param6;
    this.param7 = param7;
    this.param8 = param8;
    this.param9 = param9;
    this.param10 = param10;
    this.motifInsatisfaction = motifInsatisfaction;
    this.etat = etat;
    this.sendMailResurvey = sendMailResurvey;
    this.emailCustomer = emailCustomer;
  }


  public DigitalTarget(int currentQuestion, String language, String param1, String param2, String param3,
                       String msisdnInteraction, int questionId, int attempt, Date creationDate, int originalEnqId, String param4,
                       String param5, String param6, String param7, String param8, String param9, String param10,
                       String motifInsatisfaction, String etat, int sendMailResurvey, String emailCustomer) {
    super();
    this.currentQuestion = currentQuestion;
    this.language = language;
    this.param1 = param1;
    this.param2 = param2;
    this.param3 = param3;
    this.msisdnInteraction = msisdnInteraction;
    this.questionId = questionId;
    this.attempt = attempt;
    this.creationDate = creationDate;
    this.originalEnqId = originalEnqId;
    this.param4 = param4;
    this.param5 = param5;
    this.param6 = param6;
    this.param7 = param7;
    this.param8 = param8;
    this.param9 = param9;
    this.param10 = param10;
    this.motifInsatisfaction = motifInsatisfaction;
    this.etat = etat;
    this.sendMailResurvey = sendMailResurvey;
    this.emailCustomer = emailCustomer;
  }


  public DigitalTarget(DigitalTargetID digitalTargetID, int currentQuestion, String language, String param1,
                       String param2, String param3, String msisdnInteraction, int questionId, int attempt, Date creationDate,
                       int originalEnqId, String param4, String param5, String param6, String param7, String param8, String param9,
                       String param10, String motifInsatisfaction, String etat, String answerStatus, int sendMailResurvey,
                       String emailCustomer) {
    super();
    this.digitalTargetID = digitalTargetID;
    this.currentQuestion = currentQuestion;
    this.language = language;
    this.param1 = param1;
    this.param2 = param2;
    this.param3 = param3;
    this.msisdnInteraction = msisdnInteraction;
    this.questionId = questionId;
    this.attempt = attempt;
    this.creationDate = creationDate;
    this.originalEnqId = originalEnqId;
    this.param4 = param4;
    this.param5 = param5;
    this.param6 = param6;
    this.param7 = param7;
    this.param8 = param8;
    this.param9 = param9;
    this.param10 = param10;
    this.motifInsatisfaction = motifInsatisfaction;
    this.etat = etat;
    AnswerStatus = answerStatus;
    this.sendMailResurvey = sendMailResurvey;
    this.emailCustomer = emailCustomer;
  }


  public DigitalTarget(int currentQuestion, String language, String param1, String param2, String param3,
                       String msisdnInteraction, int questionId, int attempt, Date creationDate, int originalEnqId, String param4,
                       String param5, String param6, String param7, String param8, String param9, String param10,
                       String motifInsatisfaction, String etat, String answerStatus, int sendMailResurvey, String emailCustomer) {
    super();
    this.currentQuestion = currentQuestion;
    this.language = language;
    this.param1 = param1;
    this.param2 = param2;
    this.param3 = param3;
    this.msisdnInteraction = msisdnInteraction;
    this.questionId = questionId;
    this.attempt = attempt;
    this.creationDate = creationDate;
    this.originalEnqId = originalEnqId;
    this.param4 = param4;
    this.param5 = param5;
    this.param6 = param6;
    this.param7 = param7;
    this.param8 = param8;
    this.param9 = param9;
    this.param10 = param10;
    this.motifInsatisfaction = motifInsatisfaction;
    this.etat = etat;
    AnswerStatus = answerStatus;
    this.sendMailResurvey = sendMailResurvey;
    this.emailCustomer = emailCustomer;
  }


  public DigitalTargetID getDigitalTargetID() {
    return digitalTargetID;
  }


  public void setDigitalTargetID(DigitalTargetID digitalTargetID) {
    this.digitalTargetID = digitalTargetID;
  }


  @Override
  public String toString() {
    return "DigitalTarget [digitalTargetID=" + digitalTargetID + ", currentQuestion=" + currentQuestion
      + ", language=" + language + ", param1=" + param1 + ", param2=" + param2 + ", param3=" + param3
      + ", msisdnInteraction=" + msisdnInteraction + ", questionId=" + questionId + ", attempt=" + attempt
      + ", creationDate=" + creationDate + ", originalEnqId=" + originalEnqId + ", param4=" + param4
      + ", param5=" + param5 + ", param6=" + param6 + ", param7=" + param7 + ", param8=" + param8
      + ", param9=" + param9 + ", param10=" + param10 + ", motifInsatisfaction=" + motifInsatisfaction
      + ", etat=" + etat + ", sendMailResurvey=" + sendMailResurvey + ", emailCustomer=" + emailCustomer
      + "]";
  }


}
