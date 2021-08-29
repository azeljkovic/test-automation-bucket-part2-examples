package data;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ParseJSON {
    public static final String TEST_JSON = "src/test/java/data/JSON/test.json";
    public static final String VALID_CREDENTIALS_JSON = "src/test/java/data/JSON/validCredentials.json";
    public static final String INVALID_CREDENTIALS_JSON = "src/test/java/data/JSON/invalidCredentials.json";

    public static Object getDataObject(String file) throws FileNotFoundException {
        Gson gson = new Gson();
        Object userObject = gson.fromJson(new FileReader(file), Object.class);

        return userObject;
    }
}
