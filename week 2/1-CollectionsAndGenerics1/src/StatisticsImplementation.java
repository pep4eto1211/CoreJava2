import java.util.*;

public class StatisticsImplementation implements Statistics {
    public StatisticsImplementation() {
    }

    private List<Integer> numbers = new ArrayList<Integer>();
    Map<Integer, Integer> histogram = new HashMap<>();

    private int mode = 0;
    private int median = 0;
    private int mean = 0;
    private int range = 0;

    public void add(int number){
        numbers.add(number);
        Collections.sort(numbers);
        range = numbers.get(numbers.size() - 1) - numbers.get(0);
        mean = numbers.stream().mapToInt(n -> n).sum() / numbers.size();
        median = numbers.get(numbers.size() / 2);
        if (histogram.containsKey(number)){
            int count = histogram.get(number);
            count++;
            histogram.put(number, count);
        }
        else{
            histogram.put(number, 0);
        }
        int maxNum = Integer.MIN_VALUE;
        Iterator it = histogram.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer, Integer> currentEntry = (Map.Entry<Integer, Integer>)it.next();
            if (currentEntry.getValue() > maxNum){
                mode = currentEntry.getKey();
            }
        }
    }

    public Iterator<Integer> iterator() {
        return numbers.iterator();
    }

    @Override
    public int getMean() {
        return this.mean;
    }

    @Override
    public int getMedian() {
        return this.median;
    }

    @Override
    public int getMode() {
        return this.mode;
    }

    @Override
    public int getRange() {
        return this.range;
    }
}
