package survey.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import survey.entity.users.User;


@Repository
public interface UserDao   extends JpaRepository<User, Long> {
	
	@Query("Select "
			+ "u from User u "
			+ "where u.fullName=:fullName")
	public User findByfullname(String fullName);

	
	@Query("Select "
			+ "u from User u "
			+ "where u.mail=:mail")
	public User findByMail(String mail);


}
