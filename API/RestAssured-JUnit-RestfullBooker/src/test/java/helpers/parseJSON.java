package helpers;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class parseJSON {
    public static String URL_JSON = "src/test/java/data/urls.json";

    public static String getValue(String param) {
        String name = "";
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader(URL_JSON)) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            name = (String) jsonObject.get(param);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return name;
    }

    public static String getWholeBody() {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = new JSONObject();

        try (Reader reader = new FileReader("src/test/java/data/test.json")) {

            jsonObject = (JSONObject) parser.parse(reader);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        //return jsonObject;
        //String jo=jsonObject.toString();
        String jo = String.valueOf(jsonObject);
        return jo;
    }
}
