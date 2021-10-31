package patterns;

import org.junit.Before;
import org.junit.Test;
import patterns.slidingwindow.SlidingWindow;

public class SlidingWindowTest {

    private SlidingWindow slidingWindow;

    @Before
    public void setUp() throws Exception {
        slidingWindow = new SlidingWindow();
    }

    @Test
    public void slide() {

        int[] input = new int[]{1,2,12,12,123,1,2,4,1,-5,-4,-4};

        //double[] slide = SlidingWindow.findAverages(input, 6);

        // [2,3,4]
    }
}