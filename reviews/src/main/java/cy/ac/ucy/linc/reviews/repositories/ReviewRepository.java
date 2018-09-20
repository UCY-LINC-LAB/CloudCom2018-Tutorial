package cy.ac.ucy.linc.reviews.repositories;

import cy.ac.ucy.linc.reviews.dao.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
