package survey.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import survey.entity.User;
import survey.entity.UserDigital;

@Repository
public interface UserDigitalDao  extends JpaRepository<UserDigital, Long> {

	@Query("Select "
			+ "u from UserDigital u "
			+ "where u.fullName=:fullName")
	public UserDigital findByfullname(String fullName);

	
	@Query("Select "
			+ "u from UserDigital u "
			+ "where u.mail=:mail")
	public UserDigital findByMail(String mail);
	



	  @Query("Select "
				+ "u from UserDigital u "
				+ "where u.resetToken=:token")
	public UserDigital findByResetToken(String token);

}
