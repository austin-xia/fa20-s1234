package hw2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Percolation_test {

    public Percolation test;

    @Test
    public void test(){
        test = new Percolation(4);
        test.open(1,1);
        test.open(2,2);
        test.open(0,0);
        test.open(0,1);
        assertTrue(test.isFull(1,1));

    }
}
