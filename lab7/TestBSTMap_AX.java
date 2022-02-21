import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TestBSTMap_AX {

    @Test
    public void test_map (){
        BSTMap<Integer, String> test_map = new BSTMap(4, "four");
        String test;
        test_map.put(3, "three");
        test_map.put(1, "one");
        test_map.put(6, "six");
        test_map.put(5, "five");
        test_map.put(8, "eight");
        test_map.printInOrder();
        if (test_map.containsKey(10)){
            test = test_map.get(4);
            System.out.println(test);
        }
        assertEquals(6, test_map.size());
    }







}
