package survey.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ResponseDigitalID implements Serializable {


  @Column(name = "ENQ_ID")
  private int enquete;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "QUESTION_ORDER")
  private int questionOrder;

  public int getEnquete() {
    return enquete;
  }

  public void setEnquete(int enquete) {
    this.enquete = enquete;
  }


  public int getQuestionOrder() {
    return questionOrder;
  }

  public void setQuestionOrder(int questionOrder) {
    this.questionOrder = questionOrder;
  }


  public ResponseDigitalID() {
    super();
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ResponseDigitalID(int enquete, String email, int questionOrder) {
    super();
    this.enquete = enquete;
    this.email = email;
    this.questionOrder = questionOrder;
  }


}
