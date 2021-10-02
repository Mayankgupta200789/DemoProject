package array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountPrimesTest {

    private CountPrimes countPrimes;

    @Before
    public void setUp() throws Exception {

        countPrimes = new CountPrimes();
    }

    @Test
    public void countPrimes() {

        Assert.assertEquals(12,countPrimes.countPrimes(40));
        //2 3 5 7 11 13 17 19 23 29
    }
}