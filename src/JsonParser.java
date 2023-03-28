import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {
    // https://regex101.com/
    private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)\\].*");
    private static final Pattern REGEX_ATRIBUTOS_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");

    public List<Map<String, String>> parse(String json){
        var matcher = REGEX_ITEMS.matcher(json);
        if (!matcher.find()) {

            throw new IllegalArgumentException("Items not found.");
        }

        String[] values = matcher.group(1).split("\\},\\{");

        List<Map<String, String>> data = new ArrayList<>();

        for (String key : values) {

            Map<String, String> attributesItem = new HashMap<>();

            Matcher matcherAttributesJson = REGEX_ATRIBUTOS_JSON.matcher(key);
            while (matcherAttributesJson.find()) {
                String attribute = matcherAttributesJson.group(1);
                String value = matcherAttributesJson.group(2);
                attributesItem.put(attribute, value);
            }

            data.add(attributesItem);
        }

        return data;
    }
    
}