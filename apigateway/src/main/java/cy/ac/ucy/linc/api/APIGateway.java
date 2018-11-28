package cy.ac.ucy.linc.api;


import cy.ac.ucy.linc.api.config.EndpointsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(EndpointsConfig.class)
public class APIGateway {
    public static void main(String[] args) {
        SpringApplication.run(APIGateway.class, args);
    }
}
