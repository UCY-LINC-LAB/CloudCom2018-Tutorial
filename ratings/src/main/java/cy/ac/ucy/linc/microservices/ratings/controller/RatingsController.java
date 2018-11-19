package cy.ac.ucy.linc.microservices.ratings.controller;

import cy.ac.ucy.linc.microservices.ratings.model.Rating;
import cy.ac.ucy.linc.microservices.ratings.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/ratings")
public class RatingsController {

    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping(value = "", produces = "application/json")
    public Iterable<Rating> getAllRatings(){
        return ratingRepository.findAll();
    }

    @GetMapping(value = "/book/{bookId}", produces = "application/json")
    public List<Rating> getBookRatings(@PathVariable Long bookId){
        return ratingRepository.findRatingsByBookid(bookId);
    }
}
