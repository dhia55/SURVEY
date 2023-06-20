package survey.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import survey.entity.SubTeam;


@Repository
public interface SubTeamDao  extends JpaRepository<SubTeam, Integer> {

}
