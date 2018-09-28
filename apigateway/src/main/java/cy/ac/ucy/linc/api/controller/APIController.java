package cy.ac.ucy.linc.api.controller;


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
        URL url = new URL("http://google.com");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        return in.lines().collect(Collectors.joining(System.lineSeparator()));
    }
}
