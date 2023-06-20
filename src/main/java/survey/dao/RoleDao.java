package survey.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import survey.entity.Role;


@Repository
public interface RoleDao extends JpaRepository<Role, Integer>  {

}
