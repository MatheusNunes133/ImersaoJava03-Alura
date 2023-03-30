package org.codigo.refatorando.ClientHttp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientHttp {

    public String dataFinder(String url)  {

        try {
            var client = HttpClient.newHttpClient();
            var httpRequest = HttpRequest.newBuilder(URI.create(url)).GET().build();

            HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            return httpResponse.body();

        }catch (IOException | InterruptedException exception){
            throw new RuntimeException(exception);
        }

    }
}
