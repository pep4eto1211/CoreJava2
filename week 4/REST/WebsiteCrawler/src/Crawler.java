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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler {
    private URL crawingUrl;
    private URL currentUrl;
    private String needle;
    private List<String> allUrls = new ArrayList<String>();
    private List<String> visitedUrls = new ArrayList<String>();

    public Crawler(URL crawingUrl, String needle) {
        this.crawingUrl = crawingUrl;
        this.needle = needle;
        this.currentUrl = crawingUrl;
    }

    private List<String> getAllLinks(String content) {
        ArrayList<String> resultList = new ArrayList<>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            resultList.add(matcher.group(1));
        }
        return resultList;
    }

    private boolean crawl(URL urlToCrawl) throws MalformedURLException, IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlToCrawl.openStream()));
        String singleLine;
        String contents = "";
        while ((singleLine = reader.readLine()) != null) {
            contents += singleLine;
        }
        reader.close();

        if (contents.indexOf(needle) != -1){
            return true;
        }
        else{
            allUrls.addAll(getAllLinks(contents));
            return false;
        }
    }

    public static String reduceFilePath(File filePath){
        return filePath.toPath().normalize().toString();
    }

    public URL start() throws MalformedURLException, IOException, URISyntaxException{
        int crawed = 0;
        if (crawl(currentUrl)){
            return currentUrl;
        }
        else{
            visitedUrls.add(currentUrl.toString());
            for (int i = 0; i < allUrls.size(); i++){
                crawed++;
                if (crawed == 100){
                    break;
                }
                String singleUrl = allUrls.get(i);
                if ((singleUrl.matches(currentUrl.toString() + "[^\\s]*")) || (singleUrl.indexOf("http://") == -1)){
                    if(singleUrl.indexOf("http://") == -1){
                        currentUrl = new URL(crawingUrl + "/" + singleUrl);
                    }
                    else{
                        currentUrl = new URL(singleUrl);
                    }
                    if ((visitedUrls.indexOf(currentUrl) == -1) && (currentUrl.toString().indexOf("/../") == -1)) {
                        if (crawl(currentUrl)){
                            return currentUrl;
                        }
                        currentUrl = crawingUrl;
                    }
                }
            }
        }

        return null;
    }
}
