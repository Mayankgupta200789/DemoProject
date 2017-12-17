package palindrome;

import org.junit.Before;
import org.junit.Test;

/**
 * @Author Mayank Gupta
 * @Date 9/27/17
 */
public class IntegerPalindromeTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void isPalindrome() throws Exception {

        IntegerPalindrome integerPalindrome = new IntegerPalindrome();

        integerPalindrome.isPalindrome(-2147447412);
    }

}