package cy.ac.ucy.linc.api.controller;


import cy.ac.ucy.linc.api.utilities.GetRequestConc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1")
public class APIController {

    private static final Stream<String> endp = Stream.of("http://review.localhost/reviews", "http://rating.localhost/ratings", "http://book.localhost/books"); // , "http://product.localhost", "http://rating.localhost");
    private static final List<String> endpoints =  endp.collect(Collectors.toList());


    @GetMapping(value = "/all", produces = "application/json")
    public String getProductsCombinedAll() throws IOException, ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        GetRequestConc callable = new GetRequestConc(endpoints.get(0));

        Future<String> futureTask = executorService.submit(callable);

        List<Future<String>> futureTasks = new ArrayList<>();
        for (String endpoint : endpoints){
            futureTasks.add(executorService.submit(new GetRequestConc(endpoint)));
        }

        return futureTasks.get(2).get();
    }


}

