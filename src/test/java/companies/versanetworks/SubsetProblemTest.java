package companies.versanetworks;

import junit.framework.TestCase;

import java.util.Arrays;

public class SubsetProblemTest extends TestCase {

    private SubsetProblem subsetProblem;

    public void setUp() throws Exception {
        subsetProblem = new SubsetProblem();
    }

    public void testGetSubSet() {

        subsetProblem.getSubSet(Arrays.asList(1, 2, 3, 4, 5, 6));



    }

}