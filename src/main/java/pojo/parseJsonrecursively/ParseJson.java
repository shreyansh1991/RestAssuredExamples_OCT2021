package pojo.parseJsonrecursively;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.*;

public class ParseJson {
static String s="[\n" +
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
    static List<String> allKeys = new ArrayList<>();
    static List allValues = new ArrayList<>();
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(s);
            JSONArray jsonArray = (JSONArray) obj;
            for(Object jsonArrayRef:jsonArray)
            {
                JSONObject jsonObject=(JSONObject) jsonArrayRef;
                Set<String> jsonKeys = jsonObject.keySet();
                for (String key : jsonKeys) {
                    allKeys.add(key);
                    Object val = jsonObject.get(key);
                    if (val instanceof JSONArray) {
                        JSONArray array = (JSONArray) val;
                        jsonArray(array);

                    } else if (val instanceof JSONObject) {
                        JSONObject jsonOb = (JSONObject) val;
                        jsonObj(jsonOb);
                    } else {
                        allValues.add(val);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("allKeys "+allKeys);
        System.out.println("allValues "+allValues);
        }

    public static void jsonObj(JSONObject object) {
        Set<String> innerKeys = object.keySet();
        for (String key : innerKeys) {
            allKeys.add(key);
            Object val = object.get(key);
            if (val instanceof JSONArray) {
                JSONArray array = (JSONArray) val;
                jsonArray(array);

            } else if (val instanceof JSONObject) {
                JSONObject jsonOb = (JSONObject) val;
                jsonObj(jsonOb);
            } else {
                allValues.add(val);
            }
        }
    }

    public static void jsonArray(JSONArray array) {
        if (array.size() == 0) {
            allValues.add(array);
        } else {
            for (int i = 0; i < array.size(); i++) {
                Object jObject = array.get(i);
                if (jObject instanceof JSONObject) {
                    JSONObject job = (JSONObject) jObject;
                    jsonObj(job);
                }
                else
                {
                    if(!allValues.contains(array))
                    allValues.add(array);
                }
            }
        }
    }
}
