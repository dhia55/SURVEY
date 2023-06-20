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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ENQUETES")
public class Enquete implements Serializable  {



	@Id
	@Column(name = "ENQ_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "START_DATE")
	private Date startDate;
	
	@Column(name = "END_DATE")
	private Date endDate;
	
	private String name;
	
	@Column(name = "STATUS")
	private String status;
	
 	@ManyToOne(fetch = FetchType.EAGER)
 	private Script script;
 	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID", referencedColumnName = "id")
 	private UserDigital user;
	
	@Column(name = "CHANNEL")
	private String channel;
	
	@Column(name = "SHORT_CODE")
	private String shortCode;
	
	@Column(name = "TYPE_INTERACTION")
	private String typeInteraction; 
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,  cascade = CascadeType.REMOVE, mappedBy = "enquete")
	private List<Targuet> targuets = new ArrayList<Targuet>();
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,  cascade = CascadeType.REMOVE, mappedBy = "digitalTargetID.enquete")
	private List<DigitalTarget> digitaltarguets = new ArrayList<DigitalTarget>();
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enquete")
	private List<Rejet> rejects = new ArrayList<Rejet>();

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enquete")
	private List<Reponse> reponses = new ArrayList<Reponse>();
	
	
	public List<Reponse> getReponses() {
		return reponses;
	}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Script getScript() {
		return script;
	}

	public void setScript(Script script) {
		this.script = script;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getTypeInteraction() {
		return typeInteraction;
	}

	public void setTypeInteraction(String typeInteraction) {
		this.typeInteraction = typeInteraction;
	}

	public List<Targuet> getTarguets() {
		return targuets;
	}

	public void setTarguets(List<Targuet> targuets) {
		this.targuets = targuets;
	}

	public List<Rejet> getRejects() {
		return rejects;
	}

	public void setRejects(List<Rejet> rejects) {
		this.rejects = rejects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public UserDigital getUser() {
		return user;
	}

	public void setUser(UserDigital user) {
		this.user = user;
	}

	public Enquete(int id, Date startDate, Date endDate, String name, String status, Script script, String channel,
			String shortCode, String typeInteraction, List<Targuet> targuets, List<Rejet> rejects,
			List<Reponse> reponses) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.name = name;
		this.status = status;
		this.script = script;
		this.channel = channel;
		this.shortCode = shortCode;
		this.typeInteraction = typeInteraction;
		this.targuets = targuets;
		this.rejects = rejects;
		this.reponses = reponses;
	}

	public Enquete() {
		super();
	}

	public Enquete(Date startDate, Date endDate, String name, String status, Script script, String channel,
			String shortCode, String typeInteraction, List<Targuet> targuets, List<Rejet> rejects,
			List<Reponse> reponses) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.name = name;
		this.status = status;
		this.script = script;
		this.channel = channel;
		this.shortCode = shortCode;
		this.typeInteraction = typeInteraction;
		this.targuets = targuets;
		this.rejects = rejects;
		this.reponses = reponses;
	}

	public Enquete(int id, Date startDate, Date endDate, String name, String status, Script script, UserDigital user,
			String channel, String shortCode, String typeInteraction, List<Targuet> targuets, List<Rejet> rejects,
			List<Reponse> reponses) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.name = name;
		this.status = status;
		this.script = script;
		this.user = user;
		this.channel = channel;
		this.shortCode = shortCode;
		this.typeInteraction = typeInteraction;
		this.targuets = targuets;
		this.rejects = rejects;
		this.reponses = reponses;
	}

	public List<DigitalTarget> getDigitaltarguets() {
		return digitaltarguets;
	}

	public void setDigitaltarguets(List<DigitalTarget> digitaltarguets) {
		this.digitaltarguets = digitaltarguets;
	}

	public Enquete(int id, Date startDate, Date endDate, String name, String status, Script script, UserDigital user,
			String channel, String shortCode, String typeInteraction, List<Targuet> targuets,
			List<DigitalTarget> digitaltarguets, List<Rejet> rejects, List<Reponse> reponses) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.name = name;
		this.status = status;
		this.script = script;
		this.user = user;
		this.channel = channel;
		this.shortCode = shortCode;
		this.typeInteraction = typeInteraction;
		this.targuets = targuets;
		this.digitaltarguets = digitaltarguets;
		this.rejects = rejects;
		this.reponses = reponses;
	}
	
	

}
