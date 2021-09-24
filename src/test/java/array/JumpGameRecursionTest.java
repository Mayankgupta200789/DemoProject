package array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;

import static org.junit.Assert.*;

public class JumpGameRecursionTest {

    private JumpGameRecursion jumpGameRecursion;

    @Before
    public void setUp() throws Exception {

        jumpGameRecursion = new JumpGameRecursion();
    }

    @Test
    public void canJump1() {

        int[] nums = new int[]{2,3,1,1,4};
        Assert.assertTrue(jumpGameRecursion.canJump(nums));
    }

    @Test
    public void canJump2() {

        // reachable = 4
        //
        int[] nums = new int[]{4,3,2,1,0,4};
        // 4 0
        // 4 1 0
        // 4 2 1 0
        // 4 5
        // 4 3 2 1 0
        Assert.assertFalse(jumpGameRecursion.canJump(nums));
    }
    //4 2 1 0 2 1 6

    @Test
    public void canJump3() {

        int[] nums = new int[]{4,4,4,0,0,1,0};
        // 4 5 6 6 6 6
        Assert.assertTrue(jumpGameRecursion.canJump(nums));
    }

    @Test
    public void canJump4() {

        int[] nums = new int[]{4,4,4,0,0,1,1,1,6,1,1,0,0,0,0};
        //4 5 6 6 6 6 7
        Assert.assertTrue(jumpGameRecursion.canJump(nums));
    }

}