package survey.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import survey.entity.Echelle;

@Repository
public interface EchelleDao extends JpaRepository<Echelle, Integer> {

	
	@Query("Select DISTINCT "
			+ "e.answerScale from Echelle e ")
	public List<String> getallscales();
	
	@Query("Select e "
			+ "from Echelle e GROUP BY e.answerCode ")
	public List<Echelle> getallscalesdis();
	
	
	@Query("Select DISTINCT "
			+ "e from Echelle e order by e.answerCode  ASC ")
	public List<Echelle> getall();
}
