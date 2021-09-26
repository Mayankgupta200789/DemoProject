package array;

/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 You can assume that you can always reach the last index.
 *
 *
 *
 */


public class JumpGameSecond {

    public int jump(int[] nums) {

        if( nums.length == 0 || nums.length == 1 ) return 0;
        if(nums[0] == 0 ) return 0;
        int reachable = 0;
        int count = 0;
        int[] dp = new int[nums.length];

        for(int i = 0; i < nums.length; i++ ) {

            if( i > reachable ) return 0;

            if( i + nums[i] > reachable ) {
                reachable = i + nums[i];

                int j = reachable;


                if( j > nums.length - 1) {
                    j = nums.length - 1;
                }
                count = dp[i] + 1;
                while(j < nums.length
                        && dp[j] == 0
                        && j > i ) {
                    dp[j] = count;
                    j--;
                }
            }
            if(dp[nums.length - 1] > 0 ) {
                break;
            }
        }

        return dp[nums.length - 1];
    }
}
