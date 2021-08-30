import data.GetToken;
import data.ParseJSON;
import data.Urls;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class DeleteBooking {
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
    public void deleteBookingValid() throws FileNotFoundException {
        String token = GetToken.creteToken();

        given().header("Cookie", "token=" + token).
        when().
            delete(Urls.BASE + Urls.BOOKING + "/5").
        then().
            assertThat().
                statusCode(201).
                contentType(ContentType.TEXT);
    }

    @Test
    public void updateNonexistentBooking() throws FileNotFoundException {
        String token = GetToken.creteToken();

        given().header("Cookie", "token=" + token).
        when().
            delete(Urls.BASE + Urls.BOOKING + "/109").
        then().
            assertThat().
                statusCode(405).
                contentType(ContentType.TEXT);
    }

    @Test
    public void updateBookingInvalidToken() throws FileNotFoundException {
        given().header("Cookie", "token=invalid").
        when().
            delete(Urls.BASE + Urls.BOOKING + "/2").
        then().
            assertThat().
                statusCode(403).
                contentType(ContentType.TEXT);
    }
}
