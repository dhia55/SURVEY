package survey.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import survey.entity.Rejet;

@Repository
public interface RejetDao extends JpaRepository<Rejet, Integer> {

}
