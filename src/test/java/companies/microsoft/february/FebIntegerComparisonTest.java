package companies.microsoft.february;

import junit.framework.TestCase;
import org.junit.Assert;

public class FebIntegerComparisonTest extends TestCase {



    public void testGetMax() {

        FebIntegerComparison febIntegerComparison = new FebIntegerComparison();

        Assert.assertEquals(-198,febIntegerComparison.getMax(-1598));
        Assert.assertEquals(198,febIntegerComparison.getMax(1598));
        Assert.assertEquals(15098,febIntegerComparison.getMax(150958));
        Assert.assertEquals(-10958,febIntegerComparison.getMax(-150958));
        Assert.assertEquals(-15990,febIntegerComparison.getMax(-159950));
        Assert.assertEquals(-15990,febIntegerComparison.getMax(-159950));
        Assert.assertEquals(-589,febIntegerComparison.getMax(-5859));
        Assert.assertEquals(859,febIntegerComparison.getMax(5859));
        //154565785
        //15456578

        //15253545
        //1525354
        //1525345
    }
}