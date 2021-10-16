package serialization_deserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import pojo.SimplePojo;

public class SimplePojoTest {

    @Test
    public void simplepojo()
    {
        SimplePojo simplePojo = new SimplePojo();
        simplePojo.setKey1("value1").setKey2("value2");
        RestAssured.given()
                .baseUri("https://688504de-a2f7-4a92-9c1e-d4941055ed4b.mock.pstmn.io")
                .basePath("/pojo")
                .header("x-mock-match-request-body","true")
                .contentType(ContentType.JSON)
                .config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(simplePojo)
                .log()
                .all()
                .when()
                .post()
                .then()
                .log()
                .all()
                .statusCode(201);

    }
    @Test
    public void deserializeDemo() throws JsonProcessingException {
        SimplePojo simplePojo = new SimplePojo();
        simplePojo.setKey1("value1").setKey2("value2");

        final SimplePojo desPojo = RestAssured.given()
                .baseUri("https://688504de-a2f7-4a92-9c1e-d4941055ed4b.mock.pstmn.io")
                .basePath("/pojo")
                .header("x-mock-match-request-body", "true")
                .contentType(ContentType.JSON)
                .config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(simplePojo)
                .log()
                .all()
                .when()
                .post()
                .then()
                .log()
                .all()
                .extract()
                .response()
                .as(SimplePojo.class);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = null;
        String s1 = null;
        try {
             s = objectMapper.writeValueAsString(simplePojo);
             s1 = objectMapper.writeValueAsString(desPojo);
            System.out.println("expected - "+ s);
            System.out.println("actual - "+ s1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        MatcherAssert.assertThat(objectMapper.readTree(s),Matchers.equalTo(objectMapper.readTree(s1)));
    }
}
