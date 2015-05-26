import com.nitido.utils.toaster.Toaster;

import java.awt.*;

public class TakeARestNotification {
    private int m_width;
    private int m_height;
    private Image m_background;
    private String m_text;
    private int m_screenTime;
    private Color m_borderColor;
    private Font m_textFont;

    public TakeARestNotification(int width, int height, Image background, String text,
                                 int screenTime, Color borderColor, Font messageFont) {
        this.m_width = width;
        this.m_height = height;
        this.m_background = background;
        this.m_text = text;
        this.m_screenTime = screenTime;
        this.m_borderColor = borderColor;
        this.m_textFont = messageFont;
    }

    public void showCycleNotification(int cycleTime) throws InterruptedException{
        Thread.sleep(cycleTime);
        showNotification();
        showCycleNotification(cycleTime);
    }

    public void showNotification(){
        Toaster toasterManager = new Toaster();
        toasterManager.setToasterWidth(m_width);
        toasterManager.setToasterHeight(m_height);
        toasterManager.setBackgroundImage(m_background);
        toasterManager.setDisplayTime(m_screenTime);
        toasterManager.setBorderColor(m_borderColor);
        toasterManager.setToasterMessageFont(m_textFont);
        toasterManager.showToaster(m_text);
    }
}
