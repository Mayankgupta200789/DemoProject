package companies.microsoft.onsite;

import junit.framework.TestCase;

public class CustomPriorityQueueTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testAdd() {

        CustomPriorityQueue customPriorityQueue = new CustomPriorityQueue(false);

        customPriorityQueue.add(4);
        customPriorityQueue.add(2);
        customPriorityQueue.add(1);
        customPriorityQueue.add(5);
        customPriorityQueue.add(6);
        customPriorityQueue.add(0);

        customPriorityQueue.remove();
    }
}