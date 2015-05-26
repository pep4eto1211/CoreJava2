import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class FileDownloader {
    private String m_fileUrl;
    private String m_saveLocation;

    public FileDownloader(String fileUrl, String saveLocation) {
        this.m_fileUrl = fileUrl;
        this.m_saveLocation = saveLocation;
    }

    public void downloadFile() throws IOException{
        BufferedImage img = null;
        URL url = new URL(m_fileUrl);
        img = ImageIO.read(url);
        File saveFile = new File(m_saveLocation);
        ImageIO.write(img, "PNG", saveFile);
    }
}
