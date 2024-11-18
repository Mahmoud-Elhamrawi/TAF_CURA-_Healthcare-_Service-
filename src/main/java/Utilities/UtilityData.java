package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
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


    //TODO:: read data from json file have array of object
    private static String[] readJsonFile(String status) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/resources/TestData/successLogin.json");
        Object object = jsonParser.parse(reader);
        JSONObject jsonObject = (JSONObject) object;
        JSONArray jsonArray = (JSONArray) jsonObject.get(status);
        String arr[] = new String[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject users = (JSONObject) jsonArray.get(i);
            String userName = (String) users.get("userName");
            String password = (String) users.get("password");
            arr[i] = userName + "," + password;

        }
        return arr;
    }

    public static String[] readDataJson(String statuss) throws IOException, ParseException {
        return readJsonFile(statuss);
    }
}
