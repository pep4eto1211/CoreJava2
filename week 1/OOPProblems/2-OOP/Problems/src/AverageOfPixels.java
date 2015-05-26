public class AverageOfPixels implements MatrixOperation {
    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        throw new UnsupportedOperationException();
    }

    public static Pixel averagePixels(Pixel[][] matrix){
        float avgRed = 0;
        float avgGreen = 0;
        float avgBlue = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                avgRed += matrix[i][j].getR();
                avgGreen += matrix[i][j].getG();
                avgBlue += matrix[i][j].getB();
            }
        }
        float allPixels = matrix.length * matrix[0].length;
        return new Pixel(avgRed / allPixels, avgGreen / allPixels, avgBlue / allPixels);
    }
}
