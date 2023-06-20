package survey.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLE_DIGITAL", schema = "public")
public class RoleDigital {
	

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;	
	
	
	 public RoleDigital() {
		super();
	}


	@Column(name = "role_name")
	private String roleName;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public RoleDigital(int id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}
	
	 

	

}
