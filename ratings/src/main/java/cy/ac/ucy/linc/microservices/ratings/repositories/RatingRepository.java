package cy.ac.ucy.linc.microservices.ratings.repositories;

import cy.ac.ucy.linc.microservices.ratings.dao.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Integer> {

}
