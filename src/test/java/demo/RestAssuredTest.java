package demo;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import java.util.*;
// x-mock-match-request-body
public class RestAssuredTest {
    @Test
    public void test() {
        baseURI = "https://api.postman.com";
        basePath = "/workspaces";
        Map<String, List<String>> headers=new HashMap<String,List<String>>();
        List<String> headerList = Arrays.asList("h1", "h2", "h3");
        headers.put("headerKey",headerList);
        given()
                .header("X-Api-Key", "PMAK-614eba868c8a230037462114-3d9c7dd62db816398a5eb8bce4aec5e6f9")
                .headers(headers)
                .log()
                .all()
                .when()
                .get()
                .then()
                .assertThat()
                .log()
                .all()
                .statusCode(200)
                .body("workspaces.name", hasItems("ADP", "My Workspace", "30 days of Postman"),
                        "workspaces[0]", hasEntry("name", "ADP"),
                        "workspaces[0]", hasEntry("type", "personal"),
                        "workspaces[1]", hasEntry("name", "My Workspace"),
                        "workspaces[1]", hasEntry("type", "personal"),
                        "workspaces[1].name", not(emptyString()),
                        "workspaces[0]", hasKey("id"),
                        "workspaces[0]", hasKey("name"),
                        "workspaces[0]", hasKey("type"),
                        "workspaces[0]", not(Collections.EMPTY_MAP),
                        "workspaces.size", equalTo(3));
    }
}