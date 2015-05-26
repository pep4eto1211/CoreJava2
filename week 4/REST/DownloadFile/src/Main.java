import java.io.IOException;

public class Main {
    public static void main(String[] args){
        FileDownloader down = new FileDownloader(args[0], args[1]);
        try {
            down.downloadFile();
            System.out.print("Download complete!");
        } catch (IOException e) {
            System.out.print("Download failed!");
            System.out.print("Exception stack trace:");
            e.printStackTrace();
        }
    }
}
