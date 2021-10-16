package demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

public class MultiPartDemo {

    @Test
    public void multiPart()
    {
        String data = RestAssured.given()
                .baseUri("https://postman-echo.com")
                .multiPart("key1", "value1")
                .when()
                .post("/post")
                .then()
                .log()
                .all()
                .assertThat()
                .extract()
                .response()
                .path("form.key1")
                .toString();
        System.out.println("value - "+ data);
    }
}
