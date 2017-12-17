package threads;

/**
 * @Author Mayank Gupta
 * @Date 9/29/17
 */
public class Counter {
    private int count = 0;

    public void addOne() {
        count++;
    }

    public int getCount() {
        return count;
    }
}