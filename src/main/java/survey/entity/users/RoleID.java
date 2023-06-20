package survey.entity.users;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RoleID implements Serializable {

  @Column(name = "ID")
  private int id;

  @Column(name = "TEAM_ID")
  private int teamId;

  @Column(name = "SUBTEAM_ID")
  private int subTeamId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getTeamId() {
    return teamId;
  }

  public void setTeamId(int teamId) {
    this.teamId = teamId;
  }

  public int getSubTeamId() {
    return subTeamId;
  }

  public void setSubTeamId(int subTeamId) {
    this.subTeamId = subTeamId;
  }

}
