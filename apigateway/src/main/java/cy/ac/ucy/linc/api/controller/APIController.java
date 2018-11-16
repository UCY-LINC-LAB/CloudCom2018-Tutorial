package cy.ac.ucy.linc.api.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cy.ac.ucy.linc.api.entities.Book;
import cy.ac.ucy.linc.api.entities.Product;
import cy.ac.ucy.linc.api.entities.Rating;
import cy.ac.ucy.linc.api.entities.Review;
import cy.ac.ucy.linc.api.utilities.GetRequestConc;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class APIController {

    private static final Stream<String> endp = Stream.of("http://book.localhost/books", "http://review.localhost/reviews", "http://rating.localhost/ratings"); // , "http://product.localhost", "http://rating.localhost");
    private static final List<String> endpoints =  endp.collect(Collectors.toList());
    private static final Stream<String> productendp = Stream.of("http://book.localhost/books/book", "http://review.localhost/reviews/book", "http://rating.localhost/ratings/book");
    private static final List<String> prendpoints =  productendp.collect(Collectors.toList());


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

    @CrossOrigin
    @GetMapping(value = "/product/{pid}", produces = "application/json")
    public String getProductCombined(@PathVariable Long pid) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Book> books = new ArrayList<>();

        List<Future<String>> futureTasks = new ArrayList<>();
        for (String endpoint : prendpoints){
            futureTasks.add(executorService.submit(new GetRequestConc(endpoint+"/"+pid.toString())));
        }

        Book book = new GsonBuilder().create().fromJson(futureTasks.get(0).get(), Book.class);
        Rating[] ratings = new GsonBuilder().create().fromJson(futureTasks.get(2).get(), Rating[].class);
        Review[] reviews = new GsonBuilder().create().fromJson(futureTasks.get(1).get(), Review[].class);
        List<Product> products = new ArrayList<>();
        List<Review> bookReviews = new ArrayList<>();
        List<Rating> bookRatings = new ArrayList<>();


        for (Review review : reviews){
           bookReviews.add(review);
        }

        for (Rating rating: ratings){
            bookRatings.add(rating);
        }

        products.add(new Product(book, bookRatings, bookReviews));

        String retProducts = new Gson().toJson(products);

        return retProducts;
    }


}

