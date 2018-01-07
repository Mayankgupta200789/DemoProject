package array;

/**
 * @Author Mayank Gupta
 * @Date 12/28/17
 */
public class JumpGame {

    private boolean isValid;

    public static void main(String args[]){

        JumpGame jumpGame = new JumpGame();

        jumpGame.canJump(new int[]{1,1,1,4});
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
