package survey.entity.users;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import survey.entity.users.Team;

@Entity
@Table(name = "SUBTEAMS")
public class SubTeam {

  @Id
  @Column(name = "SUBTEAM_ID")
  private int subTeamId;

  @Column(name = "SUB_TEAM_NAME")
  private String subTeamName;

  @Column(name = "CREATION_DATE")
  private Date creationDate;

  @Column(name = "MAIL_MANAGER")
  private String mailManager;

  @Column(name = "MAIL_CC")
  private String mailCc;

  @Column(name = "MAIL_CCI")
  private String mailCci;

  @ManyToOne
  @JoinColumn(name = "TEAM_ID", referencedColumnName = "TEAM_ID")
  @JsonIgnoreProperties("subTeams")
  private Team team;

  public int getSubTeamId() {
    return subTeamId;
  }

  public void setSubTeamId(int subTeamId) {
    this.subTeamId = subTeamId;
  }

  public String getSubTeamName() {
    return subTeamName;
  }

  public void setSubTeamName(String subTeamName) {
    this.subTeamName = subTeamName;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  public String getMailManager() {
    return mailManager;
  }

  public void setMailManager(String mailManager) {
    this.mailManager = mailManager;
  }

  public String getMailCc() {
    return mailCc;
  }

  public void setMailCc(String mailCc) {
    this.mailCc = mailCc;
  }

  public String getMailCci() {
    return mailCci;
  }

  public void setMailCci(String mailCci) {
    this.mailCci = mailCci;
  }

}
