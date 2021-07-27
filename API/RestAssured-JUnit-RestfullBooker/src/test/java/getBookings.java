import helpers.parseJSON;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class getBookings {
    public static String BASE_URL = parseJSON.getValue("baseURL");
    public static String GET_BOOKINGS = parseJSON.getValue("getBookings");

    public static String FIRST_NAME = parseJSON.getValue("firstname");


    @Test
    public void getAllBookings() {
        given().
        when().
            get(BASE_URL + GET_BOOKINGS).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
            log().body();
    }

    @Test
    public void getBookingByID() {
        given().
                // param("firstname", "Mark").
        when().
            get(BASE_URL + GET_BOOKINGS + "/1").
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo("Eric")).
                 body(equalTo(parseJSON.getWholeBody())).

            log().body();
    }

}
