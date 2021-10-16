package serialization_deserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.json.JSONException;
import org.skyscreamer.jsonassert.Customization;

import static org.hamcrest.MatcherAssert.assertThat;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.ValueMatcher;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.skyscreamer.jsonassert.comparator.JSONComparator;
import org.testng.annotations.Test;
import pojo.complexpojos.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComplexPojoTest {
    @Test
    public void test()
    {
        CollectionRequest collectionRequest = new CollectionRequest();
        InfoRequest info=new InfoRequest();
        info.setName("Om's Collection");
        info.setDescription("This is Om's Collection.");
        info.setSchema("https://schema.getpostman.com/json/collection/v2.1.0/collection.json");

        ItemRequest item = new ItemRequest();
        item.setName("This is a folder");
        Item_1Request item_1 = new Item_1Request();
        item_1.setName("Sample Post Request");
        RequestRequest requestRequest = new RequestRequest();
        requestRequest.setUrl("https://postman-echo.com/post");
        requestRequest.setMethod("POST");
        HeaderRequest header = new HeaderRequest();
        header.setKey("Content-Type");
        header.setValue("application/json");
        requestRequest.setHeader(Arrays.asList(header));
        BodyRequest body = new BodyRequest();
        body.setMode("raw");
        body.setRaw("{\"data\": \"123\"}");
        requestRequest.setBody(body);
        requestRequest.setDescription("This is a sample POST Request");
        item_1.setRequest(requestRequest);
        List<Item_1Request> item_1Requests = Arrays.asList(item_1);
        item.setItem(item_1Requests);
        collectionRequest.setItem(Arrays.asList(item));
        collectionRequest.setInfo(info);
        ExampleRequest exampleRequest = new ExampleRequest();
        exampleRequest.setCollection(collectionRequest);

        String uid = RestAssured.given()
                .baseUri("https://api.getpostman.com")
                .basePath("/collections")
                .header("X-Api-Key", "PMAK-614eba868c8a230037462114-3d9c7dd62db816398a5eb8bce4aec5e6f9")
                .contentType(ContentType.JSON)
                .body(exampleRequest)
                .log()
                .all()
                .when()
                .post()
                .then()
                .extract()
                .response()
                .path("collection.uid");
        System.out.println("UID extracted from Post Call is  "+uid);

        ExampleResponse deserializedCollectionExample = RestAssured.given()
                .pathParam("collectionUID", uid)
                .baseUri("https://api.getpostman.com")
                .basePath("/collections/{collectionUID}")
                .header("X-Api-Key", "PMAK-614eba868c8a230037462114-3d9c7dd62db816398a5eb8bce4aec5e6f9")
                .log()
                .all()
                .when()
                .get()
                .then()
                .log()
                .all()
                .extract()
                .response()
                .as(ExampleResponse.class);
        System.out.println("83 -- "+deserializedCollectionExample);

        ObjectMapper objectMapper = new ObjectMapper();
        String deserializedCollectionExampleString = null;
        String ExampleString = null;
        try {
             deserializedCollectionExampleString = objectMapper.writeValueAsString(deserializedCollectionExample);
             ExampleString = objectMapper.writeValueAsString(exampleRequest);
            System.out.println("90 - "+ deserializedCollectionExampleString);
            System.out.println("91 - "+ ExampleString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        JSONComparator customComparator = new CustomComparator(JSONCompareMode.STRICT_ORDER,
                new Customization("collection.item[*].item[*].request.url", new ValueMatcher<Object>() {
                    @Override
                    public boolean equal(Object o, Object t1) {
                        return true;
                    }
                }));
        try {
            JSONAssert.assertEquals(ExampleString,deserializedCollectionExampleString,customComparator);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        List<String> requestURLList=new ArrayList<>();
        List<String> responseURLList=new ArrayList<>();

        for(Item_1Request temp:item_1Requests)
        {
            String url = temp.getRequest().getUrl();
            System.out.println("from Req payload.. - "+url);
            requestURLList.add(url);
        }


//        List<ItemRequest> itemRequest = collectionRequest.getItem();
//        for(ItemRequest tempItemRequest:itemRequest)
//        {
//            List<Item_1Request> item1Request = tempItemRequest.getItem();
//            for(Item_1Request tempItem_1Request :  item1Request)
//            {
//                String url = tempItem_1Request.getRequest().getUrl();
//                System.out.println("from Req payload.. - "+url);
//                requestURLList.add(url);
//            }
//        }

        List<ItemResponse> itemResponses = deserializedCollectionExample.getCollection().getItem();
        for(ItemResponse itemResponse : itemResponses)
        {
            List<Item_1Response> item1 = itemResponse.getItem();
            for(Item_1Response tempItem_1Response :  item1)
            {
                String url = tempItem_1Response.getRequest().getUrl().getRaw();
                System.out.println("from Response payload.. - "+url);
                responseURLList.add(url);
            }
        }

            assertThat(responseURLList, Matchers.containsInAnyOrder(requestURLList.toArray()));
        System.out.println("PASSED!");
    }
}
