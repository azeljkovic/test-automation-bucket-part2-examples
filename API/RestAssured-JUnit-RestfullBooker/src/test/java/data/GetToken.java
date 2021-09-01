package data;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class GetToken {
    public static String creteToken() throws FileNotFoundException {
        Response response = given().
        when().
            body(ParseJSON.getDataObject(ParseJSON.VALID_CREDENTIALS_JSON)).
            contentType(ContentType.JSON).
            post(Urls.BASE + "/auth").
        then().
            extract().response();

        JsonPath jsonPathEvaluator = response.jsonPath();
        String token = jsonPathEvaluator.get("token");
        return token;
    }
}
