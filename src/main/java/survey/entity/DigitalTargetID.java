package survey.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class DigitalTargetID implements Serializable {

  @Column(name = "ENQ_ID")
  private int enquete;

  @Column(name = "ORDRE_NUM")

  private int ordrenum;

  public DigitalTargetID(int enquete) {
    super();
    this.enquete = enquete;
  }

  public int getEnquete() {
    return enquete;
  }

  public void setEnquete(int enquete) {
    this.enquete = enquete;
  }

  public int getOrdrenum() {
    return ordrenum;
  }

  public void setOrdrenum(int ordrenum) {
    this.ordrenum = ordrenum;
  }


  public DigitalTargetID(int enquete, int ordrenum) {
    super();
    this.enquete = enquete;
    this.ordrenum = ordrenum;
  }

  public DigitalTargetID() {
    super();
  }


}
