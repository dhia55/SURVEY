package survey.service;

import java.util.List;

import javax.mail.MessagingException;

import survey.dto.questionDto;
import survey.entity.Enquete;
import java.util.Date;

public interface IEnqueteService {
	
	public Enquete addEnquete(Enquete e,int id);
	public List<Enquete> getAll();
	public List<Enquete> getAllbydate();
	public List<Enquete> getAllbyenddate();
	public List<Enquete> getenquetesByUser();
	public List<Enquete> getAllbydateUser();
	public Enquete get(int id);
	public Boolean delete(int id);
	public Enquete update(Enquete e);
	public Enquete findByStatus(String status);
	public Enquete arrete(int id);
	public List<questionDto> getlangtype(int id, String language);
	
	//resurvey
	public List<Enquete> getAllbyenddateresurvey();
	public List<Enquete> getAllNNresurvey();
	public List<Enquete> getAllresurvey();
	public List<Enquete> getAllDDresurvey(Date d1,Date d2);
}
