package survey.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import survey.entity.DigitalTarget;

@Repository
public interface DigitalTargetDao extends JpaRepository<DigitalTarget, Integer>{
	
	@Query("Select "
			+ "d from DigitalTarget d "
			+ "where d.digitalTargetID.enquete=:id "
			+ "and d.language=:language")
	public List<DigitalTarget> getalltargetsbyenq(int id, String language);
	
	
	@Query("Select "
			+ "d from DigitalTarget d "
			+ "where d.digitalTargetID.enquete=:id ")
	public List<DigitalTarget> gettargetsbyenqid(int id);
	
	@Query("Select "
			+ "d from DigitalTarget d "
			+ "where d.digitalTargetID.enquete=:id "
			+ "and d.language=:language "
			+ "and d.emailCustomer=:mail")
	public DigitalTarget gettargetsbyenq(int id, String mail, String language);
	
	
	@Query("Select "
			+ "count(*) "
			+ "from DigitalTarget d "
			+ "where d.digitalTargetID.enquete=:id ")
	public int targetNumber(int id);
	
	
	@Query("Select "
			+ "d from DigitalTarget d "
			+ "where d.digitalTargetID.enquete=:id ")
	public DigitalTarget gettargetbyenqid(int id);

}
