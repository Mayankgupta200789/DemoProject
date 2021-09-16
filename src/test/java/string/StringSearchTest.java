package string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringSearchTest {

    private StringSearch stringSearch;

    @Before
    public void setUp() {

        stringSearch = new StringSearch();
    }

    @Test
    public void search1() {

        String haystack = "asdfasfwqrqweadsavfasasdfwqerq";
        String needle = "eadsav";

        StringSearch stringSearch = new StringSearch();

        Assert.assertEquals(12,stringSearch.search(haystack,needle));
    }



    @Test
    public void search3() {

        String haystack = "asdfasfwqrqweadsavfasasdfwqerq";
        String needle = "";

        StringSearch stringSearch = new StringSearch();

        Assert.assertEquals(0,stringSearch.search(haystack,needle));
    }

    @Test
    public void search4() {

        String haystack = "";
        String needle = "";

        StringSearch stringSearch = new StringSearch();

        Assert.assertEquals(0,stringSearch.search(haystack,needle));
    }

    @Test
    public void search5() {

        String haystack = "";
        String needle = "asdfa";

        StringSearch stringSearch = new StringSearch();

        Assert.assertEquals(-1,stringSearch.search(haystack,needle));
    }

    @Test
    public void search6() {

        String haystack = "923491439174alsfmlwlhqwelfmndclsqnl241231sdq4";
        String needle = "4alsfmlwlh";

        StringSearch stringSearch = new StringSearch();

        Assert.assertEquals(11,stringSearch.search(haystack,needle));
    }
}