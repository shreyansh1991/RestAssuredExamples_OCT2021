package demo;

import io.restassured.config.LogConfig;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.*;

public class BlackListHeader {
    @Test
    public void extractResponseTest() {
        HashSet<String> blackListHeader = new HashSet<>();
        blackListHeader.add("X-Api-Key");
        baseURI = "https://api.postman.com";
        basePath = "/workspaces";
        given()
                .header("X-Api-Key", "PMAK-614eba868c8a230037462114-3d9c7dd62db816398a5eb8bce4aec5e6f9")

                .config(config.logConfig(LogConfig.logConfig().blacklistHeaders(blackListHeader)))
                .log()
                .all()
                .when()
                .get()
                .then()
                .log()
                .all();
    }
}
