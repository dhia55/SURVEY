package survey.entity;


import survey.entity.users.RoleID;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class Role {

	@EmbeddedId
	private RoleID roleId;
	
	@Column(name = "COD_USER")
	private String codUser;
	
	@Column(name = "DATE_CREA")
	private Date dateCrea;
	
	@Column(name = "DATE_MAJ")
	private Date dateMaj;
	
	@Column(name = "ACTIF")
	private String actif;

	public RoleID getRoleId() {
		return roleId;
	}

	public void setRoleId(RoleID roleId) {
		this.roleId = roleId;
	}

	public String getCodUser() {
		return codUser;
	}

	public void setCodUser(String codUser) {
		this.codUser = codUser;
	}

	public Date getDateCrea() {
		return dateCrea;
	}

	public void setDateCrea(Date dateCrea) {
		this.dateCrea = dateCrea;
	}
 
	public Date getDateMaj() {
		return dateMaj;
	}

	public void setDateMaj(Date dateMaj) {
		this.dateMaj = dateMaj;
	}

	public String getActif() {
		return actif;
	}

	public void setActif(String actif) {
		this.actif = actif;
	}
 
}
