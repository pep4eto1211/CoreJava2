import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class JSONUtils {
    public static /*Map<String,Object>*/ void parseJSON(String jsonBody) throws JSONException {
        try {
            JSONArray participents = new JSONArray(jsonBody);
            for (int i = 0; i < participents.length(); i++){
                JSONArray courses = participents.getJSONObject(i).getJSONArray("courses");
                if (courses.length() > 1){
                    System.out.println(participents.getJSONObject(i).getString("name"));
                }
            }
        } catch (JSONException e) {
            // JSON Parsing error
            e.printStackTrace();
        }
    }

    public static void showPeopleOnMoreCourses(String JSONUrl) throws IOException, JSONException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("D://json.txt")));
        String currentLine;
        String all = "";
        while ((currentLine = reader.readLine()) != null) {
            all += currentLine;
        }
        parseJSON(all);
    }

    public static String read(String url) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
        String singleLine;
        String contents = "";
        while ((singleLine = reader.readLine()) != null) {
            contents += singleLine;
        }
        reader.close();
        return contents;
    }
}
