package com.iplTeam.utils;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class CommonUtils {
    public static DocumentContext document;
    public static Properties prop;

    public static void parseJson(String filename){
        try {
            File jsonFile = new File("./src/main/resources/JsonTemplates/" + filename + ".json");
            document = JsonPath.parse(jsonFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> readJsonValue(String jsonPath) {
        List<String> jsonObject = null;
        try {
            JsonPath jsonpath = JsonPath.compile(jsonPath);
            jsonObject = document.read(jsonpath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static Properties readPropertiesFile(String propertyFile) {

        File file = new File("./src/main/resources/Config/" + propertyFile + ".properties");
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop = new Properties();

        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }


}
