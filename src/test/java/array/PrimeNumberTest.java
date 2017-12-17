package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Mayank Gupta
 * @Date 9/19/17
 */
public class PrimeNumberTest {
    @Test
    public void checkPrime() throws Exception {

        PrimeNumber number = new PrimeNumber();

        Assert.assertTrue(number.checkPrime(5));
        Assert.assertTrue(number.checkPrime(2));
        Assert.assertTrue(number.checkPrime(3));
        Assert.assertTrue(number.checkPrime(7));
        Assert.assertTrue(number.checkPrime(11));
        Assert.assertTrue(number.checkPrime(13));
        Assert.assertTrue(number.checkPrime(-1));
        Assert.assertTrue(number.checkPrime(-2));
        Assert.assertTrue(number.checkPrime(-3));
        Assert.assertTrue(number.checkPrime(-5));
    }

}