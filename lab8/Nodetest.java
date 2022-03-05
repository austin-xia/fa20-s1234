import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Nodetest {

    @Test
    public void test (){
        Node<Integer, String> node = new Node<> (1, "one");
        node.add(2, "two");
        node.add(3, "three");
        node.add(4, "four");
        node.add(5, "five");
        node.add(6, "six");
        node.add(7, "seven");
        node.contains(6);
    }


}
