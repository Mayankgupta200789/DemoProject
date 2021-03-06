package java8;

/**
 * @Author Mayank Gupta
 * @Date 10/15/17
 */
public class Calculator {

    interface IntegerMath {
        int operation(int a,int b);
    }

    public int operateBinary(int a, int b,IntegerMath op) {
        return op.operation(a,b);
    }

    public static void main(String[] args) {


        Calculator calculator = new Calculator();
        IntegerMath addition = (a,b) -> a + b;
        IntegerMath subtraction = (a,b) -> a - b;
        System.out.println("40 + 2 = " + calculator.operateBinary(40,2, addition));
        System.out.println("20 + 10 = " + calculator.operateBinary(20,10,subtraction));

    }
}
