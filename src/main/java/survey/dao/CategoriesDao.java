package survey.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import survey.entity.Categories;



@Repository
public interface CategoriesDao  extends JpaRepository<Categories, Long> {

}
