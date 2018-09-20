package cy.ac.ucy.linc.reviews.controllers;

import cy.ac.ucy.linc.reviews.dao.Review;
import cy.ac.ucy.linc.reviews.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewsController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping(value = "/reviews", produces = "application/json")
    public Iterable<Review> getallreviews(){
        return reviewRepository.findAll();
    }


}
