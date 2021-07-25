package helpers;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class parseJSON {
    public static String JSON_PATH = "src/test/java/data/urls.json";

    public static String getValue(String param) {
        String name = "";
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader(JSON_PATH)) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            name = (String) jsonObject.get(param);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return name;
    }
}
