import data.GetToken;
import data.ParseJSON;
import data.Urls;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class UpdateBooking {
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
    public void updateBookingValid() throws FileNotFoundException {
        String token = GetToken.creteToken();

        given().header("Cookie", "token=" + token).
        when().
            body(ParseJSON.getDataObject(ParseJSON.TEST_JSON)).
            contentType(ContentType.JSON).
            put(Urls.BASE + Urls.BOOKING + "/2").
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON);
    }
}
