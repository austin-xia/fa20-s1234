import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class hashMap_test {

    @Test
    public void test () {
        MyHashMap<String, Integer> test = new MyHashMap<>(8);
        test.put("one", 1);
        test.put("two", 2);
        test.put("three", 3);
        test.put("four", 4);
        test.put("five", 5);
        test.put("six", 66);
        test.put("six", 6);
        assertTrue(test.containsKey("six"));
        int helper = test.get("six");
        assertEquals(6, helper);
        Set helper2 = test.keySet();
        test.put("seven", 7);
        test.put("eight", 8);
        helper2 = test.keySet();
    }

}
