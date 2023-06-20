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
@Table(name="Sous_Categories")
public class SousCategories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SOUS_CATEGID")
	Long sousCategId;
	
	@Column(name="SOUS_CATEG")
	String sousCateg;
	
	
	@Column(name="CATG_NAME")
	String catgName;
	
	

	

	

	

	public Long getSousCategId() {
		return sousCategId;
	}









	public void setSousCategId(Long sousCategId) {
		this.sousCategId = sousCategId;
	}









	public String getSousCateg() {
		return sousCateg;
	}









	public void setSousCateg(String sousCateg) {
		this.sousCateg = sousCateg;
	}









	public String getCatgName() {
		return catgName;
	}









	public void setCatgName(String catgName) {
		this.catgName = catgName;
	}









	public SousCategories(Long sousCategId, String sousCateg, String catgName) {
		super();
		this.sousCategId = sousCategId;
		this.sousCateg = sousCateg;
		this.catgName = catgName;
	}









	public SousCategories() {
		super();
	}
	
	
}
