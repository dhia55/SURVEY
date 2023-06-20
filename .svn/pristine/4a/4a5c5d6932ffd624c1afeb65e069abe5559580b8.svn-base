package survey.service;

import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import survey.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;
@Service
public class ReponseService implements IReponseService {
	
	 private static final Logger logger = LogManager.getLogger(ReponseService.class);

	    @Autowired
	    survey.dao.ReponseDao rep;
	    @Override
	    public Reponse addReponse(Reponse s) {
	        return rep.save(s);    }

	    @Override
	    public List<Reponse> getAll() {
	        return rep.findAll();
	    }

	    @Override
	    public Reponse get(int id) {
	return rep.findById(id).get() ;   }

	    @Override
	    public Boolean delete(int id) {
	        rep.deleteById(id);
	        return true;    }

	    @Override
	    public Reponse update(Reponse s) {
	        return rep.save(s);
	    }

	    @Override
	    public List<Object> get() {
	        return rep.get();
	    }

	    @Override
	    public List<Object> getResurvey() {
	        return rep.getResurvey1();
	    }

	    @Override

	    public   List<ent>  getScore() {
	      return (List<ent>) (List<?>)rep.getScore();

	    }

	    @Override
	    public List<ent> getSCResurvey() {
	        return (List<ent>) (List<?>)rep.getScoreResurvey();
	    }

	    @Override
	    public List<Object> getScoreByparam() {
	        return rep.getScoreByParam();
	    }

	    @Override
	    public List<Object> getById(int id) {
	        return rep.getByen(id);
	    }

	    @Override
	    public List<ent> getScoreById(int id) {
	        return (List<ent>) (List<?>)rep.getScoreByEnq(id);
	    }

	    @Override
	    public List<Object> getScoreByDate(Date d1, Date d2) {
	        return rep.getByDate(d1,d2);
	    }

	    @Override
	    public List<ent> getScoreByDATE(Date d1, Date d2) {
	        return (List<ent>) (List<?>)rep.getScoreByDate(d1,d2);
	    }

}
