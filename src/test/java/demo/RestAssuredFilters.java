package demo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RestAssuredFilters {

    ResponseSpecification responseSpecification;
    RequestSpecification requestSpecification;
    @BeforeClass
    public  void setUp()
    {
        PrintStream fileOutputStream = null;
        try {
            fileOutputStream =new PrintStream(new File("restassured.log"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        requestSpecification = new RequestSpecBuilder()
                .addFilter(new RequestLoggingFilter(LogDetail.ALL,fileOutputStream))
                .addFilter(new ResponseLoggingFilter(LogDetail.STATUS,fileOutputStream))
                .build();

        responseSpecification = new ResponseSpecBuilder().build();
    }
    @Test
    public void filters()
    {
        RestAssured.given(requestSpecification).baseUri("https://postman-echo.com")
                .when()
                .get("/get")
                .then()
                .spec(responseSpecification);

    }

}
