package survey.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROPRIETE")
public class Propriete implements Serializable {

  private static final long serialVersionUID = 1L;
  private int id;

  @Column(name = "COD_NOM")
  private String codNom;

  @Column(name = "COD_PROP")
  private String codProp;

  @Column(name = "DES_PROP")
  private String desProp;

  @Column(name = "TX_PROP1", nullable = true)
  private String txProp1;

  @Column(name = "TX_PROP2", nullable = true)
  private String txProp2;

  @Column(name = "VAR_PROP1", nullable = true)
  private String varProp1;

  @Column(name = "VAR_PROP2", nullable = true)
  private String varProp2;

  @Column(name = "VAR_PROP3", nullable = true)
  private String varProp3;

  @Column(name = "NUM_PROP1", nullable = true)
  private Integer numProp1;

  @Column(name = "NUM_PROP2", nullable = true)
  private Integer numProp2;

  @Column(name = "DATE_MAJ")
  private Date dateMaj;

  @Column(name = "COD_USER")
  private String codUser;

  @Id
  @GeneratedValue
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public Integer getNumProp1() {
    return numProp1;
  }

  public void setNumProp1(Integer numProp1) {
    this.numProp1 = numProp1;
  }

  public Integer getNumProp2() {
    return numProp2;
  }

  public void setNumProp2(Integer numProp2) {
    this.numProp2 = numProp2;
  }

  public String getCodNom() {
    return codNom;
  }

  public void setCodNom(String codNom) {
    this.codNom = codNom;
  }

  @Column(nullable = false)
  public String getCodProp() {
    return codProp;
  }

  public void setCodProp(String codProp) {
    this.codProp = codProp;
  }

  public String getDesProp() {
    return desProp;
  }

  public void setDesProp(String desProp) {
    this.desProp = desProp;
  }


  public String getVarProp1() {
    return varProp1;
  }

  public void setVarProp1(String varProp1) {
    this.varProp1 = varProp1;
  }


  public Date getDateMaj() {
    return dateMaj;
  }

  public void setDateMaj(Date dateMaj) {
    this.dateMaj = dateMaj;
  }

  public String getCodUser() {
    return codUser;
  }

  public void setCodUser(String codUser) {
    this.codUser = codUser;
  }

  public String getTxProp1() {
    return txProp1;
  }

  public void setTxProp1(String txProp1) {
    this.txProp1 = txProp1;
  }

  public String getTxProp2() {
    return txProp2;
  }

  public void setTxProp2(String txProp2) {
    this.txProp2 = txProp2;
  }

  public String getVarProp2() {
    return varProp2;
  }

  public void setVarProp2(String varProp2) {
    this.varProp2 = varProp2;
  }

  public String getVarProp3() {
    return varProp3;
  }

  public void setVarProp3(String varProp3) {
    this.varProp3 = varProp3;
  }


}