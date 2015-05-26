import java.io.*;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;

public class FixSubtitles {
    public static void fixEncoding(File file) throws IOException{
        String subtitles = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "windows-1251"))){
            String currentLine = "";
            while((currentLine = reader.readLine()) != null){
                subtitles += currentLine;
                subtitles += "\n";
            }
            System.out.print(subtitles);
            try(OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8")) {
                writer.write(subtitles);
            }
            catch (IOException e){
                throw e;
            }
        }
        catch(IOException e){
            throw e;
        }
    }
}
