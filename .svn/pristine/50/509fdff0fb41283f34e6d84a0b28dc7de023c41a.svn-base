package survey.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import survey.dao.DigitalTargetDao;
import survey.dao.EnqueteDao;
import survey.entity.DigitalTarget;
import survey.entity.DigitalTargetID;
import survey.entity.Enquete;
import survey.entity.Script;
import survey.entity.UserDigital;


@Service
public class DigitalTargetService implements IDigitalTargetService{
	
	private static final Logger logger = LogManager.getLogger(DigitalTargetService.class);
	
	Date d= new Date(System.currentTimeMillis());
	
	@Autowired
	DigitalTargetDao DigitalTargetDao;
	
	@Autowired
	EnqueteService EnqueteService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	EnqueteDao EnqueteDao;
	
	@Autowired
	ScriptService ScriptService;
	
	
	@Autowired
	private EmailSenderService emailSenderService;

	@Override
	public DigitalTarget adddigitalTarget(DigitalTarget t, int id) {
		
		 Enquete e = EnqueteService.get(id);
		  Random random = new Random();
		  DigitalTargetID di = new DigitalTargetID(e.getId(), random.nextInt());
  	      t.setDigitalTargetID(di);
  	      t.setCreationDate(d);
  	      t.setEtat("0");
  	      t.setAnswerStatus("0");

		return DigitalTargetDao.save(t);
	}

	@Override
	public List<DigitalTarget> getAll() {
		
		return DigitalTargetDao.findAll();
	}

	@Override
	public DigitalTarget get(int id) {

		return DigitalTargetDao.findById(id).get();
	}

	@Override
	public Boolean deleteDigital(DigitalTarget t) {
		DigitalTargetDao.delete(t);
		return true;
	}


	@Override
	public void sendtargets(int id, String language) throws MessagingException {
		List<DigitalTarget> digitalTargets = DigitalTargetDao.getalltargetsbyenq(id,language);
		//String surveyLink = "http://localhost:4200/surveyLink/" + id +"/"+ language;
		
		Enquete e = EnqueteService.get(id);
	
		for(int i=0; i<digitalTargets.size();i++)
		{
			String link=id +"/"+ language+"/"+ digitalTargets.get(i).getEmailCustomer();
			String encodedUrl = Base64.getUrlEncoder().encodeToString(link.getBytes());
			logger.info(encodedUrl);
			//String replace =link.replace("/", "");
			//logger.info(replace);
			//String sha256hex = DigestUtils.sha256Hex(replace);
			//logger.info(sha256hex);
			String surveyLink = "http://localhost:4200/surveyLink/" + encodedUrl;
		
	    	emailSenderService.sendMailWithAttachment(digitalTargets.get(i).getEmailCustomer(),
          			"Hello, \n"
          			+ "You have requested to answer our survey. \n"
          			+ "Click the link bellow to access:\n"
          			+ surveyLink +"\n",
          			"New survey",
          			"D:\\PFE\\Ooredoo logo.png");
	    	
		}
		e.setStatus("RUNNING");
		EnqueteDao.save(e);
		
	}

	@Override
	public List<DigitalTarget> getAllbefore(MultipartFile file) throws IOException {
		System.out.println(" getAllBeforeService");
		 List<DigitalTarget> tutorials = helper.csvToTutorials(file.getInputStream());
		return tutorials;
	}

	@Override
	public void save(MultipartFile file, int id) {
	    try {
	 
	  	  Enquete e = EnqueteService.get(id);
	  	  Script s = ScriptService.get(e.getScript().getScriptId());
	      logger.info(s.getScriptId());
			
	      List<DigitalTarget> tutorials = helper.csvToTutorials(file.getInputStream());
	      logger.info(tutorials.toString());
	      for(int i=0;i<tutorials.size();i++)
	      {
	    
	    	  Random random = new Random();
			  DigitalTargetID di = new DigitalTargetID(e.getId(),random.nextInt());
	    	  tutorials.get(i).setDigitalTargetID(di);
	    	  tutorials.get(i).setAnswerStatus("0");
	      }
	    
	      DigitalTargetDao.saveAll(tutorials);
	      
	    } catch (Exception e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
		
	}

	@Override
	public String decodedUrl(String encodedUrl) {

		byte[] decodedBytes = Base64.getUrlDecoder().decode(encodedUrl);
	
		String decodedUrl = new String(decodedBytes);
		//logger.info(decodedUrl);
		return decodedUrl;
	}
	
	  public ByteArrayInputStream load() {
		    List<DigitalTarget> tutorials = DigitalTargetDao.findAll();

		    ByteArrayInputStream in = helper.tutorialsToCSV(tutorials);
		    return in;
		  }

	@Override
	public int targetNumber(int id) {
	
		return DigitalTargetDao.targetNumber(id);
	}

	@Override
	public void sendbyemail(int id) throws MessagingException {
		List<DigitalTarget> digitalTargets = DigitalTargetDao.gettargetsbyenqid(id);
		//String surveyLink = "http://localhost:4200/surveyLink/" + id +"/"+ language;
		
		Enquete e = EnqueteService.get(id);
	
		for(int i=0; i<digitalTargets.size();i++)
		{
			String link=id +"/"+ digitalTargets.get(i).getLanguage()+"/"+ digitalTargets.get(i).getEmailCustomer();
		    String encodedUrl = Base64.getUrlEncoder().encodeToString(link.getBytes());
			//logger.info(encodedUrl);
			//String replace =link.replace("/", "");
			//logger.info(replace);
			//String sha256hex = DigestUtils.sha256Hex(replace);
			//logger.info(sha256hex);
			String surveyLink = "http://localhost:4200/surveyLink/" + encodedUrl;
			
		if(digitalTargets.get(i).getEtat().equals("0"))
		{
	    	emailSenderService.sendMailWithAttachment(digitalTargets.get(i).getEmailCustomer(),
          			"Hello, \n"
          			+ "You have requested to answer our survey. \n"
          			+ "Click the link bellow to access:\n"
          			+ surveyLink +"\n",
          			"New survey",
          			"D:\\PFE\\Ooredoo logo.png");
	    	
	    	digitalTargets.get(i).setEtat("1");
	    	DigitalTargetDao.save(digitalTargets.get(i));
	    	e.setStatus("RUNNING");
		}
	    	
		}
		
		
		EnqueteDao.save(e);
		
	}

/*	@Override
	public void sendbywhats(int id) {

	

			String link=generateLink(id);
			String msg= "Hello, You have requested to answer our survey. Click the link bellow to access:"+link;
			String encodedUrl = Base64.getUrlEncoder().encodeToString(link.getBytes());
            logger.info(encodedUrl);
//			String surveyLink = "http://localhost:4200/surveyLink/" + encodedUrl;
			
			
			Twilio.init("ACe33fc9c798582b4670c2f842a7109653","563923a876b8c6891465c65bdaef2b82");
	        Message message = Message.creator(
	                new com.twilio.type.PhoneNumber("whatsapp:+21694578034"),
	                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
	        		
	              		 "http://localhost:4200/surveyLink/MTA")
	            .create();
	        		
		
	}
*/
	@Override
	public String generateLink(int id) {
		//List<DigitalTarget> digitalTargets = DigitalTargetDao.gettargetsbyenqid(id);
		//String surveyLink = "http://localhost:4200/surveyLink/" + id +"/"+ language;
		String surveyLink = null;
		//Enquete e = EnqueteService.get(id);

			
		    String link=Integer.toString(id);
			String encodedUrl = Base64.getUrlEncoder().encodeToString(link.getBytes());
			surveyLink = "http://localhost:4200/spontaneousSurveyLink/" + encodedUrl;
	    	

		return surveyLink;
		
	}

	@Override
	public String generateLinkLang(int id,String language) {
		String surveyLink = null;
		//String generateLink = generateLink(id);
		//String decode= decodedUrl(generateLink);
		//logger.info(decode);
		String generateLinkLang= id+ "/"+language;
		//String encodedUrl = Base64.getUrlEncoder().encodeToString(generateLinkLang.getBytes());
		
		surveyLink =  generateLinkLang;

		return surveyLink;
	}

	@Override
	public String encodedUrl(int id, String lang) {
		
		String link= id+"/"+lang;
		String encodedUrl = Base64.getUrlEncoder().encodeToString(link.getBytes());


		//logger.info(decodedUrl);
		return encodedUrl;
	}

	@Override
	public List<DigitalTarget> getAllByUser() {
		List<DigitalTarget> list = new ArrayList<DigitalTarget>();
		List<DigitalTarget> targets= DigitalTargetDao.findAll();
		List<Enquete> liste = new ArrayList<Enquete>();
		List<Enquete> enquetes= EnqueteDao.findAll();
		Date d = new Date(System.currentTimeMillis());
		UserDigital u=userService.findUserByMail(SecurityContextHolder.getContext().getAuthentication().getName());
		for(int i=0;i<enquetes.size();i++)
		{
			
			if(enquetes.get(i).getUser().getId().equals(u.getId()))
			{
				liste.add(enquetes.get(i));
			}
		}
		for(int j=0;j<targets.size();j++)
		{
			int id= targets.get(j).getDigitalTargetID().getEnquete();
			for(int k=0;k<liste.size();k++)
			{
				
				if(liste.get(k).getId()== id)
				{
					list.add(targets.get(j));
				}
			}
			
		}
		 
		 return list;
	}

	@Override
	public DigitalTarget gettargetByenqId(int id) {
		
		return DigitalTargetDao.gettargetbyenqid(id);
	}

	@Override
	public DigitalTarget update(DigitalTarget t) {
		
		return DigitalTargetDao.save(t);
	}

}
