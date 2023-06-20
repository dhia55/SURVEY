package survey.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SCRIPTS")
public class Script implements Serializable {



	@Id
	@Column(name = "SCRIPT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int scriptId;
	
	@Column(name = "SCRIPT_NAME")
	private String scriptName;
	
//	@Column(name = "DESCRIPTION")
//	private String description;
	
	@Column(name = "DATE_DEBUT")
	private Date startDate;
	
	@Column(name = "DATE_FIN")
	private Date endDate;
	
	@Column(name = "SCRIPT_POOL")
	private String scriptPool;
 
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "script" )
	@JsonIgnore
	private List<Question> questions = new ArrayList<Question>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "script" )
	@JsonIgnore
	private List<Enquete> enquetes = new ArrayList<Enquete>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "script")
	@JsonIgnore
	private List<Parametre> parametres = new ArrayList<Parametre>();

	public int getScriptId() {
		return scriptId;
	}

	public void setScriptId(int scriptId) {
		this.scriptId = scriptId;
	}

	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}

//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	/*public List<Parametre> getParametres() {
		return parametres;
	}

	public void setParametres(List<Parametre> parametres) {
		this.parametres = parametres;
	}*/
	
	public String getScriptPool() {
		return scriptPool;
	}

	public void setScriptPool(String scriptPool) {
		this.scriptPool = scriptPool;
	}

	public List<Enquete> getEnquetes() {
		return enquetes;
	}

	public void setEnquetes(List<Enquete> enquetes) {
		this.enquetes = enquetes;
	}

	public Script(int scriptId, String scriptName, Date startDate, Date endDate, String scriptPool,
			List<Question> questions, List<Enquete> enquetes) {
		super();
		this.scriptId = scriptId;
		this.scriptName = scriptName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.scriptPool = scriptPool;
		this.questions = questions;
		this.enquetes = enquetes;
	}

	public Script() {
		super();
	}

	public List<Parametre> getParametres() {
		return parametres;
	}

	public void setParametres(List<Parametre> parametres) {
		this.parametres = parametres;
	}

	public Script(int scriptId, String scriptName, Date startDate, Date endDate, String scriptPool,
			List<Question> questions, List<Enquete> enquetes, List<Parametre> parametres) {
		super();
		this.scriptId = scriptId;
		this.scriptName = scriptName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.scriptPool = scriptPool;
		this.questions = questions;
		this.enquetes = enquetes;
		this.parametres = parametres;
	}
	
	
 
	
	
}
