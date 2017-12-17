package pascal;

import org.junit.Before;
import org.junit.Test;

/**
 * @Author Mayank Gupta
 * @Date 11/12/16
 */
public class PascalTriangleFormerTest {

    private PascalTriangleFormer pascalTriangleFormer;

    @Before
    public void setUp() throws Exception {
        pascalTriangleFormer = new PascalTriangleFormer();
    }

    @Test
    public void form() throws Exception {
        pascalTriangleFormer.form(4);
    }

}