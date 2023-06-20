package survey.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RejetID implements Serializable{
	
	@Column(name="ENQ_ID")
	private int enquete;
	
	@Column(name="MSISDN")
	private String msisdn;

	public int getEnquete() {
		return enquete;
	}

	public void setEnquete(int enquete) {
		this.enquete = enquete;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public RejetID(int enquete, String msisdn) {
		this.enquete = enquete;
		this.msisdn = msisdn;
	}

	public RejetID() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + enquete;
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RejetID other = (RejetID) obj;
		if (enquete != other.enquete)
			return false;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		return true;
	}
	
	
	

}
