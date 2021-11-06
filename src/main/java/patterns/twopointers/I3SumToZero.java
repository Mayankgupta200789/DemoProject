package patterns.twopointers;

import java.util.*;
//https://leetcode.com/problems/3sum/submissions/

// This problem cannot be solved by a combination of two sum and single sum

// Trick is to use hashset.
// Also, once you select a number, then do a two sum problem on remaining
// rest of numbers.

// Time complexity - O(N2)
// Space complexity - O(N) for sorting.
public class I3SumToZero {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> hashSet = new HashSet<>();

        for(int i = 0 ; i < nums.length; i++ ) {

            searchPair(nums,-nums[i],hashSet,i+1);

        }

        return new ArrayList<>(hashSet);
    }

    public void searchPair(int[] arr,int targetSum,Set<List<Integer>> hashSet, int left ) {

        int right = arr.length - 1;

        while (left < right) {

            int currentSum = arr[left] + arr[right];

            if (currentSum == targetSum) {

                List<Integer> output = Arrays.asList(arr[left], arr[right], -targetSum);

                if (!hashSet.contains(output)) {
                    hashSet.add(output);
                }
                left++;
                right--;
            } else if (currentSum > targetSum) {
                right--;
            } else {
                left++;
            }
        }
    }
}
