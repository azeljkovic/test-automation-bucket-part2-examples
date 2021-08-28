import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import data.urls;
import data.dataCreateBooking;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;

public class createBooking {
    @BeforeAll
    public static void checkApiAvailibility(){
        given().
                when().
                get(urls.base + urls.ping).
                then().
                assertThat().
                statusCode(201);
    }

    @Test
    public void createBookingEmptyBody() {
        given().
        when().
            body("").
            contentType(ContentType.JSON).
            post(urls.base + urls.booking).
        then().
            assertThat().
                statusCode(400).
                contentType(ContentType.JSON);
    }

    @Test
    public void createBookingValid() throws FileNotFoundException {
        Gson gson = new Gson();
        Object object = gson.fromJson(new FileReader("src/test/java/data/test.json"), Object.class);

        given().
        when().
            body(object).
            contentType(ContentType.JSON).
            post(urls.base + urls.booking).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON);
    }
}
