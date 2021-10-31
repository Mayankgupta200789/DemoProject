package patterns.slidingwindow;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringKDistinctTest {

    @Test
    public void findLength() {

        Assert.assertEquals("assdasfasdf".length(),LongestSubstringKDistinct.findLength("assdasfasdf",20));
        Assert.assertEquals(2,LongestSubstringKDistinct.findLength("assdasfasdf",1));
        Assert.assertEquals(4,LongestSubstringKDistinct.findLength("assdasfasdf",2));
    }
}