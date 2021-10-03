package array;


import java.util.Arrays;

/**
 * Given an integer n, return the number of prime numbers that are strictly less than n.



 Example 1:

 Input: n = 10
 Output: 4
 Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 Example 2:

 Input: n = 0
 Output: 0
 Example 3:

 Input: n = 1
 Output: 0

 Complexity
 This is sieve's algorithm.

 Time complexity is calculated is O (n/2 + n/3 + n/5 + n/ + n/11 + .... )
 This results in O(n log log n)
 Space complexity is O(n)

 */
public class CountPrimes {

    public int countPrimes(int n) {


        if ( n == 0 || n == 1 || n == 2 ) return 0;

        boolean[] nonPrimes = new boolean[n];
        int count = 0;

        nonPrimes[0] = true;
        nonPrimes[1] = true;

        for(int i = 2; i < n; i = i + 2  ){

            nonPrimes[i] = true;
        }
        nonPrimes[2] = false;

        for(int i = 3; i * 2 < n ; i = i + 2) {
            if(!nonPrimes[i]) {
                for(int j = 2; j * i  < nonPrimes.length; j++ ) {

                    if(!nonPrimes[i * j]) {
                        nonPrimes[i*j] = true;
                    }
                }
            }
        }

        for(int i = 0; i < nonPrimes.length; i++ ) {

            if(!nonPrimes[i]) {
                count++;
            }
        }

        return count;

    }
}
