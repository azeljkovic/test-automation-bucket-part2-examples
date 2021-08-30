import data.GetToken;
import data.ParseJSON;
import data.Urls;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class PartialUpdateBooking {
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
    public void partialUpdateBookingValid() throws FileNotFoundException {
        String token = GetToken.creteToken();

        given().header("Cookie", "token=" + token).
        when().
            body(ParseJSON.getDataObject(ParseJSON.PARTIAL_UPDATE_BOOKING_JSON)).
            contentType(ContentType.JSON).
            patch(Urls.BASE + Urls.BOOKING + "/2").
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON);
    }

    @Test
    public void partialUpdateBookingEmptyBody() throws FileNotFoundException {
        String token = GetToken.creteToken();

        given().header("Cookie", "token=" + token).
        when().
            body("").
            contentType(ContentType.JSON).
            patch(Urls.BASE + Urls.BOOKING + "/2").
        then().
            assertThat().
                statusCode(400).
                contentType(ContentType.TEXT);
    }

    @Test
    public void partialUpdateBookingInvalidToken() throws FileNotFoundException {
        given().header("Cookie", "token=invalid").
        when().
            body(ParseJSON.getDataObject(ParseJSON.PARTIAL_UPDATE_BOOKING_JSON)).
            contentType(ContentType.JSON).
            patch(Urls.BASE + Urls.BOOKING + "/2").
        then().
            assertThat().
                statusCode(403).
                contentType(ContentType.TEXT);
    }
}
