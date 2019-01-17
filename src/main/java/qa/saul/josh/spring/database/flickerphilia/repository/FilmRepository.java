package qa.saul.josh.spring.database.flickerphilia.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qa.saul.josh.spring.database.flickerphilia.model.FilmDataModel;

@Repository
public interface FilmRepository extends JpaRepository<FilmDataModel,Long> {
	List<FilmDataModel> findByTitle(String title);
	List<FilmDataModel> findByCategory(String category);
	List<FilmDataModel> findByRating(String rating);
	List<FilmDataModel> findByActors(String actors);

}
