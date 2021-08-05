import data.urls;
import data.dataGetBookingIDs;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class getBookingIDs {
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
    public void getAllBookingIDs() {
        given().
        when().
            get(urls.base + urls.getBookingIDs).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON);
    }

    // first name tests
    @Test
    public void getBookingIDByName() {
        given().
            param("firstname", dataGetBookingIDs.firstname).
        when().
                get(urls.base + urls.getBookingIDs).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("bookingid[0]", equalTo(dataGetBookingIDs.bookingID));
    }

    @Test
    public void getBookingIDByNonexistentName() {
        given().
            param("firstname", dataGetBookingIDs.nonexistentFirstname).
        when().
            get(urls.base + urls.getBookingIDs).
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
            param("lastname", dataGetBookingIDs.lastname).
        when().
            get(urls.base + urls.getBookingIDs).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("bookingid[0]", equalTo(dataGetBookingIDs.bookingID));
    }

    @Test
    public void getBookingIDByNonexistentLastName() {
        given().
            param("lastname", dataGetBookingIDs.nonexistentLastname).
        when().
            get(urls.base + urls.getBookingIDs).
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
            param("checkin", dataGetBookingIDs.checkin).
        when().
            get(urls.base + urls.getBookingIDs).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("bookingid[0]", equalTo(dataGetBookingIDs.bookingID));
    }

    @Test
    public void getBookingIDByNonexistentCheckin() {
        given().
            param("checkin", dataGetBookingIDs.nonexistentCheckinCheckout).
        when().
            get(urls.base + urls.getBookingIDs).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("isEmpty()", is(true));
    }

    @Test
    public void getBookingIDByInvalidCheckin() {
        given().
            param("checkin", dataGetBookingIDs.invalidCheckinCheckout).
        when().
            get(urls.base + urls.getBookingIDs).
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
            param("checkout", dataGetBookingIDs.checkout).
        when().
            get(urls.base + urls.getBookingIDs).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("bookingid[0]", equalTo(dataGetBookingIDs.bookingID));
    }

    @Test
    public void getBookingIDByNonexistentCheckout() {
        given().
            param("checkout", dataGetBookingIDs.nonexistentCheckinCheckout).
        when().
            get(urls.base + urls.getBookingIDs).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("isEmpty()", is(true));
    }

    @Test
    public void getBookingIDByInvalidCheckout() {
        given().
            param("checkout", dataGetBookingIDs.invalidCheckinCheckout).
        when().
            get(urls.base + urls.getBookingIDs).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("isEmpty()", is(true));
    }

}
