import data.dataGetBookingIDs;
import data.urls;
import data.dataGetBooking;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getBooking {
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
    public void getBooking() {
        given().
        when().
            get(urls.base + urls.getBookingIDs + dataGetBooking.bookingID).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                //log().body();
                body("firstname", equalTo(dataGetBooking.firstname)).
                body("lastname", equalTo(dataGetBooking.lastname)).
                body("totalprice", equalTo(dataGetBooking.totalprice)).
                body("depositpaid", equalTo(dataGetBooking.depositpaid)).
                body("bookingdates.checkin", equalTo(dataGetBooking.checkin)).
                body("bookingdates.checkout", equalTo(dataGetBooking.checkout));
    }

    @Test
    public void getNonexistentBooking() {
        given().
        when().
            get(urls.base + urls.getBookingIDs + dataGetBooking.nonexistentBookingID).
        then().
            assertThat().
                statusCode(404);
    }

    @Test
    public void getInvalidBooking() {
        given().
                when().
                get(urls.base + urls.getBookingIDs + dataGetBooking.invalidBookingID).
                then().
                assertThat().
                statusCode(404);
    }
}
