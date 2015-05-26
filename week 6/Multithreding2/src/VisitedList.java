import java.util.ArrayList;
import java.util.List;

public class VisitedList {
    private static List<String> visitedUrls = new ArrayList<>();

    public static synchronized void addVisited(String url){
        visitedUrls.add(url);
    }

    public static synchronized boolean checkIfVisited(String url){
        if (visitedUrls.indexOf(url) != -1){
            return false;
        }
        return true;
    }
}
