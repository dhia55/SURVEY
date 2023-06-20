package survey.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import survey.entity.Enquete;

@Repository
public interface EnqueteDao extends JpaRepository<Enquete, Integer> {

	@Query("Select "
			+ "e from Enquete e "
			+ "where e.status=:status")
	public Enquete findByStatus(String status);

	@Query("Select "
			+ "e from Enquete e "
			+ "where  e.id in (select r.responseId.enquete From Reponse r where r.response in ('1','2','3','4','5'))")
	public List<Enquete> FindNotNull();

	@Query("Select "
			+ "e from Enquete e "
			+ "where  e.id in (select r.responseId.enquete From Reponse r where r.response in ('1','2','3','4','5')) " +
			"" +
			"" +
			"" +
			"and e.startDate between :d1 and :d2  ")
	public List<Enquete> FindDate(Date d1, Date d2);
}
