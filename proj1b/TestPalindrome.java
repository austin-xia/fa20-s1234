import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void test_isPalindrome (){
        assertTrue(palindrome.isPalindrome("aawaa"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome(null));
    }

    @Test
    public void test_generalized_palindrome (){
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("bbwac",cc));
        assertTrue(palindrome.isPalindrome("a",cc));
        assertTrue(palindrome.isPalindrome("",cc));
        assertFalse(palindrome.isPalindrome("aawaa",cc));

        CharacterComparator cn = new OffByN(3);
        assertTrue(palindrome.isPalindrome("eewbh",cn));
        assertTrue(palindrome.isPalindrome("a",cn));
        assertTrue(palindrome.isPalindrome("",cn));
        assertFalse(palindrome.isPalindrome("aawaa",cn));

    }




}