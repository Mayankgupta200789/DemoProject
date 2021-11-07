package patterns.twopointers;

import java.util.Arrays;

public class ITripletWithSmallerSum {

    public  int searchTriplets(int[] arr, int target) {
        int count = 0;
        Arrays.sort(arr);

        for(int i = 0 ; i < arr.length; i++ ) {

            int left = i + 1;
            int right = arr.length - 1;

            while( left < right ) {

                int currentSum = arr[left] + arr[right] + arr[i];

                if(currentSum < target ) {
                    count += right - left;
                    left++;
                }else {
                    right--;
                }
            }
        }

        return count;
    }
}
