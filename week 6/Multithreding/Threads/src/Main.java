import java.util.*;

public class Main {
    public static Map<Point, Point> nearest = new HashMap<>();
    public static List<Point> points = new ArrayList<>();
    public static List<Point> pointsSortX;
    public static List<Point> pointsSortY;

    public static void getNearestPoints(List<Point> generatedPoints){
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                doCalculations(generatedPoints, 0, 50_000, nearest);
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                doCalculations(generatedPoints, 50_001, 99_999, nearest);
            }
        });

        a.start();
        b.start();

        try {
            a.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void doCalculations(List<Point> points, int indexFrom, int indexTo, Map<Point, Point> nearest){

        for (int i = indexFrom; i <= indexTo; i++){
            double distanceA;
            double distanceB;
            if (i == indexFrom){
                distanceA = pointsSortX.get(i).getDistance(pointsSortX.get(i + 1));
                distanceB = Double.MAX_VALUE;
            }
            else if(i == indexTo){
                distanceB = pointsSortX.get(i).getDistance(pointsSortX.get(i - 1));
                distanceA = Double.MAX_VALUE;
            }
            else {
                distanceA = pointsSortX.get(i).getDistance(pointsSortX.get(i + 1));
                distanceB = pointsSortX.get(i).getDistance(pointsSortX.get(i - 1));
            }

            double minDistance = Double.min(distanceA, distanceB);
            int indexX;
            if (minDistance == distanceA){
                indexX = i + 1;
            }
            else{
                indexX = i - 1;
            }

            double distanceYA;
            double distanceYB;

            int j = pointsSortY.indexOf(pointsSortX.get(i));

            if (j == 0){
                distanceYA = pointsSortY.get(j).getDistance(pointsSortY.get(j + 1));
                distanceYB = Double.MAX_VALUE;
            }
            else if(i == 99_999){
                distanceYB = pointsSortY.get(j).getDistance(pointsSortY.get(j - 1));
                distanceYA = Double.MAX_VALUE;
            }
            else {
                distanceYA = pointsSortY.get(j).getDistance(pointsSortY.get(j + 1));
                distanceYB = pointsSortY.get(j).getDistance(pointsSortY.get(j - 1));
            }

            double minDistanceY = Double.min(distanceYA, distanceYB);
            int indexY;
            if (minDistance == distanceYA){
                indexY = i + 1;
            }
            else{
                indexY = i - 1;
            }

            if(minDistanceY < minDistance){
                nearest.put(pointsSortX.get(i), pointsSortY.get(indexY));
            }
            else {
                nearest.put(pointsSortX.get(i), pointsSortY.get(indexX));
            }
        }
    }

    public static void main(String[] args){
        for (int i = 0; i < 100_000; i++){
            Random rand = new Random();
            int x = rand.nextInt(10_000);
            int y = rand.nextInt(10_000);
            Point a = new Point(x, y);
            points.add(a);
        }

        pointsSortX = points;
        pointsSortY = points;

        Collections.sort(pointsSortX, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.compareX(o2);
            }
        });

        Collections.sort(pointsSortY, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.compareY(o2);
            }
        });

        long start = System.currentTimeMillis();
        getNearestPoints(points);
        System.out.println(System.currentTimeMillis() - start);
    }
}
