package string;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author Mayank Gupta
 * @Date 11/9/16
 */
public class StringCharRemoverTest {


    private StringCharRemover charRemover;

    @Before
    public void setUp() throws Exception {
        charRemover = new StringCharRemover();
    }

    @Test
    public void remove() throws Exception {

        Assert.assertEquals("Hello",charRemover.remove("Hello",'h'));
        Assert.assertEquals("ello",charRemover.remove("Hello",'H'));
        Assert.assertEquals(null,charRemover.remove(null,'H'));
        Assert.assertEquals("",charRemover.remove("",'H'));
        Assert.assertEquals("Ths s Java",charRemover.remove("This is Java",'i'));
    }

}