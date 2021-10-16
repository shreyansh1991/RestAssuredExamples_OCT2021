package pojo.parseJsonrecursively;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExtractKeyValue {
    private static final List<String> keysList = new ArrayList<>();
    private static final List<Object> valuesList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String jsonString="[\n" +
                "  {\n" +
                "    \"k\":[\n" +
                "      1,\n" +
                "      3,\n" +
                "      5\n" +
                "    ],\n" +
                "    \"k1\":{\n" +
                "      \"k10\":4,\n" +
                "      \"k11\":[\n" +
                "        4,\n" +
                "        7,\n" +
                "        9\n" +
                "      ],\n" +
                "      \"k12\":{\n" +
                "        \"k120\":{\n" +
                "          \"k121\":\"v121\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"k14\":6\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"k22\":{\n" +
                "      \"k221\":\"v122\"\n" +
                "    }\n" +
                "  }\n" +
                "]";
        ObjectMapper mapper = new ObjectMapper();
        ExtractKeyValue fetchKeyValue = new ExtractKeyValue();
        List<Map<String, Object>> listOfMap = mapper.readValue(jsonString, new TypeReference<List<Map<String, Object>>>(){});
        for (Map<String, Object> tempMap : listOfMap) {
            fetchKeyValue.map(tempMap);
        }
        System.out.println(keysList);
        System.out.println(valuesList);
    }

    private void map(Map<String, Object> map) {
        map.entrySet().forEach(entry->{
            if(entry.getValue() instanceof Map)
            {
                    map((Map<String, Object>) entry.getValue());
            }
            keysList.add(entry.getKey());
            if(!(entry.getValue() instanceof Map))
            {
               valuesList.add(entry.getValue());
            }
        });

    }
}
