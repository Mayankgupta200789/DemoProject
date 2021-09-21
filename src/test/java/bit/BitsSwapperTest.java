package bit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BitsSwapperTest {

    private BitsSwapper bitsSwapper;

    @Before
    public void setUp() throws Exception {

        bitsSwapper = new BitsSwapper();
    }

    @Test
    public void swap() {

        // 101011 = 43
        // 110101 = 53
        int output = bitsSwapper.swap(43);

        Assert.assertEquals(43,output);



    }
}