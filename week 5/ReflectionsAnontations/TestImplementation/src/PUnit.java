import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PUnit {
    private Map<String, Boolean> testResults = new HashMap<>();
    private Class testClass;

    public PUnit(Class testClass) {
        this.testClass = testClass;
    }

    public void runTests() throws IllegalAccessException, InvocationTargetException{
        Method[] allMethods = testClass.getMethods();
        for (Method singleMethod : allMethods){
            Annotation[] allAnnotations = singleMethod.getDeclaredAnnotations();
            for (Annotation singleAnnotation : allAnnotations){
                if (singleAnnotation instanceof Before){
                    singleMethod.invoke(null, null);
                    testResults.put(singleMethod.getName(), PUnit.tempResult);
                    PUnit.tempResult = true;
                }
            }
        }

        for (Method singleMethod : allMethods){
            Annotation[] allAnnotations = singleMethod.getDeclaredAnnotations();
            for (Annotation singleAnnotation : allAnnotations){
                if (singleAnnotation instanceof Test){
                    singleMethod.invoke(null, null);
                    testResults.put(singleMethod.getName(), PUnit.tempResult);
                    PUnit.tempResult = true;
                }
            }
        }

        for (Method singleMethod : allMethods){
            Annotation[] allAnnotations = singleMethod.getDeclaredAnnotations();
            for (Annotation singleAnnotation : allAnnotations){
                if (singleAnnotation instanceof After){
                    singleMethod.invoke(null, null);
                    testResults.put(singleMethod.getName(), PUnit.tempResult);
                    PUnit.tempResult = true;
                }
            }
        }

        Iterator it = testResults.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.print(pair.getKey() + " : ");
            if ((boolean)(pair.getValue()) == true){
                System.out.print("Passed");
            }
            else{
                System.out.print("Failed");
            }

            System.out.println();

            it.remove(); // avoids a ConcurrentModificationException
        }
    }

    public static boolean tempResult = true;

    public static void testThis(byte expected, byte actual){
        PUnit.tempResult = PUnit.tempResult && (expected == actual);
    }

    public static void testThis(short expected, short actual){
        PUnit.tempResult = PUnit.tempResult && (expected == actual);
    }

    public static void testThis(int expected, int actual){
        PUnit.tempResult = PUnit.tempResult && (expected == actual);
    }

    public static void testThis(long expected, long actual){
        PUnit.tempResult = PUnit.tempResult && (expected == actual);
    }

    public static void testThis(float expected, float actual){
        PUnit.tempResult = PUnit.tempResult && (expected == actual);
    }

    public static void testThis(double expected, double actual){
        PUnit.tempResult = PUnit.tempResult && (expected == actual);
    }

    public static void testThis(char expected, char actual){
        PUnit.tempResult = PUnit.tempResult && (expected == actual);
    }

    public static void testThis(String expected, String actual){
        PUnit.tempResult = PUnit.tempResult && expected.equals(actual);
    }

    public static void testThis(boolean expected, boolean actual){
        PUnit.tempResult = PUnit.tempResult && (expected == actual);
    }

    public static void testThis(Object expected, Object actual){
        PUnit.tempResult = PUnit.tempResult && expected.equals(actual);
    }

    public static void testThis(byte[] expected, byte[] actual){
        PUnit.tempResult = PUnit.tempResult && Arrays.equals(expected, actual);
    }

    public static void testThis(short[] expected, short[] actual){
        PUnit.tempResult = PUnit.tempResult && Arrays.equals(expected, actual);
    }

    public static void testThis(int[] expected, int[] actual){
        PUnit.tempResult = PUnit.tempResult && Arrays.equals(expected, actual);
    }

    public static void testThis(long[] expected, long[] actual){
        PUnit.tempResult = PUnit.tempResult && Arrays.equals(expected, actual);
    }

    public static void testThis(float[] expected, float[] actual){
        PUnit.tempResult = PUnit.tempResult && Arrays.equals(expected, actual);
    }

    public static void testThis(double[] expected, double[] actual){
        PUnit.tempResult = PUnit.tempResult && Arrays.equals(expected, actual);
    }

    public static void testThis(char[] expected, char[] actual){
        PUnit.tempResult = PUnit.tempResult && Arrays.equals(expected, actual);
    }

    public static void testThis(String[] expected, String[] actual){
        PUnit.tempResult = PUnit.tempResult && Arrays.equals(expected, actual);
    }

    public static void testThis(boolean[] expected, boolean[] actual){
        PUnit.tempResult = PUnit.tempResult && Arrays.equals(expected, actual);
    }

    public static void testThis(Object[] expected, Object[] actual){
        PUnit.tempResult = PUnit.tempResult && Arrays.equals(expected, actual);
    }
}
