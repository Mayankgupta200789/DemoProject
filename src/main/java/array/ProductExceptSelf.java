package array;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        if(nums == null ) return null;
        if(nums.length == 1 )return nums;

        int[] output = new int[nums.length];
        output[0] = 1;
        for(int i = 1; i < nums.length; i++ ) {

            output[i] = nums[i-1]*output[i-1];

        }

        int rightProductTrack = 1;

        for(int j = output.length - 2; j >= 0; j-- ) {

            rightProductTrack *= nums[j+1];
            output[j] = output[j]*rightProductTrack;
        }

        return output;
    }
}
