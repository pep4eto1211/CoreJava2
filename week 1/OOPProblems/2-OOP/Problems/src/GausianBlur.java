public class GausianBlur implements MatrixOperation {
    public GausianBlur() {
    }

    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        float avgRed = 0;
        float avgGreen = 0;
        float avgBlue = 0;

        float cornerValue = 0.077847f;
        float nearValue = 0.123317f;
        float centerValue = 0.195346f;

        if (x == 0){
            if (y == 0){
                avgRed = matrix[0][1].getR() * nearValue + matrix[1][1].getR() * cornerValue +
                        matrix[1][0].getR() * nearValue + matrix[x][y].getR() * centerValue;
                avgRed /= 4;
                avgGreen = matrix[0][1].getG() * nearValue + matrix[1][1].getG() * cornerValue +
                        matrix[1][0].getG() * nearValue + matrix[x][y].getG() * centerValue;
                avgGreen /= 4;
                avgBlue = matrix[0][1].getB() * nearValue + matrix[1][1].getB() * cornerValue
                        + matrix[1][0].getB() * nearValue + matrix[x][y].getB() * centerValue;
                avgBlue /= 4;
                return new Pixel(avgRed, avgGreen, avgBlue);
            }
            else if (y == matrix[0].length - 1){
                avgRed = matrix[0][matrix[0].length - 2].getR() * nearValue +
                        matrix[1][matrix[0].length - 2].getR() * cornerValue + matrix[1][matrix[0].length - 1].getR() *
                        nearValue + matrix[x][y].getR() * centerValue;
                avgRed /= 4;
                avgGreen = matrix[0][matrix[0].length - 2].getG() * nearValue + matrix[1][matrix[0].length - 2].getG() *
                        cornerValue + matrix[1][matrix[0].length - 1].getG() * nearValue + + matrix[x][y].getG() *
                        centerValue;
                avgGreen /= 4;
                avgBlue = matrix[0][matrix[0].length - 2].getB() * nearValue + matrix[1][matrix[0].length - 2].getB() *
                        cornerValue + matrix[1][matrix[0].length - 1].getB() * nearValue + matrix[x][y].getB() *
                        centerValue;
                avgBlue /= 4;
                return new Pixel(avgRed, avgGreen, avgBlue);
            }
            else {
                avgRed = matrix[x][y - 1].getR() * nearValue + matrix[x][y + 1].getR() * nearValue +
                        matrix[x + 1][y - 1].getR() * cornerValue + matrix[x + 1][y].getR() * nearValue
                        + matrix[x + 1][y + 1].getR() * cornerValue + matrix[x][y].getR() * centerValue;
                avgRed /= 6;
                avgGreen = matrix[x][y - 1].getG() * nearValue + matrix[x][y + 1].getG() * nearValue +
                        matrix[x + 1][y - 1].getG() * cornerValue + matrix[x + 1][y].getG() * nearValue +
                        matrix[x + 1][y + 1].getG() * cornerValue + matrix[x][y].getG() * centerValue;
                avgGreen /= 6;
                avgBlue = matrix[x][y - 1].getB() * nearValue + matrix[x][y + 1].getB() * nearValue +
                        matrix[x + 1][y - 1].getB() * cornerValue + matrix[x + 1][y].getB() * nearValue +
                        matrix[x + 1][y + 1].getB() * cornerValue + matrix[x][y].getB() * centerValue;
                avgBlue /= 6;
                return new Pixel(avgRed, avgGreen, avgBlue);
            }
        }
        else if (x == matrix.length - 1){
            if (y == 0){
                avgRed = matrix[matrix.length - 1][1].getR() * nearValue + matrix[matrix.length - 2][1].getR() *
                        cornerValue + matrix[matrix.length - 2][0].getR() * nearValue + matrix[x][y].getR() *
                        centerValue;
                avgRed /= 4;
                avgGreen = matrix[matrix.length - 1][1].getG() * nearValue + matrix[matrix.length - 2][1].getG() *
                        cornerValue + matrix[matrix.length - 2][0].getG() * nearValue + matrix[x][y].getG() *
                        centerValue;
                avgGreen /= 4;
                avgBlue = matrix[matrix.length - 1][1].getB() * nearValue + matrix[matrix.length - 2][1].getB() *
                        cornerValue + matrix[matrix.length - 2][0].getB() * nearValue + matrix[x][y].getB() *
                        centerValue;
                avgBlue /= 4;
                return new Pixel(avgRed, avgGreen, avgBlue);
            }
            else if (y == matrix[0].length - 1){
                avgRed = matrix[matrix.length - 1][matrix[0].length - 2].getR() * nearValue +
                        matrix[matrix.length - 2][matrix[0].length - 2].getR() * cornerValue +
                        matrix[matrix.length - 2][matrix[0].length - 1].getR() * nearValue + matrix[x][y].getR() *
                        centerValue;
                avgRed /= 4;
                avgGreen = matrix[matrix.length - 1][matrix[0].length - 2].getG() * nearValue +
                        matrix[matrix.length - 2][matrix[0].length - 2].getG() * cornerValue +
                        matrix[matrix.length - 2][matrix[0].length - 1].getG() * nearValue + matrix[x][y].getG() *
                        centerValue;
                avgGreen /= 4;
                avgBlue = matrix[matrix.length - 1][matrix[0].length - 2].getB() * nearValue +
                        matrix[matrix.length - 2][matrix[0].length - 2].getB() * cornerValue +
                        matrix[matrix.length - 2][matrix[0].length - 1].getB() * nearValue + matrix[x][y].getB() *
                        centerValue;
                avgBlue /= 4;
                return new Pixel(avgRed, avgGreen, avgBlue);
            }
            else {
                avgRed = matrix[x][y - 1].getR() * nearValue + matrix[x][y + 1].getR() * nearValue +
                        matrix[x - 1][y - 1].getR() * cornerValue + matrix[x - 1][y].getR() * nearValue +
                        matrix[x - 1][y + 1].getR() * cornerValue + matrix[x][y].getR() * centerValue;
                avgRed /= 6;
                avgGreen = matrix[x][y - 1].getG() * nearValue + matrix[x][y + 1].getG() * nearValue +
                        matrix[x - 1][y - 1].getG() * cornerValue + matrix[x - 1][y].getG() * nearValue +
                        matrix[x - 1][y + 1].getG() * cornerValue + matrix[x][y].getG() * centerValue;
                avgGreen /= 6;
                avgBlue = matrix[x][y - 1].getB() * nearValue + matrix[x][y + 1].getB() * nearValue +
                        matrix[x - 1][y - 1].getB() * cornerValue + matrix[x - 1][y].getB() * nearValue +
                        matrix[x - 1][y + 1].getB() * cornerValue + matrix[x][y].getB() * centerValue;
                avgBlue /= 6;
                return new Pixel(avgRed, avgGreen, avgBlue);
            }
        }
        else if (y == 0){
            avgRed = matrix[x - 1][0].getR() * nearValue + matrix[x + 1][0].getR() * nearValue +
                    matrix[x - 1][1].getR() * cornerValue + matrix[x][1].getR() * nearValue +
                    matrix[x + 1][1].getR() * cornerValue + matrix[x][y].getR() * centerValue;
            avgRed /= 6;
            avgGreen = matrix[x - 1][0].getG() * nearValue + matrix[x + 1][0].getG() * nearValue +
                    matrix[x - 1][1].getG() * cornerValue + matrix[x][1].getG() * nearValue +
                    matrix[x + 1][1].getG() * cornerValue + matrix[x][y].getG() * centerValue;
            avgGreen /= 6;
            avgBlue = matrix[x - 1][0].getB() * nearValue + matrix[x + 1][0].getB() * nearValue +
                    matrix[x - 1][1].getB() * cornerValue + matrix[x][1].getB() * nearValue +
                    matrix[x + 1][1].getB() * cornerValue + matrix[x][y].getB() * centerValue;
            avgBlue /= 6;
            return new Pixel(avgRed, avgGreen, avgBlue);
        }
        else if (y == matrix[0].length - 1){
            avgRed = matrix[x - 1][matrix[0].length - 1].getR() * nearValue +
                    matrix[x + 1][matrix[0].length - 1].getR() * nearValue +
                    matrix[x - 1][matrix[0].length - 2].getR() * cornerValue +
                    matrix[x][matrix[0].length - 2].getR() * nearValue +
                    matrix[x + 1][matrix[0].length - 2].getR() * cornerValue + matrix[x][y].getR() * centerValue;
            avgRed /= 6;
            avgGreen = matrix[x - 1][matrix[0].length - 1].getG() * nearValue +
                    matrix[x + 1][matrix[0].length - 1].getG() * nearValue +
                    matrix[x - 1][matrix[0].length - 2].getG() * cornerValue +
                    matrix[x][matrix[0].length - 2].getG() * nearValue +
                    matrix[x + 1][matrix[0].length - 2].getG() * cornerValue + matrix[x][y].getG() * centerValue;
            avgGreen /= 6;
            avgBlue = matrix[x - 1][matrix[0].length - 1].getB() * nearValue +
                    matrix[x + 1][matrix[0].length - 1].getB() * nearValue +
                    matrix[x - 1][matrix[0].length - 2].getB() * cornerValue +
                    matrix[x][matrix[0].length - 2].getB() * nearValue +
                    matrix[x + 1][matrix[0].length - 2].getB() * cornerValue + matrix[x][y].getB() * centerValue;
            avgBlue /= 6;
            return new Pixel(avgRed, avgGreen, avgBlue);
        }
        else{
            avgRed = matrix[x - 1][y - 1].getR() * cornerValue + matrix[x - 1][y].getR() * nearValue +
                    matrix[x - 1][y + 1].getR() * cornerValue + matrix[x][y - 1].getR() * nearValue +
                    matrix[x][y + 1].getR() * nearValue + matrix[x + 1][y - 1].getR() * cornerValue +
                    matrix[x + 1][y].getR() * nearValue + matrix[x + 1][y + 1].getR() * cornerValue +
                    matrix[x][y].getR() * centerValue;
            avgRed /= 9;
            avgGreen = matrix[x - 1][y - 1].getG() * cornerValue + matrix[x - 1][y].getG() * nearValue +
                    matrix[x - 1][y + 1].getG() * cornerValue + matrix[x][y - 1].getG() * nearValue +
                    matrix[x][y + 1].getG() * nearValue + matrix[x + 1][y - 1].getG() * cornerValue +
                    matrix[x + 1][y].getG() * nearValue + matrix[x + 1][y + 1].getG() * cornerValue +
                    matrix[x][y].getG() * centerValue;
            avgGreen /= 9;
            avgBlue = matrix[x - 1][y - 1].getB() * cornerValue + matrix[x - 1][y].getB() * nearValue +
                    matrix[x - 1][y + 1].getB() * cornerValue + matrix[x][y - 1].getB() * nearValue +
                    matrix[x][y + 1].getB() * nearValue + matrix[x + 1][y - 1].getB() * cornerValue +
                    matrix[x + 1][y].getB() * nearValue + matrix[x + 1][y + 1].getB() * cornerValue +
                    matrix[x][y].getB() * centerValue;
            avgBlue /= 9;
            return new Pixel(avgRed, avgGreen, avgBlue);
        }
    }
}
