import java.lang.reflect.InvocationTargetException;

/**
 * Created by Peter on 05-May-15.
 */
public class Main {
    public static void main(String[] args){
        PUnit unitTest = new PUnit(ATest.class);
        try {
            unitTest.runTests();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
