package automategmailapi;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ListAPI {

    @Test
    public void list()
    {
        https://gmail.googleapis.com/gmail/v1/users/jain.shreyansh2014feb@gmail.com/messages
        RestAssured.given()
                .baseUri("https://gmail.googleapis.com")
                .basePath("/gmail/v1")
                .pathParam("emailID","jain.shreyansh2014feb@gmail.com")
                .header("Authorization",
                        "Bearer "+"ya29.a0ARrdaM89oWX9nHA_sX0vpRxingc5SMjWeu_0ON2QplY73EX1MmBYzskb-XPn8Q68fZWnjjYe6MBPr39U1G_CTuxpn3-NkRdFTp_15hMaDRtUmgThQQ0C4Sr4mSQzxhtpIqNOEx06ZMuafqkcIfrtR4GU7wUQ9w")
                .log()
                .all()
                .when()
                .get("/users/{emailID}/messages")
                .then()
                .log()
                .all()
                .statusCode(200);
    }



}
