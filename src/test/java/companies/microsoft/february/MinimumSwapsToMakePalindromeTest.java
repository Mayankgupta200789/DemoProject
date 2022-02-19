package companies.microsoft.february;

import junit.framework.TestCase;
import org.junit.Assert;

public class MinimumSwapsToMakePalindromeTest extends TestCase {

    public void testGetNoOfSwaps() {

        int swaps1 = new MinimumSwapsToMakePalindrome().getNoOfSwaps("mamad");
        int swaps2 = new MinimumSwapsToMakePalindrome().getNoOfSwaps("asflkj");
        int swaps3 = new MinimumSwapsToMakePalindrome().getNoOfSwaps("aabb");
        int swaps4 = new MinimumSwapsToMakePalindrome().getNoOfSwaps("ntiin");

        Assert.assertEquals(3,swaps1);
        Assert.assertEquals(-1,swaps2);
        Assert.assertEquals(2,swaps3);
        Assert.assertEquals(1,swaps4);



    }
}