public class Binarization implements MatrixOperation {
    private int m_threshold;

    public Binarization(int threshold) {
        this.m_threshold = threshold;
    }

    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        if (((matrix[x][y].getR()) + (matrix[x][y].getG()) + (matrix[x][y].getB())) / 3 >= m_threshold){
            return new Pixel(255, 255, 255);
        }
        else {
            return new Pixel(0, 0, 0);
        }
    }
}
