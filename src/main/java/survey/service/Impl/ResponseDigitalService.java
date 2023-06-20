package survey.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import survey.dao.ResponseDigitalDao;
import survey.dao.DigitalTargetDao;
import survey.dto.responseDto;
import survey.entity.DigitalTarget;
import survey.entity.ResponseDigital;
import survey.entity.ResponseDigitalID;
import survey.service.IResponseDigitalService;

@Service
public class ResponseDigitalService implements IResponseDigitalService {
	
	private static final Logger logger = LogManager.getLogger(ResponseDigitalService.class);
	
	@Autowired
	ResponseDigitalDao ResponseDigitalDao;
	
	@Autowired
	DigitalTargetDao DigitalTargetDao;
	
	Date d= new Date(System.currentTimeMillis());
	
	
	@Autowired
    survey.service.Impl.QuestionService QuestionService;
	
	
	@Override
	public ResponseDigital addResponseDigital(ResponseDigital r, int id, String email) {
		

		  r.setDateResponse(d);
	      ResponseDigitalID rI = new ResponseDigitalID();
	      rI.setEmail(email);
	      rI.setEnquete(id);
	 
	     // Random random = new Random();
	     // rI.setQuestionOrder( random.nextInt());
	      r.setResponseDigitalID(rI);
			return ResponseDigitalDao.save(r);
	}

	@Override
	public ResponseDigital update(ResponseDigital u) {
		// TODO Auto-generated method stub
		return ResponseDigitalDao.save(u);
	}

	@Override
	public List<ResponseDigital> getAll() {
		
		return ResponseDigitalDao.findAll();
	}

	@Override
	public ResponseDigital get(int id) {

		return ResponseDigitalDao.findById(id).get();
	}

	@Override
	public Boolean delete(int id) {
		ResponseDigitalDao.deleteById(id);
		return true;
	}

	@Override
	public List<ResponseDigital> addResponses(List<responseDto> r, int id, String email, String language) {
		
		List<ResponseDigital> liste = new ArrayList<ResponseDigital>();
		DigitalTarget DigitalTarget = DigitalTargetDao.gettargetsbyenq(id,email,language) ;
		logger.info("target"+DigitalTarget);
		for(int i=0; i<r.size();i++)
		{
			System.out.println("rrr : "+r.get(i).toString());

		     ResponseDigitalID rI = new ResponseDigitalID();
		      rI.setEmail(email);
		      rI.setEnquete(id);
		      ResponseDigital responseDig = new ResponseDigital();
		      responseDig.setResponseDigitalID(rI);
		      responseDig.setDateResponse(d);
		      responseDig.setResponse(r.get(i).getResponse());
		      rI.setQuestionOrder(r.get(i).getOrdre());
		      ResponseDigitalDao.save(responseDig);
              liste.add(responseDig);
              DigitalTarget.setAnswerStatus("1");
              DigitalTargetDao.save(DigitalTarget);
		}
		 
			return liste;
	}

	@Override
	public int responseNumber(int id) {
	return ResponseDigitalDao.responseNumber(id);
			
	}

	@Override
	public Boolean answered(int id, String email, String language) {
		DigitalTarget d = DigitalTargetDao.gettargetsbyenq(id, email, language);
		if(d.getAnswerStatus().equals("1"))
		return true;
		
		return false;
	}

	@Override
	public int avgResponse(int id) {
	int responseNumber= responseNumber(id);
	logger.info(responseNumber);
	int targetNumber= DigitalTargetDao.targetNumber(id);
	logger.info(targetNumber);
	int avg=0;
	if(targetNumber!=0 && responseNumber!=0)
	avg= (responseNumber*100)/targetNumber;
	
		return avg;
	}

	@Override
	public List<ResponseDigital> addResponsesSponSurvey(List<responseDto> r, int id, String language) {
		List<ResponseDigital> liste = new ArrayList<ResponseDigital>();
		//DigitalTarget DigitalTarget = DigitalTargetDao.gettargetsbyenq(id,email,language) ;
		//logger.info("target"+DigitalTarget);
		for(int i=0; i<r.size();i++)
		{
			System.out.println("rrr : "+r.get(i).toString());

		     ResponseDigitalID rI = new ResponseDigitalID();
		      rI.setEmail("PREFIX");
		      rI.setEnquete(id);
		      ResponseDigital responseDig = new ResponseDigital();
		      responseDig.setResponseDigitalID(rI);
		      responseDig.setDateResponse(d);
		      responseDig.setResponse(r.get(i).getResponse());
		      rI.setQuestionOrder(r.get(i).getOrdre());
		      ResponseDigitalDao.save(responseDig);
              liste.add(responseDig);
          
		}
		 
			return liste;
	}

}
