package cy.ac.ucy.linc.api.entities;

import java.util.List;

public class Product {

    private Book book;

    private List<Rating> ratings;

    private List<Review> reviews;


    public Product(Book book, List<Rating> ratings, List<Review> reviews) {
        this.book = book;
        this.ratings = ratings;
        this.reviews = reviews;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
