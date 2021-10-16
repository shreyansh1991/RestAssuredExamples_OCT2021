package automategmailapi;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.Base64;
import java.util.HashMap;

public class Send {

    @Test
    public void demo()
    {
        String message="From: jain.shreyansh2014feb@gmail.com\n"+
                "To: shreyansh.jain79@gmail.com\n"+
                "Subject: Email from Rest Assured"+
                "\n"+
                "Body: Sending from rest assured";
        String encodedString = Base64.getUrlEncoder().encodeToString(message.getBytes());
        System.out.println(encodedString);
        HashMap<String, String> body = new HashMap<>();
        body.put("raw",encodedString);
        RestAssured.given()
                .baseUri("https://gmail.googleapis.com")
                .basePath("/gmail/v1")
                .pathParam("userId","jain.shreyansh2014feb@gmail.com")
                .header("Authorization",
                        "Bearer "+"ya29.a0ARrdaM-g5qnz6nTP-iYl4Kj7uTJnXA4SFN-EERS1k0KlhDoEIZEhuQYOch5zFthlRg_hmqy1NFciBB7HPyJxeyxQ0pvjf0TkzhjRqOLYUMPetM05ZAtXP6D1YajSXF4WfH-goL1aN5TD1iGFSgQyRaz0B6kWzQ")
             //   .body(body)
                .body(message)
                .log()
                .all()
                .when()
                .post("/users/{userId}/messages/send")
                .then()
                .log()
                .all()
                .statusCode(200);
    }
}
