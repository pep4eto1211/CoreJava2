import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileUtils {

    public static void compress(Path filePath) throws IOException{
        String file = readFrom(filePath);
        String[] words = file.split(" ");
        ArrayList<String> individualWords = new ArrayList<>();
        String compressed = "";
        for (String singleWord : words){
            if (individualWords.indexOf(singleWord) == -1){
                individualWords.add(singleWord);
                compressed += singleWord + "=" + String.valueOf(individualWords.indexOf(singleWord));
                compressed += "\n";
            }
        }

        for (String uniqueWord : individualWords){
            file = file.replaceAll(uniqueWord, "~" + String.valueOf(individualWords.indexOf(uniqueWord)));
        }

        file = file.replaceAll(" ", "");
        compressed += file;

        writeTo(filePath, compressed);

        File newFile = new File(filePath.toString());
        newFile.renameTo(new File(newFile.getPath() + ".compr"));
    }

    public static void decompress(Path filePath) throws IOException{
        List<String> words = new ArrayList<>();
        String compressedFile = "";
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))){
            String currentLine;
            while ((currentLine = reader.readLine()) != null){
                if (currentLine.charAt(0) != '~'){
                    words.add(currentLine.substring(0, currentLine.indexOf('=')).trim());
                }else{
                    compressedFile += currentLine;
                }
            }
        }
        catch (IOException e){
            throw e;
        }

        for (String singleWord : words){
            compressedFile = compressedFile.replaceAll(String.valueOf(words.indexOf(singleWord)), singleWord);
        }
        compressedFile = compressedFile.replaceAll("~", " ");
        compressedFile = compressedFile.trim();

        writeTo(filePath, compressedFile);

        File newFile = new File(filePath.toString());
        newFile.renameTo(new File(newFile.getPath().substring(0, newFile.getPath().length() - 6)));
    }

    public static void listDublicatingFiles(File folderPath) throws IOException, NoSuchAlgorithmException{
        List<File> allFiles = getAllFilesRecursivley(folderPath, false);
        HashMap<byte[], File> individualFiles = new HashMap<>();
        for (File singleFile : allFiles){
            byte[] data = Files.readAllBytes(singleFile.toPath());

            if (individualFiles.get(data) != null){

            }
            else{

            }
        }
    }

    public static ArrayList<File> getAllFilesRecursivley(File folder, Boolean includeLinks){
        ArrayList<File> allFiles = new ArrayList<>();
        File[] FilesArray = folder.listFiles();
        for (File currentItem : FilesArray){
            if (currentItem.isFile()){
                allFiles.add(currentItem);
            }
            else if (currentItem.isDirectory()){
                for (File innerFile : getAllFilesRecursivley(currentItem, true)){
                    allFiles.add(innerFile);
                }
            }
            else{
                if (includeLinks){
                    allFiles.add(currentItem);
                }
            }
        }
        return allFiles;
    }

    public static void findBrokenLinks(Path pathToFolder) throws IOException{
        for (File currentFile : getAllFilesRecursivley(pathToFolder.toFile(), true)){
            if (Files.isSymbolicLink(currentFile.toPath())){
                File tempFile = new File(Files.readSymbolicLink(currentFile.toPath()).toString());
                if (!tempFile.exists()){
                    System.out.println(currentFile.getPath());
                }
            }
        }
    }

    public static String reduceFilePath(Path filePath){
        return filePath.normalize().toString();
    }

    public static String readFrom(File file) throws IOException{
        String toReturn = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String currentLine = "";
            while ((currentLine = reader.readLine()) != null){
                toReturn += currentLine;
            }
        }
        catch (IOException e){
            throw  e;
        }

        return toReturn;
    }

    public static String readFrom(Path path) throws IOException{
        return readFrom(path.toFile());
    }

    public static void writeTo(File file, String content) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write(content);
        }catch (IOException e){
            throw e;
        }
    }

    public static void writeTo(Path path, String content) throws IOException{
        writeTo(path.toFile(), content);
    }
}
