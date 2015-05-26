import com.nitido.utils.toaster.Toaster;
import org.apache.commons.mail.EmailException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        FileDownloader down = new FileDownloader("http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg",
                "D://down.png");
        try {
            down.downloadFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
