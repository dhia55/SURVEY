package survey.entity.users;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TEAMS")
public class Team {

  @Id
  @Column(name = "TEAM_ID")
  private int teamId;

  @Column(name = "TEAM_NAME")
  private String teamName;

  @Column(name = "CREATION_DATE")
  private Date creationDate;

  @Column(name = "MAIL_MANAGER")
  private String mailManager;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
  @JsonIgnoreProperties("team")
  private Set<SubTeam> subTeams = new HashSet<SubTeam>();

  public int getTeamId() {
    return teamId;
  }

  public void setTeamId(int teamId) {
    this.teamId = teamId;
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public Set<SubTeam> getSubTeams() {
    return subTeams;
  }

  public void setSubTeams(Set<SubTeam> subTeams) {
    this.subTeams = subTeams;
  }

  public String getMailManager() {
    return mailManager;
  }

  public void setMailManager(String mailManager) {
    this.mailManager = mailManager;
  }

}
