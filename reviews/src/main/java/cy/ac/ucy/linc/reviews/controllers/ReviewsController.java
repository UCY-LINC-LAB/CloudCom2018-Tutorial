package cy.ac.ucy.linc.reviews.controllers;

import cy.ac.ucy.linc.reviews.dao.Review;
import cy.ac.ucy.linc.reviews.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/reviews")
public class ReviewsController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping(value = "", produces = "application/json")
    public Iterable<Review> getallreviews(){
        return reviewRepository.findAll();
    }

    @GetMapping(value = "/{reviewId}", produces = "application/json")
    public Review getReview(@PathVariable Long reviewId){
        return reviewRepository.findReviewById(reviewId);
    }

    @GetMapping(value = "/book/{bookId}", produces = "application/json")
    public List<Review> getBookReview(@PathVariable Long bookId){
        return reviewRepository.findReviewByBookid(bookId);
    }


}
