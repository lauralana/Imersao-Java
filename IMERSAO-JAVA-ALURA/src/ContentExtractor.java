import java.util.List;


// abstração das classes
public interface ContentExtractor {
    List<Content> extractor(String JSON);
}
