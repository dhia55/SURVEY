package survey.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import survey.entity.users.Team;

@Repository
public interface TeamDao   extends JpaRepository<Team, Integer>  {

}
