import java.util.HashMap;
import java.util.Map;

public class GetMostUsedColor implements MatrixOperation {
    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        throw new UnsupportedOperationException();
    }

    public static Pixel mostUsedColor(Pixel[][] matrix){
        Map.Entry<String, Float> maxEntry = null;
        maxEntry.setValue(-1f);
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
        for (Map.Entry<String, Float> entry : colorUsageMap.entrySet()){
            if (entry.getValue() > maxEntry.getValue()){
                maxEntry = entry;
            }
        }
        return Pixel.fromStrng(maxEntry.getKey());
    }
}
