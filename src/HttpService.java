import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;


public class HttpService {
    public String getData(String URL) {
        
        try {
            var adress = URI.create(URL);
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(adress).GET().build();
            var response = client.send(request, BodyHandlers.ofString());
            String info = response.body();
            return info;

        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
