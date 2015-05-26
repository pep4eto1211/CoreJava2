
public class ATest {
    @Test
    public static void daTest(){
        PUnit.testThis(true, A.da());
    }


    @Test
    public static void daaTest(){
        PUnit.testThis(true, A.daa());
    }

    @Test
    public static void bothTest(){
        PUnit.testThis(true, A.da());
        PUnit.testThis(false, A.daa());
    }
}
