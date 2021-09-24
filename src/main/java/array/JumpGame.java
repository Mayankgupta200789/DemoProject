package array;

/**
 * @Author Mayank Gupta
 * @Date 12/28/17
 */

/**
 * This solution is totally unguessable
 * Basically, we are tracking where can we reach
 * and the way we do it is at every step, our reach is i + nums[i] or previous reach
 * whichever is max
 * if any time index is greater than reachable, that means we cannot further proceed.
 * This will return false otherwise it returns true.
 *
 *
 */
public class JumpGame {

    public boolean canJump(int[] nums) {

        int reachable = 0;
        //1 2 3 4 5 0
        for (int i=0; i < nums.length; ++i) {

            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;

    }
}
