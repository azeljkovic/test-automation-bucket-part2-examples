import data.ParseJSON;
import data.Urls;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CreateTokenTest {
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
    public void creteTokenValid() throws FileNotFoundException {
        given().
        when().
            body(ParseJSON.getDataObject(ParseJSON.VALID_CREDENTIALS_JSON)).
            contentType(ContentType.JSON).
            post(Urls.BASE + Urls.AUTHENTICATION).
        then().
            assertThat().
                statusCode(200).
                body("$", hasKey("token")).
                contentType(ContentType.JSON);
    }

    @Test
    public void creteTokenInvalidCredentials() throws FileNotFoundException {
        given().
        when().
            body(ParseJSON.getDataObject(ParseJSON.INVALID_CREDENTIALS_JSON)).
            contentType(ContentType.JSON).
            post(Urls.BASE + Urls.AUTHENTICATION).
        then().
            assertThat().
                statusCode(200).
                body("reason", equalTo("Bad credentials")).
                contentType(ContentType.JSON);
    }
}
