package patterns.fastAndSlowPointers;

//https://leetcode.com/problems/happy-number/submissions/

// Time complexity O(log N to the base 10)
// where N is the number

// Its very difficult to determine time complexity


/*
The time complexity of the algorithm is difficult to determine. However we know the fact that all unhappy numbers eventually get stuck in the cycle: 4 -> 16 -> 37 -> 58 -> 89 -> 145 -> 42 -> 20 -> 4

        This sequence behavior tells us two things:

        If the number NN is less than or equal to 1000, then we reach the cycle or ‘1’ in at most 1001 steps.
        For N > 1000N>1000, suppose the number has ‘M’ digits and the next number is ‘N1’. From the above Wikipedia link, we know that the sum of the squares of the digits of ‘N’ is at most 9^2M9
        ​2
        ​​ M, or 81M81M (this will happen when all digits of ‘N’ are ‘9’).
        This means:

        N1 < 81MN1<81M
        As we know M = log(N+1)M=log(N+1)
        Therefore: N1 < 81 * log(N+1)N1<81∗log(N+1) => N1 = O(logN)N1=O(logN)
        This concludes that the above algorithm will have a time complexity of O(logN)O(logN).
*/

public class IHappyNumber {

    public boolean isHappy(int num) {

        int slow = num;
        int fast = num;

        do {
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
        } while( slow != fast );


        return slow == 1 ;

    }

    public int findSquareSum(int num) {
        int sum = 0;
        while( num != 0 ) {
            int n = num % 10 ;
            sum += (int) Math.pow(n,2) ;
            num = num/10;
        }

        return sum;
    }
}
