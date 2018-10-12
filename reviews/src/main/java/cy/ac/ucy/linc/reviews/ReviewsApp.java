package cy.ac.ucy.linc.reviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ReviewsApp {

    public static void main(String[] args) {
        SpringApplication.run(ReviewsApp.class, args);
    }
}
