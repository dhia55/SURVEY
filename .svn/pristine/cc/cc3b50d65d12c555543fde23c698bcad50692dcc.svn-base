package survey.entity;

import java.util.ArrayList;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Users_digital")
public class UserDigital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	
	@Column(unique = true)
	private String username ;
	
	//@JsonProperty(access = Access.WRITE_ONLY)
	private String password ;
	
    private String fullName;
    
    private String mail;
    
    @Column(name = "reset_token")
	private String resetToken;

	 @Column(name = "status")
	private int status;
	
	 
		@ManyToOne
		private TypeDigital type;
		
		@ManyToMany(fetch= FetchType.EAGER )
		@JoinTable(name="users_roles", joinColumns= @JoinColumn(name="user_id"),
		inverseJoinColumns = @JoinColumn(name="role_id"))
		private Set<RoleDigital> roles = new HashSet<>();
		
		
		@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user" )
		@JsonIgnore
		private List<Enquete> enquetes = new ArrayList<Enquete>();

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public String getResetToken() {
			return resetToken;
		}

		public void setResetToken(String resetToken) {
			this.resetToken = resetToken;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public TypeDigital getType() {
			return type;
		}

		public void setType(TypeDigital type) {
			this.type = type;
		}

		public Set<RoleDigital> getRoles() {
			return roles;
		}

		public void setRoles(Set<RoleDigital> roles) {
			this.roles = roles;
		}
		
		

		public List<Enquete> getEnquetes() {
			return enquetes;
		}

		public void setEnquetes(List<Enquete> enquetes) {
			this.enquetes = enquetes;
		}

		public UserDigital(Long id, String username, String password, String fullName, String mail, String resetToken,
				int status, TypeDigital type, Set<RoleDigital> roles) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.fullName = fullName;
			this.mail = mail;
			this.resetToken = resetToken;
			this.status = status;
			this.type = type;
			this.roles = roles;
		}
		
		

		public UserDigital(Long id, String username, String password, String fullName, String mail, String resetToken,
				int status, TypeDigital type, Set<RoleDigital> roles, List<Enquete> enquetes) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.fullName = fullName;
			this.mail = mail;
			this.resetToken = resetToken;
			this.status = status;
			this.type = type;
			this.roles = roles;
			this.enquetes = enquetes;
		}

		public UserDigital() {
			super();
		}

		@Override
		public String toString() {
			return "UserDigital [id=" + id + ", username=" + username + ", password=" + password + ", fullName="
					+ fullName + ", mail=" + mail + ", resetToken=" + resetToken + ", status=" + status + ", type="
					+ type + ", roles=" + roles + ", enquetes=" + enquetes + "]";
		}


		
		

}
