import java.io.File;
import java.util.ArrayList;

public class FileUtils {
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

}
