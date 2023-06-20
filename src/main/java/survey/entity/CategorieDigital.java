package survey.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
public class CategorieDigital {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;


  @Column(name = "category_name")
  private String categoryName;


  public int getId() {
    return id;
  }


  public void setId(int id) {
    this.id = id;
  }


  public String getCategoryName() {
    return categoryName;
  }


  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }


  public CategorieDigital(int id, String categoryName) {
    super();
    this.id = id;
    this.categoryName = categoryName;
  }


  public CategorieDigital() {
    super();
  }


}
