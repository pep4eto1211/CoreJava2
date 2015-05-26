import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Histogram implements MatrixOperation {
    public Histogram() {
    }

    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        throw new UnsupportedOperationException();
    }

    public static TreeMap<String, Float> getHistogram(Pixel[][] matrix){
        HashMap<String, Float> colorUsageMap = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (colorUsageMap.get(matrix[i][j].toString()) != null) {
                    colorUsageMap.put(matrix[i][j].toString(), colorUsageMap.get(matrix[i][j].toString()) + 1);
                }
                else{
                    colorUsageMap.put(matrix[i][j].toString(), 1f);
                }
            }
        }
        return new TreeMap<String, Float>(colorUsageMap);
    }
}
