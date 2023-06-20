package survey.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "CATEGORIES")
public class Categories {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CATG_ID")
  private long catgId;

  @Column(name = "CATEGORIE_Name")
  private String categorieName;

  @Column(name = "SCRIPT_Name")
  private String scriptName;

  @Column(name = "ACTIF")
  private String actif;

  public long getCatgId() {
    return catgId;
  }

  public void setCatgId(long catgId) {
    this.catgId = catgId;
  }

  public String getCategorieName() {
    return categorieName;
  }

  public void setCategorieName(String categorieName) {
    this.categorieName = categorieName;
  }

  public String getScriptName() {
    return scriptName;
  }

  public void setScriptName(String scriptName) {
    this.scriptName = scriptName;
  }

  public String getActif() {
    return actif;
  }

  public void setActif(String actif) {
    this.actif = actif;
  }

  public Categories() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Categories(long catgId, String categorieName, String scriptName, String actif) {
    super();
    this.catgId = catgId;
    this.categorieName = categorieName;
    this.scriptName = scriptName;
    this.actif = actif;
  }

  // @OneToMany(cascade = CascadeType.ALL, mappedBy="categorie")
  //private Set<SousCategories> SousCategories;


}
