package cy.ac.ucy.linc.microservices.ratings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RatingsApp {
    public static void main(String[] args) {
        SpringApplication.run(RatingsApp.class, args);
    }
}
