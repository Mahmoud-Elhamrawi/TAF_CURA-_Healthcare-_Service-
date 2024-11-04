package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class UtilityData {


    public static final String path_file_data = "src/test/resources/TestData/";

    //TODO::read data from json file
    public static String readDataFromJsonFile(String fileName, String key) {
        try {
            FileReader fileReader = new FileReader(path_file_data + fileName + ".json");
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            return jsonElement.getAsJsonObject().get(key).getAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";


    }

    //TODO::read data from property file
    public static String readDataFromPropertyFile(String fileName, String property) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(path_file_data + fileName + ".properties"));
            return properties.getProperty(property);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }


}
