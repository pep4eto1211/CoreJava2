import org.codehaus.jettison.json.JSONException;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try {
            JSONUtils.showPeopleOnMoreCourses("https://hackbulgaria.com/api/students/");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
