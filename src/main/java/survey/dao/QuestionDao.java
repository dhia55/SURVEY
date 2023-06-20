package survey.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import survey.entity.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
	
	@Query("Select "
			+ "q from Question q "
			+ "where q.script.scriptId=:id "
			+ "ORDER BY q.ordre ASC")
	public List<Question> findByscript(int id);
	
	
	@Query(value = "select  T.param1 as param1, T.param2 as param2, T.param3 as param3, T.param4 as param4," + 
			
			" T.param5 as param5, T.param6 as param6, T.param7 as param7, T.param8 as param8, T.param9 as param9," + 
		
			"     T.param10 as param10," + 
			
			"     CASE " + 
			
			"      WHEN P.param_code  = 'param1' then T.param1 " + 
			
			"     WHEN P.param_code  = 'param2' then T.param2 " + 

			"     WHEN P.param_code  = 'param3' then T.param3 " + 
			
			"     WHEN P.param_code  = 'param4' then T.param4 " + 

			"     WHEN P.param_code  = 'param5' then T.param5 " + 

			"     WHEN P.param_code  = 'param6' then T.param6 " + 

			"     WHEN P.param_code  = 'param7' then T.param7 " + 
		
			"     WHEN P.param_code  = 'param8' then T.param8 " + 

			"     WHEN P.param_code  = 'param9' then T.param9 " + 

			"     WHEN P.param_code  = 'param10' then T.param10 " + 

			"     END " + 
		
			"     from enquetes E " + 
			
			"     join scripts S on E.script = S.script_id " + 
			
			"     join questions Q on  Q.script_id = S.script_id " + 
			
			"     Join digital_target T On E.enq_id = T.enq_id" + 
			
			"     left join parametres P  on P.script = S.script_id" + 
			
			"     WHERE E.enq_id =:id ", nativeQuery = true)

public List<String> questionParams(int id );

}
