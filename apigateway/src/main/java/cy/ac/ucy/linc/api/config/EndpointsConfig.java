package cy.ac.ucy.linc.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "apigateway")
public class EndpointsConfig {

    private List<String> productsall = new ArrayList<>();
    private List<String> product = new ArrayList<>();

    public List<String> getProductsall() {
        return productsall;
    }

    public void setProductsall(List<String> productsall) {
        this.productsall = productsall;
    }

    public List<String> getProduct() {
        return product;
    }

    public void setProduct(List<String> product) {
        this.product = product;
    }
}
