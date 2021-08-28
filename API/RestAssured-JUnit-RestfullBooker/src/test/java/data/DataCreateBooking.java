package data;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataCreateBooking {
    static final String TEST_JSON_PATH = "src/test/java/data/test.json";

    public Object getDataObject() throws FileNotFoundException {
        Gson gson = new Gson();
        Object userObject = gson.fromJson(new FileReader(TEST_JSON_PATH), Object.class);

        return userObject;
    }
}
