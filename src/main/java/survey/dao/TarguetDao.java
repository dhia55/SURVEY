package survey.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import survey.entity.Targuet;

@Repository
public interface TarguetDao  extends JpaRepository<Targuet, Integer>  {
	
	@Query("Select "
			+ "d from Targuet d "
			+ "where d.targetId.enquete=:id ")
	public List<Targuet> gettargetsbyenqid(int id);

}
