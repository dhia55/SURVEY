package survey.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PARAMETRES")
public class Parametre implements Serializable {

  @Id
  @Column(name = "PARAM_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "PARAM_CODE")
  private String paramCode;

  @Column(name = "PARAM_MEANING")
  private String paramMeaning;

  @Column(name = "PARAM_DESCRIPTION")
  private String paramDescription;

  @Column(name = "PARAM_TYPE")
  private String paramType;

  @Column(name = "PARAM_FORMAT")
  private String paramFormat;

  @ManyToOne()
  private Script script;


  public Script getScript() {
    return script;
  }

  public void setScript(Script script) {
    this.script = script;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getParamCode() {
    return paramCode;
  }

  public void setParamCode(String paramCode) {
    this.paramCode = paramCode;
  }

  public String getParamMeaning() {
    return paramMeaning;
  }

  public void setParamMeaning(String paramMeaning) {
    this.paramMeaning = paramMeaning;
  }

  public String getParamDescription() {
    return paramDescription;
  }

  public void setParamDescription(String paramDescription) {
    this.paramDescription = paramDescription;
  }

  public String getParamType() {
    return paramType;
  }

  public void setParamType(String paramType) {
    this.paramType = paramType;
  }

  public String getParamFormat() {
    return paramFormat;
  }

  public void setParamFormat(String paramFormat) {
    this.paramFormat = paramFormat;
  }


}
