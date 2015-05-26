public class Point {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareX(Point B){
        if (this.getX() > B.getX()){
            return 1;
        }
        else if(this.getX() < B.getX()){
            return -1;
        }
        else{
            return 0;
        }
    }

    public int compareY(Point B){
        if (this.getY() > B.getY()){
            return 1;
        }
        else if(this.getY() < B.getY()){
            return -1;
        }
        else{
            return 0;
        }
    }

    public double getDistance(Point B){
        return (Math.sqrt(Math.abs(Math.pow((B.getX() - this.getX()), 2)) + Math.abs(Math.pow((B.getY() - this.getY()), 2))));
    }
}
