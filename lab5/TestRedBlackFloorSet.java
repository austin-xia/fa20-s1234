import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by hug.
 */
public class TestRedBlackFloorSet {
    @Test
    public void randomizedTest() {
        AListFloorSet ALfloor = new AListFloorSet();
        RedBlackFloorSet RBfloor = new RedBlackFloorSet();

        /* add 1000000 random double into floor sets */
        for (int i = 0; i < 1000000; i += 1){
            int index = StdRandom.uniform(-5000, 5000);
            ALfloor.add(index);
            RBfloor.add(index);
        }

        /* call floor 1000000 times to asset equal */
        for (int i = 0; i < 100000; i += 1){
            int indexF = StdRandom.uniform(-5000, 5000);
            assertEquals(ALfloor.floor(indexF), RBfloor.floor(indexF), 0.000001);
        }

    }
}
