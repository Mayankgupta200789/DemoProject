package recursion;

/**
 * @Author Mayank Gupta
 * @Date 9/24/17
 */
public class PrintBinary {

    public static void main(String args[] ) {

        String input1 = "1";
        String input2 = "1";
        int a = Integer.parseInt(input1) * Integer.parseInt(input2);
        System.out.println(a);
//        PrintBinary printBinary = new PrintBinary();
//        System.out.println(printBinary.printBinary(200000));
    }

    public String printBinary(int input ) {

        if( input < 2 ) {
            return String.valueOf(input);
        } else {
            int lastDigit = input % 2;
            int restOfDigits = input / 2;

            return printBinary(restOfDigits) + String.valueOf(lastDigit);
        }


    }
}
