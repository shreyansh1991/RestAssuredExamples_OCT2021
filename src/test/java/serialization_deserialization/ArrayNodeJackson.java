package serialization_deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ArrayNodeJackson {
    @Test
    public void usingArrayNode()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode arrayNode = objectMapper.createArrayNode();
        ObjectNode objectNode = objectMapper.createObjectNode();

        objectNode.put("id","5001");
        objectNode.put("type","none");

        ObjectNode objectNode2 = objectMapper.createObjectNode();
        objectNode2.put("id","5002");
        objectNode2.put("type","none");

        arrayNode.add(objectNode);
        arrayNode.add(objectNode2);
        System.out.println(arrayNode);

    }
}
