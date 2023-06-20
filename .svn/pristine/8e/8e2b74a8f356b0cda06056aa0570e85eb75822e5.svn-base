package survey.service;

import java.util.List;

import survey.dto.responseDto;
import survey.entity.ResponseDigital;

public interface IResponseDigitalService {
	
	public ResponseDigital addResponseDigital(ResponseDigital r, int id, String email);
	public List<ResponseDigital> addResponses(List<responseDto> r, int id, String email, String language);
	public List<ResponseDigital> addResponsesSponSurvey(List<responseDto> r, int id, String language);
	public ResponseDigital update(ResponseDigital u);
	public List<ResponseDigital> getAll();
	public ResponseDigital get(int id);
	public Boolean delete(int id);
	public int responseNumber(int id);
	public Boolean answered(int id, String email, String language);
	public int avgResponse(int id);

}
