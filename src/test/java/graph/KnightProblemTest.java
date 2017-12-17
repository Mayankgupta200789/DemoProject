package graph;

import org.junit.Before;
import org.junit.Test;

/**
 * @Author Mayank Gupta
 * @Date 8/10/17
 */
public class KnightProblemTest {

    private KnightProblem knightProblem;

    @Before
    public void setUp() throws Exception {

        knightProblem = new KnightProblem();
    }

    @Test
    public void knight() throws Exception {

        knightProblem.knight(8, 8, 1, 1, 8, 8);

    }

}