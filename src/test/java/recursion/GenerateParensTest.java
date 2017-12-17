package recursion;

import org.junit.Test;

import java.util.List;

/**
 * @Author Mayank Gupta
 * @Date 9/15/17
 */
public class GenerateParensTest {
    @Test
    public void generateParenthesis() throws Exception {

        GenerateParens generateParens = new GenerateParens();
        List<String> parenthesis = generateParens.generateParenthesis(3);
    }

}