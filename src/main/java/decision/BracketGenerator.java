package decision;

/**
 * @Author Mayank Gupta
 * @Date 9/24/17
 */
public class BracketGenerator {

    private int n;

    public static void main(String args[]) {

        BracketGenerator bracketGenerator = new BracketGenerator();


        bracketGenerator.generate(4, 0, 0, "");
    }


    public void generate(int n, int open, int close, String brackets) {


        if (brackets.length() == (n * 2)) {
            System.out.println(brackets);
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
