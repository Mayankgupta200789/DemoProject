package bit;

/**
 * 460

 >> is arithmetic shift right, >>> is logical shift right.

 In an arithmetic shift, the sign bit is extended to preserve the signedness of the number.

 For example: -2 represented in 8 bits would be 11111110 (because the most significant bit has negative weight).
 Shifting it right one bit using arithmetic shift would give you 11111111, or -1.
 Logical right shift, however, does not care that the value could possibly represent a signed number;
 it simply moves everything to the right and fills in from the left with 0s. Shifting our -2 right one bit
 using logical shift would give 01111111.
 */
public class CountBits {


    public int countBits(int x ) {

        int count = 0;
        while( x != 0 ) {
            count += (x & 1);
            x >>>= 1;
        }

        return count;
    }

}
