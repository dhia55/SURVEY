package survey.entity;


import java.util.Date;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESPONSES")
public class Reponse {

  @EmbeddedId
  private ResponseID responseId;

  @Column(name = "RESPONSE")
  private String response;

  @Column(name = "DATE_RESPONSE")
  private Date dateResponse;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "QUESTION_ID", referencedColumnName = "QUESTION_ID")
  private Question question;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ENQ_ID", referencedColumnName = "ENQ_ID", insertable = false, updatable = false)
  private Enquete enquete;

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public Date getDateResponse() {
    return dateResponse;
  }

  public void setDateResponse(Date dateResponse) {
    this.dateResponse = dateResponse;
  }

  public Enquete getEnquete() {
    return enquete;
  }

  public void setEnquete(Enquete enquete) {
    this.enquete = enquete;
  }

  public ResponseID getResponseId() {
    return responseId;
  }

  public void setResponseId(ResponseID responseId) {
    this.responseId = responseId;
  }

  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

}
