package array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumChangeCoinTest {

    private MinimumChangeCoin minimumChangeCoin;

    @Before
    public void setUp() throws Exception {

        minimumChangeCoin = new MinimumChangeCoin();
    }

    @Test
    public void minimumChange() {

        Integer[] coinValues = new Integer[] {1,10,11,12,14,9};
        int output = minimumChangeCoin.minimumChange(coinValues);

        Assert.assertEquals(output,2);

        Integer[] coinValues2 = new Integer[] {1,2,3,6,7,19};
        int output2 = minimumChangeCoin.minimumChange(coinValues2);

        Assert.assertEquals(output2,39);

        Integer[] coinValues3 = new Integer[] {1,2,3,4,5,17};
        int output3 = minimumChangeCoin.minimumChange(coinValues3);

        Assert.assertEquals(output3,16);



    }
}