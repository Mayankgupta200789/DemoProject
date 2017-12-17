package string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author Mayank Gupta
 * @Date 11/11/16
 */
public class StringWildCardProblemTest {

    private StringWildCardProblem cardProblem;

    @Before
    public void setUp() throws Exception {
        cardProblem = new StringWildCardProblem();
    }

    @Test
    public void match() throws Exception {

        Assert.assertTrue(cardProblem.match("avc","a*c"));
        Assert.assertTrue(cardProblem.match("avc","a?c"));
        Assert.assertTrue(cardProblem.match("avcd","a?c*"));
        Assert.assertTrue(cardProblem.match("avcd","*c*"));
    }

}