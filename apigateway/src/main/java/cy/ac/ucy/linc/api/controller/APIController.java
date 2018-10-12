package cy.ac.ucy.linc.api.controller;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class APIController {

    @GetMapping("/all")
    public String getProductsCombinedAll() throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("http://review.localhost:38082/reviews");

        ResponseHandler<String> handler = new ResponseHandler<String>() {
            @Override
            public String handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
                HttpEntity entity = httpResponse.getEntity();
                return entity!=null? EntityUtils.toString(entity) : null;
            }
        };


        String resBody = httpClient.execute(httpGet, handler);
        return resBody;

//
//        URL url = new URL("http://review.localhost/reviews");
//        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//        urlConnection.setRequestMethod("GET");
//        urlConnection.setInstanceFollowRedirects(false);
//        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//        return in.lines().collect(Collectors.joining(System.lineSeparator()));
    }


}
