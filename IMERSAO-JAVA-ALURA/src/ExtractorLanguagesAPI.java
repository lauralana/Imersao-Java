import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractorLanguagesAPI implements ContentExtractor {
    public List<Content> extractor(String JSON) {
        // extrair dados
        var parser = new JsonParser();
        List<Map<String, String>> data = parser.parse(JSON);
    
        List<Content> objList = new ArrayList<>();
        // popular a lista
            for(Map<String, String> attributes: data) {
    
            String title = attributes.get("title");
            String urlImg = attributes.get("image");
            // int ranking = attributes.get("imDbRating");
            var obj = new Content(title, urlImg);
    
            objList.add(obj);
            }   
        return objList;
        }
}
