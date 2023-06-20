package survey.entity.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeDigital {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;


  private String typeName;


  public TypeDigital() {
    super();
  }


  public int getId() {
    return id;
  }


  public void setId(int id) {
    this.id = id;
  }


  public String getTypeName() {
    return typeName;
  }


  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }


  public TypeDigital(int id, String typeName) {
    super();
    this.id = id;
    this.typeName = typeName;
  }


}

