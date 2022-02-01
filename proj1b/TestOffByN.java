import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {

    static CharacterComparator offByN = new OffByN(2);

    // Your tests go here.
    @Test
    public void TestOffByOne (){
        assertTrue(offByN.equalChars('a','c'));
        assertTrue(offByN.equalChars('e','c'));
        assertFalse(offByN.equalChars('a','a'));
        assertFalse(offByN.equalChars('a','b'));

    }
}
