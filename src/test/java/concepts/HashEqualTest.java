package concepts;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author Mayank Gupta
 * @Date 8/14/17
 */
public class HashEqualTest {

    private HashEqual hashEqual;

    //[3, 4, 7, 1, 2, 9, 8]


    @Before
    public void setUp() throws Exception {

        hashEqual = new HashEqual();
    }

    @Test
    public void equal() throws Exception {

        ArrayList<Integer> input = new ArrayList<>();

        input.add(1);
        input.add(1);
        input.add(1);
        input.add(1);
        input.add(1);

//        hashEqual.equal(input);
    }

}