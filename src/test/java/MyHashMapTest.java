import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author Mayank Gupta
 * @Date 8/24/17
 */
public class MyHashMapTest {

    private MyHashMap<Integer, Integer> myHashMap;

    @Before
    public void setUp() throws Exception {

        myHashMap = new MyHashMap<>();
    }

    @Test
    public void put() throws Exception {

        myHashMap.put(4,5);
        myHashMap.put(6,5);
        myHashMap.put(2,5);
        myHashMap.put(1,5);

        int[] a = new int[5];
        a[0] = 1;
        a = new int[10];

        a[0] = 2;

        Assert.assertEquals(5,myHashMap.get(6).intValue());
        Assert.assertEquals(5,myHashMap.get(4).intValue());
        Assert.assertEquals(5,myHashMap.get(2).intValue());
        Assert.assertEquals(5,myHashMap.get(1).intValue());
        Assert.assertEquals(4,myHashMap.size());
    }

    @Test
    public void get() throws Exception {
    }

}