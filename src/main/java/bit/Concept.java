package bit;

public class Concept {

    public void checkBitwise() {

        int a = 2;
        int b = 2;
        int c = 2;

        System.out.println(" the value of 2 & 2 is " + (2 & 2)); // 2
        System.out.println(" the value of 2 | 2 is " + (2 | 2)); // 2
        System.out.println(" the value of 2 ^ 2 is " + (2 ^ 2)); // 0
        System.out.println(" the value of ~2 is " + (~3)); // -2 (I got this . Need to understand the use of it.)
        a <<= 2;
        System.out.println(" the value of <<2 is " + a); // 8
        b >>= 2;
        System.out.println(" the value of >>2 is " + b); // 0
//      The difference between >> and >>> would only show up when shifting negative numbers.
//      The >> operator shifts a 1 bit into the most significant bit if it was a 1, and the >>> shifts in a 0 regardless.
        c >>>= 2;
        System.out.println(" the value of >>>2 is " + c); // 0
    }
}
