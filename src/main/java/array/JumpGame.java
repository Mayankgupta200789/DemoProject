package array;

/**
 * @Author Mayank Gupta
 * @Date 12/28/17
 */
public class JumpGame {

    private boolean isValid;

    public void setValid(boolean valid) {

        JumpGame jumpGame = new JumpGame();

        jumpGame.canJump(new int[]{1,2,0,4});
    }

    public boolean canJump(int[] nums) {

        int reachable = 0;
        for (int i=0; i < nums.length; ++i) {

            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;

    }
}