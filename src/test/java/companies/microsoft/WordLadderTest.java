package companies.microsoft;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;

public class WordLadderTest extends TestCase {

    public void testLadderLength() {


        int output = new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        int output2 = new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"));
        int output3 = new WordLadder().ladderLength("hit", "dotox", Arrays.asList("hot", "dot", "dog", "lot", "log","cog"));
        int output4 = new WordLadder().ladderLength("hitiag", "gitiag", Arrays.asList("aitiag","bitiag","citiag","ditiag","hitiag","gitiag"));

        Assert.assertEquals(5,output);
        Assert.assertEquals(0,output2);
    }
}