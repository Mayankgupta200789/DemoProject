package patterns.twopointers;


//https://leetcode.com/problems/sort-colors/submissions/

// Time complexity O(N)
// Space complexity O(1)

// As the number of elements are defined, sorting can be defined as follows

// define low as zero and high = length - 1;
// all the numbers that are zeros, placed before low. This is done by swapping two numbers
// all the numbers that are 2's place after high.
// remaining 1s are kept as it is. This is done by swapping two numbers.


public class IDutchNationalFlagProblem {

    public void sortColors(int[] arr) {

        int low = 0 ,high = arr.length - 1;

        for(int i = 0 ; i <= high ;) {

            if(arr[i] == 0 ) {
                swap(arr,low,i);
                i++;
                low++;

            }else if( arr[i] == 1) {
                i++;
            } else {
                swap(arr,i,high);
                high--;
            }
        }

    }

    public void swap(int[] arr,int low, int high ) {

        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;

    }
}
