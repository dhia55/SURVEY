package survey.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import survey.entity.users.RoleDigital;

@Repository
public interface RoleDigitalDao extends JpaRepository<RoleDigital, Integer>{

}
