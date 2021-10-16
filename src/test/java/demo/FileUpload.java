package demo;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.File;

public class FileUpload {
    @Test
    public void fileUpload()
    {
        RestAssured.given()
                .baseUri("https://postman-echo.com")
                .multiPart("file", new File("temp.txt"))
                .multiPart("attributes", "{\"name\":\"temp.txt\"}","application/json")
                .log()
                .all()
                .when()
                .post("/post")
                .then()
                .log()
                .all();
    }
}
