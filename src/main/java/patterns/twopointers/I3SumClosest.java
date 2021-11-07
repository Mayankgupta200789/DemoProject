package patterns.twopointers;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-closest/submissions/
// Leetcode submitted successfully.

// Time compexity - O(N2)
// Space complexity - O(N) for sorting.
public class I3SumClosest {

    public int threeSumClosest(int[] arr, int targetSum) {
        Arrays.sort(arr);
        //[-3, -1, 1, 2], target=1

        int right = arr.length - 1;
        int minDiff = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;

        for(int i = 0 ; i < arr.length; i++ ) {

            int left = i + 1;
            right = arr.length - 1;

            while(left < right ) {

                int currentSum = arr[left] + arr[right] + arr[i];

                int currentDiff = Math.abs(targetSum - currentSum);

                if(currentSum == targetSum ) {
                    return currentSum;
                } else if( currentSum > targetSum ) {
                    right--;
                } else {
                    left++;
                }

                if(minDiff > currentDiff ) {
                    minDiff = currentDiff;
                    minSum = currentSum;
                }
            }
        }
        return minSum;
    }
}
