package cy.ac.ucy.linc.api.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cy.ac.ucy.linc.api.entities.Book;
import cy.ac.ucy.linc.api.entities.Product;
import cy.ac.ucy.linc.api.entities.Rating;
import cy.ac.ucy.linc.api.entities.Review;
import cy.ac.ucy.linc.api.utilities.GetRequestConc;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1")
public class APIController {

    private static final Stream<String> endp = Stream.of("http://book.localhost/books", "http://review.localhost/reviews", "http://rating.localhost/ratings"); // , "http://product.localhost", "http://rating.localhost");
    private static final List<String> endpoints =  endp.collect(Collectors.toList());


    @CrossOrigin
    @GetMapping(value = "/all", produces = "application/json")
    public String getProductsCombinedAll() throws IOException, ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Future<String>> futureTasks = new ArrayList<>();
        for (String endpoint : endpoints){
            futureTasks.add(executorService.submit(new GetRequestConc(endpoint)));
        }

        Book[] books = new GsonBuilder().create().fromJson(futureTasks.get(0).get(), Book[].class);
        Rating[] ratings = new GsonBuilder().create().fromJson(futureTasks.get(2).get(), Rating[].class);
        Review[] reviews = new GsonBuilder().create().fromJson(futureTasks.get(1).get(), Review[].class);
        List<Product> products = new ArrayList<>();

        for (Book book: books){
            List<Rating> bookRatings = new ArrayList<>();
            List<Review> bookReviews = new ArrayList<>();
            for (Rating rating: ratings){
                if (rating.getBookid() == book.getId()){
                    bookRatings.add(rating);
                }
            }
            for (Review review : reviews){
                if (review.getBookid().equals(book.getId())){
                    bookReviews.add(review);
                }
            }
            products.add(new Product(book, bookRatings, bookReviews));
        }

        String retProducts = new Gson().toJson(products);


        return retProducts;
    }


}

