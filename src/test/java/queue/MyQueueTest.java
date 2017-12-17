package queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author Mayank Gupta
 * @Date 8/24/17
 */
public class MyQueueTest {

    private MyQueue<Integer> myQueue;

    @Before
    public void setUp() {
        myQueue = new MyQueue<>();
    }
    @Test
    public void add() throws Exception {

        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.add(5);

        Integer val = myQueue.remove();

        Assert.assertNotNull(val);
        Assert.assertEquals(2,val.intValue());
        Assert.assertEquals(3,myQueue.peek().intValue());
        Assert.assertEquals(3,myQueue.remove().intValue());
    }

    @Test
    public void remove() throws Exception {
    }

    @Test
    public void peek() throws Exception {
    }

    @Test
    public void size() throws Exception {
    }

}