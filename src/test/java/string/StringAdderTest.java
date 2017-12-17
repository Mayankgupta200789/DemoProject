package string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author Mayank Gupta
 * @Date 11/11/16
 */
public class StringAdderTest {


    private StringAdder adder;

    @Before
    public void setUp() throws Exception {
        adder = new StringAdder();
    }

    @Test
    public void add() throws Exception {

        Assert.assertEquals("18",adder.add("9","9"));
        Assert.assertEquals("2222222222",adder.add("1111111111","1111111111"));
        Assert.assertEquals("-6",adder.add("-1","-5"));
        Assert.assertEquals("4",adder.add("-1","5"));
        Assert.assertEquals("2.5",adder.add("1.3","1.2"));
        Assert.assertEquals(null,adder.add(null,null));
        Assert.assertEquals("",adder.add("",""));
        Assert.assertEquals("3.2",adder.add("3.4",""));
    }

}