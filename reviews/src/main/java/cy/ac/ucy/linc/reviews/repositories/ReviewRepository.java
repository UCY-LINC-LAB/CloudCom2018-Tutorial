package cy.ac.ucy.linc.reviews.repositories;

import cy.ac.ucy.linc.reviews.dao.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
    List<Review> findReviewByBookid(Long bookId);
    Review findReviewById(Long reviewId);
}
