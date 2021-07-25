import helpers.parseJSON;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class getBookings {
    public static String BASE_URL = parseJSON.getValue("baseURL");
    public static String GET_BOOKINGS = parseJSON.getValue("getBookings");


    @Test
    public void getAllBookings() {
        given().
        when().
            get(BASE_URL + GET_BOOKINGS).
        then().
            assertThat().
            statusCode(200).contentType(ContentType.JSON).
            log().body();


    }

}
