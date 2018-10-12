package cy.ac.ucy.linc.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class APIGateway {

    public static void main(String[] args) {
        SpringApplication.run(APIGateway.class, args);
    }
}
