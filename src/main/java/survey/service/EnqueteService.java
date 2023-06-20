package survey.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.util.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import survey.dao.EnqueteDao;
import survey.dao.ScriptDao;
import survey.dto.questionDto;
import survey.entity.Echelle;
import survey.entity.Enquete;
import survey.entity.Parametre;
import survey.entity.Question;
import survey.entity.Script;
import survey.entity.UserDigital;

@Service
public class EnqueteService implements IEnqueteService {
	
	private static final Logger logger = LogManager.getLogger(EnqueteService.class);
	
	
	@Autowired
	EnqueteDao enqueteDao;
	
	@Autowired
	ScriptDao ScriptDao;
	
	
	@Autowired
	QuestionService QuestionService;
	
	@Autowired
	EchelleService EchelleService;
	
	@Autowired
	UserService userService;


	@Override
	public Enquete addEnquete(Enquete e, int id) {
		UserDigital u=userService.findUserByMail(SecurityContextHolder.getContext().getAuthentication().getName());
		Script s = ScriptDao.findById(id).get();
		if(s.getStartDate().before(e.getStartDate()))
		{
		e.setStatus("NEW");
		e.setScript(s);
		e.setUser(u);
		enqueteDao.save(e);
		}
		return e;
	}

	@Override
	public List<Enquete> getAll() {
	
		List<Enquete> list = new ArrayList<Enquete>();
		List<Enquete> enquetes= enqueteDao.findAll();
		Date d = new Date(System.currentTimeMillis());
		for(int i=0;i<enquetes.size();i++)
		{
			if(enquetes.get(i).getStartDate().after(d) && enquetes.get(i).getStatus()!= "RUNNING")
			{
				list.add(enquetes.get(i));
			}
		}
		 
		 return list;
	}

	@Override
	public List<Enquete> getAllbydate() {

		List<Enquete> enquete = enqueteDao.findAll();	
		List<Enquete> enquetes = new ArrayList<>();
		//Date d= new Date(System.currentTimeMillis()-24*60*60*1000);
		
		Date d= new Date(System.currentTimeMillis());
		

	for(int i=0; i<enquete.size();i++)
	{
		
		if( enquete.get(i).getStatus()!= "Started" && enquete.get(i).getStartDate().before(d) && enquete.get(i).getStartDate().before(enquete.get(i).getEndDate()) )
		{
		    //enquetee.setStatus(status.RUNNING);
			enquetes.add(enquete.get(i));
		}
	}
		return enquetes;
	}

	@Override
	public List<Enquete> getAllbyenddate() {
		List<Enquete> enquete = enqueteDao.findAll();	
		List<Enquete> enquetes = new ArrayList<>();
		///Date d= new Date(System.currentTimeMillis()-24*60*60*1000);
		Date d= new Date(System.currentTimeMillis());
	for(Enquete enquetee : enquete)
	{
		
		if(enquetee.getStatus().equals("STOPED") || enquetee.getEndDate().before(enquetee.getStartDate()) && enquetee.getStatus()!= "Started")
		{
		    enquetee.setStatus("RUNNING");
			enquetes.add(enquetee);
		}
	}


		return enquetes;
	}

	@Override
	public Enquete get(int id) {
		return enqueteDao.findById(id).get();
	}

	@Override
	public Boolean delete(int id) {
		enqueteDao.deleteById(id);
		return true;
	}


	@Override
	public Enquete update(Enquete e) {


		e.setStatus("ACTIVE");
		return enqueteDao.save(e);
	}

	@Override
	public Enquete findByStatus(String status) {

		return enqueteDao.findByStatus(status);
	}

	@Override
	public Enquete arrete(int id) {
	
		Enquete e = enqueteDao.findById(id).get();
		e.setStatus("STOPED");
		return enqueteDao.save(e);
	}

	@Override
	public List<questionDto> getlangtype(int id, String language) {
		
		//boolean existe=true;
		int j=0;
		List<String> listeParams = QuestionService.questionParams(id);
		List<Echelle> listechelles= EchelleService.getAll();

		List<questionDto> questionDtos = new ArrayList<questionDto>();
		List<Question> listequestions = QuestionService.getquestionsByScriptenqLang(id,language);

		for(int i=0; i<listequestions.size();i++)
			
		{
			Map<Integer, String> map = new HashMap<Integer,String>();
			List<String> answerCode = new ArrayList<String>();
			questionDto questionDto = new questionDto();
			questionDto.setQuestion(listequestions.get(i));

			for(j=0;j<listechelles.size();j++)
			{
		
				if(listequestions.get(i).getAnswerScale().getAnswerScale().equals(listechelles.get(j).getAnswerScale()))
				{
					questionDto.setAnswerScale(listequestions.get(i).getAnswerScale().getAnswerScale());
					if(language.equals("Arabe"))
					{
						map.put(listechelles.get(j).getAnswerCode(), listechelles.get(j).getCustomerAnswerAr());
					//answerCode.add(listechelles.get(j).getAnswerCode() + " , " + listechelles.get(j).getCustomerAnswerAr());
				
					}
					else if(language.equals("Français"))
					{
						map.put(listechelles.get(j).getAnswerCode(), listechelles.get(j).getCustomerAnswerFr());
					//answerCode.add(listechelles.get(j).getAnswerCode() + " , " + listechelles.get(j).getCustomerAnswerFr());
				
					}
					else
					{
						map.put(listechelles.get(j).getAnswerCode(), listechelles.get(j).getCustomerAnswerEng());
					//answerCode.add(listechelles.get(j).getAnswerCode() + " , " + listechelles.get(j).getCustomerAnswerEng());
					}
					questionDto.setAnswerCode(map);
				}
			}
		
			questionDtos.add(questionDto);
		}
		

		return questionDtos;
	}

	@Override
	public List<Enquete> getenquetesByUser() {
		List<Enquete> list = new ArrayList<Enquete>();
		List<Enquete> listfinale = new ArrayList<Enquete>();
		List<Enquete> enquetes= enqueteDao.findAll();
		Date d = new Date(System.currentTimeMillis());
		UserDigital u=userService.findUserByMail(SecurityContextHolder.getContext().getAuthentication().getName());
		for(int i=0;i<enquetes.size();i++)
		{
			
			if(enquetes.get(i).getUser().getId().equals(u.getId()) )
			{
				list.add(enquetes.get(i));
			}
		}
		
		for(int i=0; i<list.size();i++)
		{
			if(list.get(i).getStartDate().after(d) && list.get(i).getStatus()!= "RUNNING" && enquetes.get(i).getStatus()!= "Started")
			{
				listfinale.add(list.get(i));
			}
		}
		 
		 return listfinale;
	}

	@Override
	public List<Enquete> getAllbydateUser() {
		List<Enquete> enquete = enqueteDao.findAll();	
		List<Enquete> listfinale = new ArrayList<Enquete>();
		List<Enquete> enquetes = new ArrayList<>();
		UserDigital u=userService.findUserByMail(SecurityContextHolder.getContext().getAuthentication().getName());
		///Date d= new Date(System.currentTimeMillis()-24*60*60*1000);
		Date d= new Date(System.currentTimeMillis());
	for(Enquete enquetee : enquete)
	{
		
		if(enquetee.getUser().getId().equals(u.getId())  )
		{
		 
			enquetes.add(enquetee);
		}
	}


	for(int i=0; i<enquetes.size();i++)
	{
		if(enquetes.get(i).getStartDate().before(d) && enquetes.get(i).getStartDate().before(enquetes.get(i).getEndDate()) && enquetes.get(i).getStatus()!= "STOPED" && enquetes.get(i).getStatus()!= "Started")
		{
		
			listfinale.add(enquetes.get(i));
		}
	}
	 
	 return listfinale;
	}
	
	
	//resurvey

	@Override
	public List<Enquete> getAllbyenddateresurvey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enquete> getAllNNresurvey() {
		return enqueteDao.FindNotNull();
	}

	@Override
	public List<Enquete> getAllresurvey() {
		List<Enquete> list = new ArrayList<Enquete>();
		List<Enquete> enquetes= enqueteDao.findAll();
		for(int  i=0; i<enquetes.size();i++)
		{
			if(enquetes.get(i).getStatus().equals("Started"))
			{
				list.add(enquetes.get(i));
			}
		}

		
		 return list;
	}

	@Override
	public List<Enquete> getAllDDresurvey(Date d1, Date d2) {
		return enqueteDao.FindDate(d1,d2);
	}

	

}
