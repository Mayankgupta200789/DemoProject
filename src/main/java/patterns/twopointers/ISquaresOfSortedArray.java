package patterns.twopointers;


//https://leetcode.com/problems/squares-of-a-sorted-array/

/**
 * Two pointers starting from two extreme and fill the result backwards.
 * This is the trick makes the problem very easy.
 * Could't solve it though
 * This problem is submitted in leetcode successfully.
 */
public class ISquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        int[] squares = new int[nums.length];

        int left = 0 ,right = nums.length - 1;
        int indexOfResult = nums.length - 1;

        while(left <= right ){

            int left2 = nums[left]*nums[left];
            int right2 = nums[right]*nums[right];

            if(left2 > right2 ) {
                squares[indexOfResult--] = left2;
                left++;
            } else {
                squares[indexOfResult--] = right2;
                right--;
            }
        }
        return squares;
    }

}
