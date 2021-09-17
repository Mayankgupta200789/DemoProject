package bit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountBitsTest {

    private CountBits countBits;

    @Before
    public void setUp() throws Exception {

        countBits = new CountBits();
    }

    @Test
    public void countBits() {

        int output = countBits.countBits(6);

        Assert.assertEquals(2,output);
    }
}