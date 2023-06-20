package survey.dto;

import java.util.Date;

import javax.persistence.Column;

public class responseDto {
	private String response;
	
	private int ordre;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public responseDto(String response, int ordre) {
		super();
		this.response = response;
		this.ordre = ordre;
	}

	public responseDto() {
		super();
	}

	@Override
	public String toString() {
		return "responseDto [response=" + response + ", ordre=" + ordre + "]";
	}
	
	
}
