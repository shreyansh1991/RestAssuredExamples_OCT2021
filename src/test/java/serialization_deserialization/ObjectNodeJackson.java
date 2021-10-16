package serialization_deserialization;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class ObjectNodeJackson {
    @Test
    public void usingObjectNode()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("name","myworkspace6");
        objectNode.put("type","personal");
        objectNode.put("description","Created By Rest Assured");

        ObjectNode masterNode = objectMapper.createObjectNode();
        masterNode.set("workspace",objectNode);

        RestAssured.given()
                .baseUri("https://api.postman.com")
                .basePath("/workspaces")
               .header("X-Api-Key", "PMAK-614eba868c8a230037462114-3d9c7dd62db816398a5eb8bce4aec5e6f9")
               // .contentType(ContentType.JSON)
                .body(masterNode)
                .log()
                .all()
                .when()
                .post()
                .then()
                .statusCode(200);
    }
}