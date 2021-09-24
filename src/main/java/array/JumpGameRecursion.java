package array;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

 Return true if you can reach the last index, or false otherwise.



 Example 1:

 Input: nums = [2,3,1,1,4]
 Output: true
 Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 Example 2:

 Input: nums = [3,2,1,0,4]
 Output: false
 Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 */

// This is something that I figured out but its time complexity is higher.

public class JumpGameRecursion {

    private static Set<Integer> nonReachableSet = new HashSet<>();
    public boolean canJump(int[] nums) {

        return canJumpCheck(nums,0);


    }

    private boolean canJumpCheck(int[] nums, int i ) {

        if(nonReachableSet.contains(i)) return false;
        if( i >= (nums.length - 1)) return true;
        if( nums[i] == 0 ) {
            nonReachableSet.add(i);
            return false;
        }

        int j = nums[i];

        while( j >= 1) {

            if(canJumpCheck(nums,i + j)) return true;
            j--;
        }

        return false;
    }
}
