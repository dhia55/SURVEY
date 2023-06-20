package survey.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import survey.entity.users.TypeDigital;

@Repository
public interface TypeDigitalDao    extends JpaRepository<TypeDigital, Integer> {

}
