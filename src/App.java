import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // 1 PASSO : conexão HTTP 
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpRequest.html
        String URL = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json"
        var adress = URI.create(URL);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(adress).GET().build();
        var response = client.send(request, BodyHandlers.ofString());
        String info = response.body();
        // System.out.println(info); visualizar o JSON no terminal
        
        // 2 PASSO : extração dos dados 
        var JSON = new JsonParser();
        List<Map<String, String>> movieList = JSON.parse(info);
        // System.out.println(movieList.size());
        // System.out.println(movieList.get(0));

        // 3 PASSO : exibir e manipular os dados
        for (Map<String, String> movie: movieList) {
            System.out.println(movie.get(key: "title"));
            System.out.println(movie.get(key: "year"));
            System.out.println(movie.get(key: "image"));
            System.out.println(movie.get(key: "imDbRating"));
            System.out.println();
        }
    }
}
