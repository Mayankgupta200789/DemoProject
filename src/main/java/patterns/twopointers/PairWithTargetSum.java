package patterns.twopointers;

public class PairWithTargetSum {

    public static int[] search(int[] arr, int targetSum) {
        int left = 0, right = arr.length - 1;

        while(left < right ) {

            int sum = arr[left] + arr[right];

            if(sum == targetSum) return new int[] {left,right};

            if(sum > targetSum) {
                right--;
            } else {
                left++;
            }
        }


        return new int[] { -1, -1 };
    }
}
