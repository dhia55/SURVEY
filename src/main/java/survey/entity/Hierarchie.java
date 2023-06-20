package survey.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HIERARCHIE")
public class Hierarchie {

  public Hierarchie() {
    // TODO Auto-generated constructor stub
  }


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private long id;


  @Column(name = "MATRICULE_EMP")
  private String matriculeEmp;

  @Column(name = "FULL_NAME_EMP")
  private String fullNameEmp;

  @Column(name = "EMAIL_ADDRESS_EMP")
  private String emailAddressEmp;

  @Column(name = "MATRICULE_SUP")
  private String matriculeSup;

  @Column(name = "POSITION_SUP")
  private String positionSup;

  @Column(name = "FULL_NAME_SUP")
  private String fullNameSup;

  @Column(name = "EMAIL_ADDRESS_SUP")
  private String emailAddressSup;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getMatriculeEmp() {
    return matriculeEmp;
  }

  public void setMatriculeEmp(String matriculeEmp) {
    this.matriculeEmp = matriculeEmp;
  }

  public String getFullNameEmp() {
    return fullNameEmp;
  }

  public void setFullNameEmp(String fullNameEmp) {
    this.fullNameEmp = fullNameEmp;
  }

  public String getEmailAddressEmp() {
    return emailAddressEmp;
  }

  public void setEmailAddressEmp(String emailAddressEmp) {
    this.emailAddressEmp = emailAddressEmp;
  }

  public String getMatriculeSup() {
    return matriculeSup;
  }

  public void setMatriculeSup(String matriculeSup) {
    this.matriculeSup = matriculeSup;
  }

  public String getPositionSup() {
    return positionSup;
  }

  public void setPositionSup(String positionSup) {
    this.positionSup = positionSup;
  }

  public String getFullNameSup() {
    return fullNameSup;
  }

  public void setFullNameSup(String fullNameSup) {
    this.fullNameSup = fullNameSup;
  }

  public String getEmailAddressSup() {
    return emailAddressSup;
  }

  public void setEmailAddressSup(String emailAddressSup) {
    this.emailAddressSup = emailAddressSup;
  }


}
