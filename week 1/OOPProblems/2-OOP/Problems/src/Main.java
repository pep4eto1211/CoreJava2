import java.io.IOException;

public class Main {
    public static void main(String[] args){
        Pixel[][] matrix = new Pixel[2][2];
        matrix[0][0] = new Pixel(1, 2, 3);
        matrix[0][1] = new Pixel(1, 2, 4);
        matrix[1][0] = new Pixel(1, 2, 5);
        matrix[1][1] = new Pixel(1, 2, 6);
        Matrix image = new Matrix(matrix);
        image.operate(new Blur());
        System.out.println(image.toString());
    }
}
