package com.iplTeam.utils;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;


import java.io.File;
import java.util.List;


public class ReadJsonFile {

    public static DocumentContext document;

    public static void parseJson(String filename){
        try {
            File jsonFile = new File("./src/main/resources/JsonTemplates/" + filename + ".json");
            document = JsonPath.parse(jsonFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> readJsonValue(String jsonPath) {
        List<String> jsonObject = null;
        try {
            JsonPath jsonpath = JsonPath.compile(jsonPath);
            jsonObject = document.read(jsonpath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
