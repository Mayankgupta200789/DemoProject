package companies.versanetworks;

import junit.framework.TestCase;
import org.junit.Assert;

public class LargeIntegersTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testAdd() {

        String output = new LargeIntegers().add("1234", "12245");
        String output2 = new LargeIntegers().add("0", "679043535");
        String output3 = new LargeIntegers().add("6789", "679043535");
        String output4 = new LargeIntegers().add("999", "999");
        String output5 = new LargeIntegers().add("999", null);
        String output6 = new LargeIntegers().add(null, null);
        String output7 = new LargeIntegers().add(null, "999");


        Assert.assertEquals("13479", output);
        Assert.assertEquals("679043535", output2);
        Assert.assertEquals("679050324", output3);
        Assert.assertEquals("999", output5);
        Assert.assertNull( output4);
        Assert.assertEquals("1998", output4);
    }
}