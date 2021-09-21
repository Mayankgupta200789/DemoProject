package bit;

/**
 * BITWISE complement is
 *
 * 101010
 * 010101
 *
 *
 */

public class BitsSwapper {


    public int swap(int x ) {


        int output = 0;

        while(x != 0 ) {
            output |= x & ~(x - 1);
            x >>>= 1;
            if(x != 0 ) output <<= 1;
        }

        return output;
    }
}
