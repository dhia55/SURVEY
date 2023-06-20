package survey.service.Impl;



import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import survey.entity.Enquete;
import survey.entity.Targuet;
import survey.entity.TarguetID;
import survey.dao.EnqueteDao;
import survey.dao.TarguetDao;
import survey.dto.questionDto;
import survey.service.ITargetService;


@Service
public class TargetService implements ITargetService {
	
	
	private static final Logger logger = LogManager.getLogger(TargetService.class);
	
	Date d= new Date(System.currentTimeMillis());
	
	@Autowired
	TarguetDao TarguetDao;
	
	@Autowired
    DigitalTargetService.EnqueteService EnqueteService;
	

	
	@Autowired
	EnqueteDao EnqueteDao;
	
	@Autowired
	survey.service.Impl.ScriptService ScriptService;
	
	
	@Override
	public Targuet addTarget(Targuet t, int id) {
return null;
	}

	@Override
	public List<Targuet> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Targuet get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteTarguet(Targuet t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendbywhatss(int id) {
		List<Targuet> targets = TarguetDao.gettargetsbyenqid(id);
        String msg = null;
		
		Enquete e = EnqueteService.get(id);
	
		for(int i=0; i<targets.size();i++)
		{
			List<questionDto> questions = EnqueteService.getlangtype(id,targets.get(i).getLanguage());
			
	
			for(int j=0; j<questions.size();j++)
			{
				
				Targuet targuet = new Targuet();
				if(targets.get(i).getLanguage().equals("Arabe"))
				{
		     msg=questions.get(j).getQuestion().getTextAr();
				}
				else if(targets.get(i).getLanguage().equals("Français"))
				{
				     msg=questions.get(j).getQuestion().getTextFr();
						}
				else 
				{
					msg=questions.get(j).getQuestion().getTextEng();
				}
				

			Twilio.init("ACe33fc9c798582b4670c2f842a7109653","563923a876b8c6891465c65bdaef2b82");
	        Message message = Message.creator(
	                new com.twilio.type.PhoneNumber("whatsapp:"+targets.get(i).getTargetId().getMsisdn()),
	                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
	        		msg)
	           
	            .create();
	        
	        
	     TarguetID TarguetID = new TarguetID(id,targets.get(i).getTargetId().getMsisdn());
	        
	        targuet.setTargetId(TarguetID);
			targuet.setQuestionId(questions.get(j).getQuestion().getOrdre());
			targuet.setLanguage(targets.get(i).getLanguage());
			TarguetDao.save(targuet);
			}
	

		}
		

	}
	
	
	


}
