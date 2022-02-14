package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(3);
        arb.enqueue(1);
        assertEquals(1,arb.fillcount());
        arb.enqueue(2);
        assertEquals(2,arb.fillcount());
        arb.enqueue(3);
        assertEquals(3,arb.fillcount());
        arb.enqueue(4);
        assertEquals(3,arb.fillcount());
        arb.enqueue(5);
        assertEquals(3,arb.fillcount());
        assertEquals(3,arb.capacity());

        /* test the dequeue and peek function **/
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();
        arb.enqueue(4);
        arb.enqueue(5);
        arb.dequeue();
        arb.dequeue();
        arb.enqueue(6);
        assertEquals(1,arb.fillcount());
        arb.enqueue(7);
        arb.enqueue(8);
        int sum = 0;
        for (int i : arb){
            sum += i;
        }
        assertEquals(6+7+8,sum);
    }
}
