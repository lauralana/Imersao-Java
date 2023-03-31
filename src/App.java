import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {

        String URL = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        // String URL = "https://api.nasa.gov/planetary/apod?api_key=7xosTbVTt7D2bhllRmlOXic9kqEam9cftZvl1AfT&start_date=2022-06-12&end_date=2022-06-14";
  
        var http = new HttpService();
        String JSON = http.getData(URL);
        
        // ContentExtractor extract = new ExtractorNasaAPI();
        // List<Content> objList = extract.extractor(JSON);

        ContentExtractor extract = new ExtractorAluraAPI();
        List<Content> objList = extract.extractor(JSON);

        for (int i = 0; i < 3; i ++ ) {
            Content obj = objList.get(i);

            InputStream input = new URL(obj.getUrlImg()).openStream();
            String archive = "return/" + obj.getTitle() + ".png";

            var generate = new StickerGenerate();
            generate.edited(input, archive);

            System.out.println(obj.getTitle());
            System.out.println(obj.getUrlImg());
            
            var rating = Double.parseDouble(obj.getStar());
            int starNumber = (int) rating;
            for(int n = 1; n <= starNumber; n ++){
                System.out.print("🌟");
            }
            System.out.println("\n");
            System.out.println();
        }
    }
}
