package demo;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import org.testng.annotations.Test;

import java.io.*;

public class FileDownload {
    //@Test
    public void fileUpload()
    {
        byte[] bytes = RestAssured.given()
                .baseUri("https://raw.githubusercontent.com")
                .basePath("/appium/appium/master/sample-code/apps/ApiDemos-debug.apk")
                .log()
                .all()
                .when()
                .get()
                .then()
                .log()
                .all()
                .extract()
                .response()
                .asByteArray();
        OutputStream outputStream = null;
        try {
             outputStream=new FileOutputStream(new File("ApiDemos-debug.apk"));
            outputStream.write(bytes);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File Download successful!");
    }
    @Test(invocationCount = 1)
    public void form_url_encoded()
    {
        /* difference between queryParameters and formParameters is -  in case of queryParameters, parameters will be appended
         in URl whereas in case of form parameters, parameters won't be appended in url. */
        // key and value are url encoded in case of both query param and form param.

      RestAssured.given()
                .baseUri("https://postman-echo.com")
              .basePath("/post")
              .config(RestAssuredConfig.config().encoderConfig(
                      EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
              .formParam("key:1","value:1")
              .formParam("key1","value 2")
                .log()
                .all()
                .when()
                .post()
                .then()
                .log()
                .all();
//              .statusCode(200);

    }
}
