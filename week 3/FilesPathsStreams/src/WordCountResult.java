import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class WordCountResult {
    private int lineCount;
    private int wordCount;
    private int charCount;

    private WordCountResult(int lineCount, int wordCount, int charCount) {
        this.lineCount = lineCount;
        this.wordCount = wordCount;
        this.charCount = charCount;
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getCharCount() {
        return charCount;
    }

    public static WordCountResult wordCount(File file) throws IOException{
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String readText = "";
            String currentLine;
            int lineCount = 0;
            while ((currentLine = reader.readLine()) != null){
                lineCount++;
                readText += currentLine + " ";
            }
            return new WordCountResult(lineCount, readText.split(" ").length, readText.length());
        }catch (IOException e){
            throw e;
        }
    }
}
