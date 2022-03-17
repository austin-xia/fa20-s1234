package bearmaps;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.util.List;

public class PointSetTest {

    @Test
    public void NaivePointSetTest(){
        Point p1 = new Point(1.1, 2.2); // constructs a Point with x = 1.1, y = 2.2
        Point p2 = new Point(3.3, 4.4);
        Point p3 = new Point(-2.9, 4.2);

        NaivePointSet nn = new NaivePointSet(List.of(p1, p2, p3));
        Point ret = nn.nearest(3.0, 4.0); // returns p2
        ret.getX(); // evaluates to 3.3
        ret.getY(); // evaluates to 4.4



    }

    @Test
    public void KDTreeTest(){
        Point p1 = new Point(1.1, 2.2); // constructs a Point with x = 1.1, y = 2.2
        Point p2 = new Point(3.3, 4.4);
        Point p3 = new Point(-2.9, 4.2);
        Point p4 = new Point(3.3, 4.5);
        Point p5 = new Point(5, 4.5);
        Point p6 = new Point(2, 6);
        Point p7 = new Point(100, 4);
        Point p8 = new Point(101, 4.2);
        Point p9 = new Point(-100, 100);

        KDTree nn = new KDTree(List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9));
        Point ret = nn.nearest(3.0, 4.0);
        Point ret2 = nn.nearest(5, 4.6);


    }



}
