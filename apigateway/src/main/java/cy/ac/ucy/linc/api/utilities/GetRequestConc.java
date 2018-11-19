package cy.ac.ucy.linc.api.utilities;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.Callable;

public class GetRequestConc implements Callable<String> {

    private final String url;


    public GetRequestConc(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }



    @Override
    public String call() throws Exception {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(getUrl());

        ResponseHandler<String> handler = new ResponseHandler<String>() {
            @Override
            public String handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
                HttpEntity entity = httpResponse.getEntity();
                if (httpResponse.getStatusLine().getStatusCode()==404){
                    return new String("");
                }
                return entity!=null? EntityUtils.toString(entity) : null;
            }
        };

        String resBody = httpClient.execute(httpGet, handler);


//        JSONArray reviewJSON = new JSONArray(resBody);
//        return reviewJSON.toList();

        return resBody;
    }
}
