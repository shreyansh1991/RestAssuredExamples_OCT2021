package demo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.filter.Filter;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.*;
public class SpecificationQuerieDemo {

    @BeforeMethod
    public void setUp() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://api.postman.com")
                .setBasePath("/workspaces")
                .setConfig(config.encoderConfig(EncoderConfig.encoderConfig().
                        appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .addHeader("dummy","value")
                .log(LogDetail.ALL);
        requestSpecification = requestSpecBuilder.build();

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    @Test
    public void extractResponseTest() {
        QueryableRequestSpecification query = SpecificationQuerier.query(requestSpecification);
        Optional.ofNullable(query.getMethod()).ifPresent(value->System.out.println("Request Method : "+value));
        Optional.ofNullable(query.getBaseUri()).ifPresent(value->System.out.println("Base URI : "+value));
        Optional.ofNullable(query.getProxySpecification()).ifPresent(value->System.out.println("Proxy : "+value));
        Optional.ofNullable(query.getRequestParams()).ifPresent(value->System.out.println("Request Params : "+value));
        Optional.ofNullable(query.getHeaders()).ifPresent(value->System.out.println("Headers : "+value));
        Optional.ofNullable(query.getCookies()).ifPresent(value->System.out.println("Cookies  : "+value));
        Optional.ofNullable(query.getMultiPartParams()).ifPresent(value->System.out.println("Multi Parameters : "+value));
        Optional.ofNullable(query.getBody()).ifPresent(value->System.out.println("Body : "+value));

    }
}

