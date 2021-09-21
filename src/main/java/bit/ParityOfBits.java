package bit;

/**
 * IMPORTANT CONCEPTS TO REMEMBER HERE
 *
 * x & (x - 1) , drop the lowest bit. sets last bit of 1 to zero
 * With this concept, its easy to find parity
 * Parity is simply identifying how many 1s are present.
 *
 */
public class ParityOfBits {


    public static short parity(long x) {

        short result = 0;

        while( x != 0 ) {

            result ^= 1;
            x &= (x-1);
        }
        return result;

    }
}
