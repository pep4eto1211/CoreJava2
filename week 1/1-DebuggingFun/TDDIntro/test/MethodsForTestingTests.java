import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MethodsForTestingTests {

    @Test
    public void testGetNumberOfDigits() {
        Assert.assertEquals(7, MethodsForTesting.getNumberOfDigits(1234567));
        Assert.assertEquals(2, MethodsForTesting.getNumberOfDigits(12));
        Assert.assertEquals(3, MethodsForTesting.getNumberOfDigits(100));
    }

    @Test
    public void testStichMeUp(){
        Assert.assertEquals("Аз съм пешо 3", MethodsForTesting.stichMeUp(" ", "Аз", "съм", "пешо", 3));
        Assert.assertEquals("13.2 DDSC % 412", MethodsForTesting.stichMeUp(" ", 13.2f, "DDSC", '%', 412));
    }

    @Test
    public void testReduceFilePath() {
        assertEquals("/asd/asd", MethodsForTesting.reduceFilePath("//asd/../asd/asd/"));
        assertEquals("/asd", MethodsForTesting.reduceFilePath("//asd/././././"));
        assertEquals("/", MethodsForTesting.reduceFilePath("//////////////////"));
        assertEquals("/", MethodsForTesting.reduceFilePath("/../"));
    }
}
