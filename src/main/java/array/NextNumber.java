package array;


import java.util.LinkedList;
import java.util.List;

/**
 *
 * Write a program which takes as input an array of digits encoding a decimal number
 * D and updates the array to represent the number D + 1. For example, if the input
 * 65
 * is (1,2,9) then you should update the array to (1,3,0). Your algorithm should work
 * even if it is implemented in a language that has finite-precision arithmetic.
 *
 */
public class NextNumber {

    public List<Integer> plusOne(List<Integer> input) {

        int carry = 1 ;
        int result;

        for(int i = (input.size() - 1); i >= 0; i-- ) {

                int output = input.get(i) + carry;
                carry = output/10;
                result = output%10;
                input.set(i,result);
        }

        if(carry > 0 ) {
            input.add(0,carry);
        }

        return input;

    }

}
