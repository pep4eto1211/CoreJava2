import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Matrix {
    private Pixel[][] m_pixelMatrix;

    public Matrix(String imagePath) throws IOException{
        BufferedImage image = ImageIO.read(new File(imagePath));
        m_pixelMatrix = new Pixel[image.getHeight()][image.getWidth()];
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color currentCollor = new Color(image.getRGB(i, j));
                m_pixelMatrix[j][i] = new Pixel(currentCollor.getRed(), currentCollor.getGreen(),
                        currentCollor.getBlue());
            }
        }
    }

    public Matrix (Pixel[][] pixelMatrix){
        m_pixelMatrix = pixelMatrix;
    }

    public Pixel getPixel(int row, int column){
        return m_pixelMatrix[row][column];
    }

    public void setPixel(int row, int column, Pixel newPixel){
        m_pixelMatrix[row][column] = newPixel;
    }

    public void operate(MatrixOperation operation){
        for (int i = 0; i < m_pixelMatrix.length; i++){
            for (int j = 0; j < m_pixelMatrix[0].length; j++) {
                m_pixelMatrix[i][j] = operation.withPixel(i, j, m_pixelMatrix);
            }
        }
    }

    public String toString(){
        String matrixString = "";
        for (int i = 0; i < m_pixelMatrix.length; i++){
            for (int j = 0; j < m_pixelMatrix[0].length; j++){
                matrixString += "[" + m_pixelMatrix[i][j].getR() + ", " + m_pixelMatrix[i][j].getG() + ", "
                        + m_pixelMatrix[i][j].getB() + "] ";
            }
            matrixString += '\n';
        }
        return matrixString;
    }
}
