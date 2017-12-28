package decision;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * Time Complexity - Catalan number = (2n)!/ (n + 1)!n!
 * @Author Mayank Gupta
 * @Date 9/24/17
 */
public class BracketGenerator {

    private int n;

    private List<String> result = new LinkedList<>();

    public static void main(String args[]) {

        BracketGenerator bracketGenerator = new BracketGenerator();

        // 1 - 1
        // 2 - 2
        // 3 - 5
        // 4 - 14
        // 5 - 42
        // 6 - 132
        bracketGenerator.generate(6
                , 0, 0, "");
        System.out.println(bracketGenerator.result.size());
    }


    public void generate(int n, int open, int close, String brackets) {


        if (brackets.length() == (n * 2)) {
            result.add(brackets);
            return;
        }

        if (open < n) {
            generate(n, open + 1, close,  brackets + "(");
        }

        if (close < open) {
            generate(n, open, close + 1, brackets + ")");
        }


    }
}
