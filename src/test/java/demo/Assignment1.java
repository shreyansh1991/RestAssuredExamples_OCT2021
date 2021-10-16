package demo;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class Assignment1 {
    @Test
    public void assignmentOne()
    {
        Map<String,Object> masterMap=new LinkedHashMap<>();
        List<Object> colorsList = new ArrayList<>();
        Map<String,Object> firstColorMapObject=new LinkedHashMap<>();
        firstColorMapObject.put("color","black");
        firstColorMapObject.put("category","hue");
        firstColorMapObject.put("type","primary");
        Map<String,Object> firstColorRGBAMap=new LinkedHashMap<>();
        List<Integer> firstColorRGBAIntegerList=new ArrayList<>();
        firstColorRGBAIntegerList.add(255);
        firstColorRGBAIntegerList.add(255);
        firstColorRGBAIntegerList.add(255);
        firstColorRGBAIntegerList.add(1);
        firstColorRGBAMap.put("rgba",firstColorRGBAIntegerList);
        firstColorRGBAMap.put("hex","#000");
        firstColorMapObject.put("code",firstColorRGBAMap);


        Map<String,Object> secondColorMapObject=new LinkedHashMap<>();
        secondColorMapObject.put("color","white");
        secondColorMapObject.put("category","value");
        Map<String,Object> secondColorRGBAMap=new LinkedHashMap<>();
        List<Integer> secondColorRGBAIntegerList=new ArrayList<>();
        secondColorRGBAIntegerList.add(0);
        secondColorRGBAIntegerList.add(0);
        secondColorRGBAIntegerList.add(0);
        secondColorRGBAIntegerList.add(1);
        secondColorRGBAMap.put("rgba",secondColorRGBAIntegerList);
        secondColorRGBAMap.put("hex","#FFF");
        secondColorMapObject.put("code",secondColorRGBAMap);
        colorsList.add(firstColorMapObject);
        colorsList.add(secondColorMapObject);
        masterMap.put("colors",colorsList);

        baseURI = "https://688504de-a2f7-4a92-9c1e-d4941055ed4b.mock.pstmn.io";
        basePath = "/buildcomplexjson";
        given()
                .header("x-mock-match-request-body","true")
                .header("Content-Type","application/json;charset=utf-8")
                .body(masterMap)
                .log()
                .all()
                .when()
                .post()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201)
                .body("message", equalTo("Success"));
    }
}
