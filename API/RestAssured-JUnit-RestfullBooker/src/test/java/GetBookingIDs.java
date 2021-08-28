import data.Urls;
import data.DataGetBookingIDs;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class GetBookingIDs {
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
    public void getAllBookingIDs() {
        given().
        when().
            get(Urls.BASE + Urls.BOOKING).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON);
    }

    // first name tests
    @Test
    public void getBookingIDByName() {
        given().
            param("firstname", DataGetBookingIDs.FIRSTNAME).
        when().
                get(Urls.BASE + Urls.BOOKING).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("bookingid[0]", equalTo(DataGetBookingIDs.BOOKING_ID));
    }

    @Test
    public void getBookingIDByNonexistentName() {
        given().
            param("firstname", DataGetBookingIDs.NONEXISTENT_FIRSTNAME).
        when().
            get(Urls.BASE + Urls.BOOKING).
        then().
            assertThat().
            statusCode(200).
            contentType(ContentType.JSON).
            body("isEmpty()", is(true));
    }

    // last name tests
    @Test
    public void getBookingIDByLastName() {
        given().
            param("lastname", DataGetBookingIDs.LASTNAME).
        when().
            get(Urls.BASE + Urls.BOOKING).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("bookingid[0]", equalTo(DataGetBookingIDs.BOOKING_ID));
    }

    @Test
    public void getBookingIDByNonexistentLastName() {
        given().
            param("lastname", DataGetBookingIDs.NONEXISTENT_LASTNAME).
        when().
            get(Urls.BASE + Urls.BOOKING).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("isEmpty()", is(true));
    }

    // checkin date tests
    @Test
    public void getBookingIDByCheckin() {
        given().
            param("checkin", DataGetBookingIDs.CHECKIN).
        when().
            get(Urls.BASE + Urls.BOOKING).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("bookingid[0]", equalTo(DataGetBookingIDs.BOOKING_ID));
    }

    @Test
    public void getBookingIDByNonexistentCheckin() {
        given().
            param("checkin", DataGetBookingIDs.NONEXISTENT_CHECKIN_CHECKOUT).
        when().
            get(Urls.BASE + Urls.BOOKING).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("isEmpty()", is(true));
    }

    @Test
    public void getBookingIDByInvalidCheckin() {
        given().
            param("checkin", DataGetBookingIDs.INVALID_CHECKIN_CHECKOUT).
        when().
            get(Urls.BASE + Urls.BOOKING).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("isEmpty()", is(true));
    }

    // checkout date tests
    @Test
    public void getBookingIDByCheckout() {
        given().
            param("checkout", DataGetBookingIDs.CHECKOUT).
        when().
            get(Urls.BASE + Urls.BOOKING).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("bookingid[0]", equalTo(DataGetBookingIDs.BOOKING_ID));
    }

    @Test
    public void getBookingIDByNonexistentCheckout() {
        given().
            param("checkout", DataGetBookingIDs.NONEXISTENT_CHECKIN_CHECKOUT).
        when().
            get(Urls.BASE + Urls.BOOKING).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("isEmpty()", is(true));
    }

    @Test
    public void getBookingIDByInvalidCheckout() {
        given().
            param("checkout", DataGetBookingIDs.INVALID_CHECKIN_CHECKOUT).
        when().
            get(Urls.BASE + Urls.BOOKING).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("isEmpty()", is(true));
    }

}
