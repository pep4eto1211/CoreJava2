import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PropertiesParser {
    public static Map<String, String> parseProperties(File propertiesFile) throws IOException{
        Map<String, String> parsedProperties = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(propertiesFile))){
            String currentLine;
            while ((currentLine = reader.readLine()) != null){
                if (currentLine.charAt(0) != '#'){
                    parsedProperties.put(currentLine.substring(0, currentLine.indexOf('=')).trim(),
                            currentLine.substring(currentLine.indexOf('=') + 1).trim());
                }
            }
            return parsedProperties;
        }
        catch (IOException e){
            throw e;
        }
    }
}
