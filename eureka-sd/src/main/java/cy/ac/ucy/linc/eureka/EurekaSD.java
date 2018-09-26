package cy.ac.ucy.linc.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaSD {
    public static void main(String[] args) {
        SpringApplication.run(EurekaSD.class, args);
    }
}
