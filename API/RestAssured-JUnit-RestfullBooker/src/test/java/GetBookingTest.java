import data.Urls;
import data.DataGetBooking;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetBookingTest {
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
    public void getBooking() {
        given().
        when().
            get(Urls.BASE + Urls.BOOKING + Urls.BOOKING_ID).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo(DataGetBooking.FIRSTNAME)).
                body("lastname", equalTo(DataGetBooking.LASTNAME)).
                body("totalprice", equalTo(DataGetBooking.TOTAL_PRICE)).
                body("depositpaid", equalTo(DataGetBooking.DEPOSIT_PAID)).
                body("bookingdates.checkin", equalTo(DataGetBooking.CHECKIN)).
                body("bookingdates.checkout", equalTo(DataGetBooking.CHECKOUT));
    }

    @Test
    public void getNonexistentBooking() {
        given().
        when().
            get(Urls.BASE + Urls.BOOKING + Urls.NONEXISTENT_BOOKING_ID).
        then().
            assertThat().
                statusCode(404);
    }

    @Test
    public void getInvalidBooking() {
        given().
        when().
            get(Urls.BASE + Urls.BOOKING + Urls.INVALID_BOOKING_ID).
        then().
            assertThat().
                statusCode(404);
    }
}
