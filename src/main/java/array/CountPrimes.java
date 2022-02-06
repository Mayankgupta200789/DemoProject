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

    public static void main(String[] args) {
        new CountPrimes().countPrimes(49);
    }

    public int countPrimes(int n) {

        boolean[] primes = new boolean[n];
        Arrays.fill(primes,true);

        // Default 0 and 1 to be non prime
        primes[0] = false;
        primes[1] = false;

        // The reason, we need to check till square root of n
        // is because if any one factor is greater than square root of n
        // then other number has to be less than square root of n.

        for(int i = 2; i < Math.sqrt(n);i++ ) {

            // If the number is prime then put its all multiples to non prime
            if(primes[i]) {
                for (int j = 2; j * i < n; j++) {
                    // dont put j, put j * i to false
                    if (primes[j * i]) {
                        primes[j * i] = false;
                    }
                }
            }
        }

        for(int i = 0 ;i < n; i++ ) {
            if(primes[i]) {
                System.out.println("the value of prime numbers are " + i);
            }
        }
        return 0;

    }
}
