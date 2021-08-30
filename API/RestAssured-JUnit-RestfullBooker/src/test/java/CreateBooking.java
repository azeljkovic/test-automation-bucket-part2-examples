import data.Urls;
import data.ParseJSON;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class CreateBooking {
    @BeforeAll
    public static void checkApiAvailibility(){
        given().
        when().
            get(Urls.BASE + Urls.PING).
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
            post(Urls.BASE + Urls.BOOKING).
        then().
            assertThat().
                statusCode(400).
                contentType(ContentType.JSON);
    }

    @Test
    public void createBookingValid() throws FileNotFoundException {
        given().
        when().
            body(ParseJSON.getDataObject(ParseJSON.VALID_BOOKING_JSON)).
            contentType(ContentType.JSON).
            post(Urls.BASE + Urls.BOOKING).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON);
    }
}
