package survey.service;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.web.multipart.MultipartFile;

import survey.entity.DigitalTarget;
import survey.entity.Enquete;



public interface IDigitalTargetService {
	
	public DigitalTarget adddigitalTarget(DigitalTarget t, int id);
	public List<DigitalTarget> getAll();
	public List<DigitalTarget> getAllByUser();
	public DigitalTarget get(int id);
	Boolean deleteDigital(DigitalTarget t);
	public void sendtargets(int id, String language) throws MessagingException;
	public void sendbyemail(int id) throws MessagingException;
	public String generateLink(int id); 
	public String generateLinkLang(int id,String language); 
	//public void sendbywhatss(int id);
	public List<DigitalTarget> getAllbefore(MultipartFile file) throws IOException;
	public void save(MultipartFile file,int id) ;
	public String decodedUrl(String encodedUrl);
	public String encodedUrl(int id, String lang);
	public int targetNumber(int id);
	public DigitalTarget gettargetByenqId(int id);
	public DigitalTarget update(DigitalTarget t);

}
