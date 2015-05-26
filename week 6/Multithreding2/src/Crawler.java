import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler {
    private URL crawingUrl;
    private List<String> allUrls = new ArrayList<String>();

    Stack<String> firstList;
    Stack<String> secondList;

    public Crawler(URL crawingUrl) {
        this.crawingUrl = crawingUrl;
    }

    private List<String> getAllLinks(String content) {
        ArrayList<String> resultList = new ArrayList<>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            String singleUrl = matcher.group(1);
            if ((singleUrl.indexOf("http://") == -1) && (singleUrl.indexOf("https://") == -1)){
                /*if (singleUrl.charAt(0) == '/'){
                    singleUrl = singleUrl.substring(1);
                }*/
                singleUrl = crawingUrl.toString() + singleUrl;
            }
            resultList.add(singleUrl);
        }
        return resultList;
    }

    private void crawl(URL urlToCrawl) throws MalformedURLException, IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlToCrawl.openStream()));
        String singleLine;
        String contents = "";
        while ((singleLine = reader.readLine()) != null) {
            contents += singleLine;
        }
        reader.close();
        System.out.println(urlToCrawl.toString());
        allUrls.addAll(getAllLinks(contents));
    }

    private void crawl1(URL urlToCrawl) throws MalformedURLException, IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlToCrawl.openStream()));
        String singleLine;
        String contents = "";
        while ((singleLine = reader.readLine()) != null) {
            contents += singleLine;
        }
        reader.close();
        System.out.println("Thread 1: " + urlToCrawl.toString());
        firstList.addAll(getAllLinks(contents));
    }

    private void crawl2(URL urlToCrawl) throws MalformedURLException, IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlToCrawl.openStream()));
        String singleLine;
        String contents = "";
        while ((singleLine = reader.readLine()) != null) {
            contents += singleLine;
        }
        reader.close();
        System.out.println("Thread 2: " + urlToCrawl.toString());
        secondList.addAll(getAllLinks(contents));
    }

    public void start() throws MalformedURLException, IOException, URISyntaxException{
        crawl(crawingUrl);
        VisitedList.addVisited(crawingUrl.toString());
        firstList = new Stack<>();
        firstList.addAll(allUrls.subList(0, allUrls.size() / 2));
        secondList = new Stack<>();
        secondList.addAll(allUrls.subList((allUrls.size() / 2) + 1, allUrls.size() - 1));
        Thread firstThread = new Thread(() -> {
            while (!firstList.isEmpty()){
                try {
                    if (!VisitedList.checkIfVisited(firstList.peek())) {
                        crawl1(new URL(firstList.peek()));
                        VisitedList.addVisited(firstList.pop());
                    }
                    else{
                        VisitedList.addVisited(firstList.pop());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread secondThread = new Thread(() -> {
            while (!secondList.isEmpty()){
                try {
                    if (!VisitedList.checkIfVisited(secondList.peek())) {
                        crawl2(new URL(secondList.peek()));
                        VisitedList.addVisited(secondList.pop());
                    }
                    else{
                        VisitedList.addVisited(secondList.pop());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        firstThread.start();
        secondThread.start();
    }
}
