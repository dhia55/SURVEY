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
@Table(name = "Response_Digital")
public class ResponseDigital {

  @EmbeddedId
  private ResponseDigitalID ResponseDigitalID;

  @Column(name = "response")
  private String response;

  @Column(name = "date_response")
  private Date dateResponse;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id", referencedColumnName = "id")
	private question question;*/

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "enq_id", referencedColumnName = "enq_id", insertable = false, updatable = false)
  private Enquete enquete;

  public ResponseDigitalID getResponseId() {
    return ResponseDigitalID;
  }

  public void setResponseDigitalID(ResponseDigitalID responseId) {
    this.ResponseDigitalID = responseId;
  }

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

	/*public question getQuestion() {
		return question;
	}

	public void setQuestion(question question) {
		this.question = question;
	}*/

  public Enquete getEnquete() {
    return enquete;
  }

  public void setEnquete(Enquete enquete) {
    this.enquete = enquete;
  }

  public ResponseDigital(ResponseDigitalID ResponseDigitalID, String response, Date dateResponse, Enquete enquete) {
    super();
    this.ResponseDigitalID = ResponseDigitalID;
    this.response = response;
    this.dateResponse = dateResponse;
    //this.question = question;
    this.enquete = enquete;
  }

  public ResponseDigital() {
    super();
  }


}
