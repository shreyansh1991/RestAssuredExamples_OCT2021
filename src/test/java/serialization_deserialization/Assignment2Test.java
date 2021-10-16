package serialization_deserialization;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojo.assignment2.Address;
import pojo.assignment2.UserPojo;
import pojo.assignment2.Geo;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;

public class Assignment2Test {
    @Test
    public void test()
    {
        UserPojo user = new UserPojo();

        user.setName("Leanne Graham").setUsername("Bret")
                .setEmail("Sincere@april.biz");
        Address address = new Address();
        address.setStreet("Kulas Light")
                .setSuite("Apt. 556")
                .setCity("Gwenborough")
                    .setZipCode("92998-3874");
        Geo geo = new Geo();
        geo.setLat("-37.3159").setLng("81.1496");
        address.setGeo(geo);
        user.setAddress(address);
        RestAssured.given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .basePath("/users")
                .log().all()
                .body(user)
                .when()
                .post()
                .then()
                .log()
                .all()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("id",not(empty()));
    }
}
