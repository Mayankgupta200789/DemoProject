package string;

import org.junit.Before;
import org.junit.Test;

/**
 * @Author Mayank Gupta
 * @Date 9/23/17
 */
public class StringPermutatorTest {

    private StringPermutator stringPermutator;

    @Before
    public void setUp() throws Exception {

        stringPermutator = new StringPermutator();
    }

    @Test
    public void permute() throws Exception {

        stringPermutator.permute("GOD");
    }

}