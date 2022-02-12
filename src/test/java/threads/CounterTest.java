package threads;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * @Author Mayank Gupta
 * @Date 9/29/17
 */
public class CounterTest {
    private Counter counter = new Counter();

    @Test
    public void addOne()
    {
        counter.addOne();
    }

    @After
    public void testCount()
    {
        assertEquals("4 Threads running addOne in parallel should lead to 4" , 4 , counter.getCount());
    }

}