package cy.ac.ucy.linc.microservices.ratings.controller;

import cy.ac.ucy.linc.microservices.ratings.dao.Rating;
import cy.ac.ucy.linc.microservices.ratings.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping(value = "", produces = "application/json")
    public Iterable<Rating> getAllRatings(){
        return ratingRepository.findAll();
    }
}
