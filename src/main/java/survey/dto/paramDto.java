package survey.dto;

public class paramDto {

	private String paramMeaning;

	public String getParamMeaning() {
		return paramMeaning;
	}

	public void setParamMeaning(String paramMeaning) {
		this.paramMeaning = paramMeaning;
	}

	public paramDto(String paramMeaning) {
		super();
		this.paramMeaning = paramMeaning;
	}

	@Override
	public String toString() {
		return "paramDto [paramMeaning=" + paramMeaning + "]";
	}

	public paramDto() {
		super();
	}
	
	
}
