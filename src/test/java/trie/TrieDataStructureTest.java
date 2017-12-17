package trie;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @Author Mayank Gupta
 * @Date 9/21/17
 */
public class TrieDataStructureTest {

    private static final String HELLO = "hello";
    private TrieDataStructure trieDataStructure;

    @Before
    public void setUp() {
        trieDataStructure = new TrieDataStructure();
    }

    @Test
    public void insert() throws Exception {


        trieDataStructure.insert("helloman");

        Assert.assertTrue(trieDataStructure.search(HELLO));
    }

    @Test
    public void searchWord() throws Exception {
    }

    @Test
    public void getListOfWords() {

        trieDataStructure.insert(HELLO);
        trieDataStructure.insert("hellman");
        trieDataStructure.insert("hellboy");
        trieDataStructure.insert("hellosir");

        List<String> listOfWords = trieDataStructure.prefixSearch("hell");
        Assert.assertNotNull(listOfWords);
    }

}