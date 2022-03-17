package bearmaps;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KDTreeTest {

    @Test
    public void randomizedTest() {
        KDTree PS_K = new KDTree();
        NaivePointSet PS_N = new NaivePointSet();
        int size = 100;

        /* add 10000 random double into Point sets */
        for (int i = 0; i < 10000; i += 1){
            double x = Math.random() * size;
            double y = Math.random() * size;
            Point add = new Point(x, y);
            PS_K.add(add);
            PS_N.add(add);
        }

        /* call 10000 times to asset equal */
        for (int i = 0; i < 10000; i += 1){
            double x = Math.random() * size;
            double y = Math.random() * size;
            Point target = new Point(x,y);
            Point K = PS_K.nearest(x,y);
            Point N = PS_N.nearest(x,y);
            double tK = Point.distance(target, K);
            double tN = Point.distance(target, N);
            assertEquals(tK, tN, 0.000001);
        }







    }
}
