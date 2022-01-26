import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Fliktest {

    @Test
    public void test(){
        int a = 1;
        int b = 2;
        int c = 1;
        assertEquals(a == b, Flik.isSameNumber(a,b));
        assertEquals(a == c, Flik.isSameNumber(a,c));
    }
}
