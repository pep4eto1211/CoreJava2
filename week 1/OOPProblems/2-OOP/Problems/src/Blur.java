public class Blur implements MatrixOperation {
    public Blur() {
    }

    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        float avgRed = 0;
        float avgGreen = 0;
        float avgBlue = 0;
        if (x == 0){
            if (y == 0){
                avgRed = matrix[0][1].getR() + matrix[1][1].getR() + matrix[1][0].getR();
                avgRed /= 3;
                avgGreen = matrix[0][1].getG() + matrix[1][1].getG() + matrix[1][0].getG();
                avgGreen /= 3;
                avgBlue = matrix[0][1].getB() + matrix[1][1].getB() + matrix[1][0].getB();
                avgBlue /= 3;
                return new Pixel(avgRed, avgGreen, avgBlue);
            }
            else if (y == matrix[0].length - 1){
                avgRed = matrix[0][matrix[0].length - 2].getR() + matrix[1][matrix[0].length - 2].getR() +
                        matrix[1][matrix[0].length - 1].getR();
                avgRed /= 3;
                avgGreen = matrix[0][matrix[0].length - 2].getG() + matrix[1][matrix[0].length - 2].getG() +
                        matrix[1][matrix[0].length - 1].getG();
                avgGreen /= 3;
                avgBlue = matrix[0][matrix[0].length - 2].getB() + matrix[1][matrix[0].length - 2].getB() +
                        matrix[1][matrix[0].length - 1].getB();
                avgBlue /= 3;
                return new Pixel(avgRed, avgGreen, avgBlue);
            }
            else {
                avgRed = matrix[x][y - 1].getR() + matrix[x][y + 1].getR() + matrix[x + 1][y - 1].getR() +
                        matrix[x + 1][y].getR() + matrix[x + 1][y + 1].getR();
                avgRed /= 5;
                avgGreen = matrix[x][y - 1].getG() + matrix[x][y + 1].getG() + matrix[x + 1][y - 1].getG() +
                        matrix[x + 1][y].getG() + matrix[x + 1][y + 1].getG();
                avgGreen /= 5;
                avgBlue = matrix[x][y - 1].getB() + matrix[x][y + 1].getB() + matrix[x + 1][y - 1].getB() +
                        matrix[x + 1][y].getB() + matrix[x + 1][y + 1].getB();
                avgBlue /= 5;
                return new Pixel(avgRed, avgGreen, avgBlue);
            }
        }
        else if (x == matrix.length - 1){
            if (y == 0){
                avgRed = matrix[matrix.length - 1][1].getR() + matrix[matrix.length - 2][1].getR() +
                        matrix[matrix.length - 2][0].getR();
                avgRed /= 3;
                avgGreen = matrix[matrix.length - 1][1].getG() + matrix[matrix.length - 2][1].getG() +
                        matrix[matrix.length - 2][0].getG();
                avgGreen /= 3;
                avgBlue = matrix[matrix.length - 1][1].getB() + matrix[matrix.length - 2][1].getB() +
                        matrix[matrix.length - 2][0].getB();
                avgBlue /= 3;
                return new Pixel(avgRed, avgGreen, avgBlue);
            }
            else if (y == matrix[0].length - 1){
                avgRed = matrix[matrix.length - 1][matrix[0].length - 2].getR() + 
                        matrix[matrix.length - 2][matrix[0].length - 2].getR() + 
                        matrix[matrix.length - 2][matrix[0].length - 1].getR();
                avgRed /= 3;
                avgGreen = matrix[matrix.length - 1][matrix[0].length - 2].getG() + 
                        matrix[matrix.length - 2][matrix[0].length - 2].getG() +
                        matrix[matrix.length - 2][matrix[0].length - 1].getG();
                avgGreen /= 3;
                avgBlue = matrix[matrix.length - 1][matrix[0].length - 2].getB() + 
                        matrix[matrix.length - 2][matrix[0].length - 2].getB() +
                        matrix[matrix.length - 2][matrix[0].length - 1].getB();
                avgBlue /= 3;
                return new Pixel(avgRed, avgGreen, avgBlue);
            }
            else {
                avgRed = matrix[x][y - 1].getR() + matrix[x][y + 1].getR() + matrix[x - 1][y - 1].getR() +
                        matrix[x - 1][y].getR() + matrix[x - 1][y + 1].getR();
                avgRed /= 5;
                avgGreen = matrix[x][y - 1].getG() + matrix[x][y + 1].getG() + matrix[x - 1][y - 1].getG() +
                        matrix[x - 1][y].getG() + matrix[x - 1][y + 1].getG();
                avgGreen /= 5;
                avgBlue = matrix[x][y - 1].getB() + matrix[x][y + 1].getB() + matrix[x - 1][y - 1].getB() +
                        matrix[x - 1][y].getB() + matrix[x - 1][y + 1].getB();
                avgBlue /= 5;
                return new Pixel(avgRed, avgGreen, avgBlue);
            }
        }
        else if (y == 0){
            avgRed = matrix[x - 1][0].getR() + matrix[x + 1][0].getR() + matrix[x - 1][1].getR() + matrix[x][1].getR() +
                    matrix[x + 1][1].getR();
            avgRed /= 5;
            avgGreen = matrix[x - 1][0].getG() + matrix[x + 1][0].getG() + matrix[x - 1][1].getG() +
                    matrix[x][1].getG() + matrix[x + 1][1].getG();
            avgGreen /= 5;
            avgBlue = matrix[x - 1][0].getB() + matrix[x + 1][0].getB() + matrix[x - 1][1].getB() +
                    matrix[x][1].getB() + matrix[x + 1][1].getB();
            avgBlue /= 5;
            return new Pixel(avgRed, avgGreen, avgBlue);
        }
        else if (y == matrix[0].length - 1){
            avgRed = matrix[x - 1][matrix[0].length - 1].getR() + matrix[x + 1][matrix[0].length - 1].getR() +
                    matrix[x - 1][matrix[0].length - 2].getR() + matrix[x][matrix[0].length - 2].getR() +
                    matrix[x + 1][matrix[0].length - 2].getR();
            avgRed /= 5;
            avgGreen = matrix[x - 1][matrix[0].length - 1].getG() + matrix[x + 1][matrix[0].length - 1].getG() +
                    matrix[x - 1][matrix[0].length - 2].getG() + matrix[x][matrix[0].length - 2].getG() +
                    matrix[x + 1][matrix[0].length - 2].getG();
            avgGreen /= 5;
            avgBlue = matrix[x - 1][matrix[0].length - 1].getB() + matrix[x + 1][matrix[0].length - 1].getB() +
                    matrix[x - 1][matrix[0].length - 2].getB() + matrix[x][matrix[0].length - 2].getB() +
                    matrix[x + 1][matrix[0].length - 2].getB();
            avgBlue /= 5;
            return new Pixel(avgRed, avgGreen, avgBlue);
        }
        else{
            avgRed = matrix[x - 1][y - 1].getR() + matrix[x - 1][y].getR() + matrix[x - 1][y + 1].getR() +
                    matrix[x][y - 1].getR() + matrix[x][y + 1].getR() + matrix[x + 1][y - 1].getR() +
                    matrix[x + 1][y].getR() + matrix[x + 1][y + 1].getR();
            avgRed /= 8;
            avgGreen = matrix[x - 1][y - 1].getG() + matrix[x - 1][y].getG() + matrix[x - 1][y + 1].getG() +
                    matrix[x][y - 1].getG() + matrix[x][y + 1].getG() + matrix[x + 1][y - 1].getG() +
                    matrix[x + 1][y].getG() + matrix[x + 1][y + 1].getG();
            avgGreen /= 8;
            avgBlue = matrix[x - 1][y - 1].getB() + matrix[x - 1][y].getB() + matrix[x - 1][y + 1].getB() +
                    matrix[x][y - 1].getB() + matrix[x][y + 1].getB() + matrix[x + 1][y - 1].getB() +
                    matrix[x + 1][y].getB() + matrix[x + 1][y + 1].getB();
            avgBlue /= 8;
            return new Pixel(avgRed, avgGreen, avgBlue);
        }
    }
}
