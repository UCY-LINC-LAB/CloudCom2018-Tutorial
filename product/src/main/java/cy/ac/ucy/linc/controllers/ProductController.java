package cy.ac.ucy.linc.controllers;

import io.swagger.annotations.Api;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
@Api
public class ProductController {

    @CrossOrigin
    @GetMapping("/products")
    public String products(Model model){
//        try {
//
//            CloseableHttpClient httpClient = HttpClients.createDefault();
//
//            HttpGet httpGet = new HttpGet("apigateway.localhost/api/v1/all");
//
//            ResponseHandler<String> handler = new ResponseHandler<String>() {
//                @Override
//                public String handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
//                    HttpEntity entity = httpResponse.getEntity();
//                    return entity!=null? EntityUtils.toString(entity) : null;
//                }
//            };
//
//
//            String resBody = httpClient.execute(httpGet, handler);
//            model.addAttribute("books", resBody);
//            return "products.html";
//        } catch (IOException e) {
//            e.printStackTrace();
//            model.addAttribute("books", "Hello World");
//            return "products.html";
//        }

        return "products.html";



    }
}
