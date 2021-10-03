package array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * Time complexity of prime
 * Square root of n.
 */

public class CheckIfANumberIsPrimeTest {

    private CheckIfANumberIsPrime checkIfANumberIsPrime;

    @Before
    public void setUp() throws Exception {

        checkIfANumberIsPrime = new CheckIfANumberIsPrime();
    }

    @Test
    public void checkPrime() {

        Assert.assertFalse(checkIfANumberIsPrime.checkPrime(123));
        Assert.assertTrue(checkIfANumberIsPrime.checkPrime(1231));
    }
}