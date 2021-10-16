package demo;

import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.*;

public class CmplexJson {
    @Test
    public void complexJsonAutomate() {

        Map<String, Object> json = new LinkedHashMap<>();
        json.put("ppu", 0.55);

        Map<String, Object> batters = new LinkedHashMap<>();
        Map<String, List<Object>> batter = new LinkedHashMap<>();
        Map<String, String> firstBatterRef = new LinkedHashMap<>();
        firstBatterRef.put("id", "1001");
        firstBatterRef.put("type", "Regular");
        Map<String, Object> secondBatterRef = new LinkedHashMap<>();
        List<Integer> integers = new ArrayList<>();
        integers.add(5);
        integers.add(9);
        secondBatterRef.put("id", integers);
        List<Object> batterList = new ArrayList<>();
        batterList.add(firstBatterRef);
        secondBatterRef.put("type", "Choclate");
        batterList.add(secondBatterRef);
        batter.put("batter",batterList);
        json.put("batters",batter);

        json.put("name", "Cake");
        json.put("id", "0001");
        json.put("type", "donut");

//        Map<String, List<Object>> topping = new LinkedHashMap<>();
       List<Object> toppingList = new ArrayList<>();
        Map<Object, Object> firstToppingMap = new LinkedHashMap<>();
        firstToppingMap.put("id", "5001");
        firstToppingMap.put("type", "None");
        Map<Object, Object> secondToppingMap = new LinkedHashMap<>();
        secondToppingMap.put("id", "5002");
        List<String> secondSubToppingList = new ArrayList<>();
        secondSubToppingList.add("test1");
        secondSubToppingList.add("test2");
        secondToppingMap.put("type", secondSubToppingList);
        toppingList.add(firstToppingMap);
        toppingList.add(secondToppingMap);
    json.put("topping",toppingList);


        baseURI = "https://api.postman.com";
        basePath = "/workspaces";
        given()
                .header("X-Api-Key", "PMAK-614eba868c8a230037462114-3d9c7dd62db816398a5eb8bce4aec5e6f9")
                .body(json)
                .log()
                .all()
                .when()
                .get()
                .then();



































    }
}



