package cy.ac.ucy.linc.microservices.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BooksApp {

    public static void main(String[] args) {
        SpringApplication.run(BooksApp.class, args);
    }
}
