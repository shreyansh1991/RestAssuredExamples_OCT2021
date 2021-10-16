package demo;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaValidation {

    @Test
    public void jsonSchemaValidation()
    {
        RestAssured.given().baseUri("https://postman-echo.com")
                .log()
                .all()
                .when()
                .get("/get")
                .then().
                log()
                .all()
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("echoget.json"));

    }

}
