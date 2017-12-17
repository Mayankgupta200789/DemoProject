package concepts;

/**
 * @Author Mayank Gupta
 * @Date 11/5/17
 */
public class ModularExpression {

    public static void main(String[] args) {
        ModularExpression modularExpression = new ModularExpression();

        modularExpression.calculate(-1,1,20);
    }

    public int calculate(int a, int b , int c ) {

        return (int) Math.pow(a,b) % c;
    }
}
