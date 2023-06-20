package survey.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import survey.entity.ResponseDigital;

@Repository
public interface ResponseDigitalDao extends JpaRepository<ResponseDigital, Integer>  {
	
	@Query("Select "
			+ "count(distinct r.ResponseDigitalID.email) "
			+ "from ResponseDigital r "
			+ "where r.ResponseDigitalID.enquete=:id ")
	public int responseNumber(int id);

}
