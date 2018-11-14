package cy.ac.ucy.linc.microservices.ratings.repositories;

import cy.ac.ucy.linc.microservices.ratings.dao.Rating;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RatingRepository extends CrudRepository<Rating, Integer> {
    List<Rating> findRatingsByBookid(Long bookId);
}
