package demo;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ExtractResponse {
    @Test
    public void extractResponseTest() {
        baseURI = "https://api.postman.com";
        basePath = "/workspaces";
        Response response = given()
                .header("X-Api-Key", "PMAK-614eba868c8a230037462114-3d9c7dd62db816398a5eb8bce4aec5e6f9")
                .log()
                .all()
                .when()
                .get()
                .then()
                .extract()
                .response();
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Response is " + response.prettyPrint());
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Response is " + response.prettyPeek().prettyPrint());
    }
}
