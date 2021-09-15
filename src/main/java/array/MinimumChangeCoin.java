package array;

import java.util.Arrays;
import java.util.Collection;



//        You are asked to write a program which takes an array of positive
//        integers and returns the smallest number which is not to the sum of a subset of
//        elements of the array.
//

// 1,2 -> 1,2,3
// 1,3 -> 1,3,4 (2 cannot be constructed)
// 1,2,4 -> 1,2,3,4,5,6,7
// 1,2,5 -> 1,2,5,6,7,8 ( 4 is missing as 5 is greater than 2 + 1 + 1
// 1,2,3,4,5,17 ( 5 + 4 + 3 + 2 + 1 = 15, 15 + 1 > 17, thus first missing change cannot be constructed is 16

// Lets assume that M[i-1] is sum of first i-1 numbers
// then if M[i-1] + 1 > x (where x is  the new number) then M[i-1] + 1 is the missing value that can be constructed
// otherwise continue with M[i-1] + x
// Another observation is that the order of the elements within the array makes no
//difference to the amounts that are constructible.
public class MinimumChangeCoin {


    public int minimumChange(Integer[] coinValues) {

        Arrays.sort(coinValues);

        int minimumChangeNotConstructible = 0;

        for(int value : coinValues) {

            if(value > minimumChangeNotConstructible + 1 ) {
                break;
            }

            minimumChangeNotConstructible += value;
        }

        return minimumChangeNotConstructible + 1;

    }
}
