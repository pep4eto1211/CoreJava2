import java.util.*;

public class CollectionsMethods{
    static boolean isExpressionOfBracketsCorrect(String expression){
        int openingBrackets = 0;
        int closingBrackets = 0;
        for (int i = 0; i < expression.length(); i++){
            if (expression.charAt(i) == '('){
                openingBrackets++;
            }
            else{
                closingBrackets++;
                if (closingBrackets > openingBrackets){
                    return false;
                }
            }
        }
        if (openingBrackets == closingBrackets) {
            return true;
        }
        return false;
    }

    static int[] rotate(Collection<Integer> collection, int rotateStep){
        int[] rotatedArray = new int[collection.size()];
        int i = -1;
        int newIndex = 0;
        for (int number : collection){
            i++;
            newIndex = i + rotateStep;
            if (newIndex > collection.size() - 1){
                newIndex -= collection.size();
            }

            if (newIndex < 0){
                newIndex += collection.size();
            }

            rotatedArray[newIndex] = number;
        }

        return rotatedArray;
    }

    public static int firstUnique(int[] array){
        Map<Integer, Integer> histogram = new LinkedHashMap<Integer, Integer>();
        for (int i : array){
            if (histogram.containsKey(i)){
                int count = histogram.get(i);
                count++;
                histogram.replace(i, histogram.get(i), count);
            }
            else{
                histogram.put(i, 1);
            }
        }
        Iterator it = histogram.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> pair = (Map.Entry)it.next();
            if (pair.getValue() == 1){
                return pair.getKey();
            }
        }
        return 0;
    }

    public static Integer[] getDuplicating(List<Integer> a, List<Integer> b, List<Integer> c){
        List<Integer> d = new ArrayList<Integer>();
        int aLength = a.size();
        int bLength = b.size();
        int cLength = c.size();
        int minLength = Integer.min(aLength, Integer.min(bLength, cLength));
        List<Integer> toIterate;
        if (minLength == aLength){
            toIterate = a;
        }
        else
        if (minLength == bLength){
            toIterate = b;
        }
        else{
            toIterate = c;
        }

        for (int i : toIterate){
            if (a.contains(i) && b.contains(i) && c.contains(i)){
                d.add(i);
            }
            else{
                System.out.println(i);
            }
        }
        Integer[] returnArray = new Integer[d.size()];
        returnArray = d.toArray(returnArray);
        return returnArray;
    }

    public static void sortStudents(List<Student> students){
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getGrade() != o2.getGrade()){
                    return o1.getGrade() - o2.getGrade();
                }
                else{
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });
    }

    public static void reverse(Collection<Integer> collection){
        Integer swapper;
        Integer[] collectionArray = collection.toArray(new Integer[collection.size()]);
        for (int i = 0; i < collectionArray.length / 2; i++){
            swapper = collectionArray[i];
            collectionArray[i] = collectionArray[collectionArray.length - 1 - i];
            collectionArray[collectionArray.length - 1 - i] = swapper;
        }
        collection.clear();
        for (Integer singleElement : collectionArray){
            collection.add(singleElement);
        }
    }

    public static Map<String, Integer> countOccurances(String text){
        Map<String, Integer> toReturn = new HashMap<>();
        String[] words = text.split(" ");
        for (String word : words){
            if (toReturn.containsKey(word)){
                int count = toReturn.get(word);
                count++;
                toReturn.put(word, count);
            }
            else {
                toReturn.put(word, 1);
            }
        }
        return toReturn;
    }

    public static String getReadableVersion(HashMap<? extends Object, ? extends Object> map){
        String toReturn = "";
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry a = (Map.Entry)it.next();
            toReturn += a.getKey().toString() + " = " + a.getValue().toString();
            toReturn += '\n';
        }
        return toReturn;
    }
}
