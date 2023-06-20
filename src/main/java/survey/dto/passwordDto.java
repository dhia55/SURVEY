package survey.dto;

public class passwordDto {

	
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public passwordDto(String password) {
		super();
		this.password = password;
	}

	@Override
	public String toString() {
		return "passwordDto [password=" + password + "]";
	}
	
	
}
