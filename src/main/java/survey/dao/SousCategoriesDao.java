package survey.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import survey.entity.SousCategories;

@Repository
public interface SousCategoriesDao  extends JpaRepository<SousCategories, Long>  {

}
