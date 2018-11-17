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
import java.util.concurrent.*;
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

        Book[] books = new Book[0];
        try {
            books = new GsonBuilder().create()
                                     .fromJson(futureTasks.get(0).get(1, TimeUnit.SECONDS), Book[].class);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        Rating[] ratings = new Rating[0];
        try {
            ratings = new GsonBuilder().create()
                    .fromJson(futureTasks.get(2).get(1, TimeUnit.SECONDS), Rating[].class);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        Review[] reviews = new Review[0];
        try {

            reviews = new GsonBuilder().create()
                    .fromJson(futureTasks.get(1).get(1, TimeUnit.SECONDS), Review[].class);


        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        List<Product> products = new ArrayList<>();

        for (Book book: books){
            List<Rating> bookRatings = new ArrayList<>();
            List<Review> bookReviews = new ArrayList<>();

            if (ratings != null) {
                for (Rating rating: ratings){
                    if (rating.getBookid() == book.getId()){
                        bookRatings.add(rating);
                    }
                }
            }

            if (reviews != null){

                for (Review review : reviews){
                    if (review.getBookid().equals(book.getId())){
                        bookReviews.add(review);
                    }
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

        Book book = null;
        try {
            book = new GsonBuilder().create().fromJson(futureTasks.get(0).get(3, TimeUnit.SECONDS), Book.class);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        Rating[] ratings = new Rating[0];
        try {
            ratings = new GsonBuilder().create().fromJson(futureTasks.get(2).get(3, TimeUnit.SECONDS), Rating[].class);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        Review[] reviews = new Review[0];
        try {
            reviews = new GsonBuilder().create().fromJson(futureTasks.get(1).get(3, TimeUnit.SECONDS), Review[].class);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
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

