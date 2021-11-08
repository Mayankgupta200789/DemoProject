package patterns.twopointers;

import java.util.ArrayList;
import java.util.List;


//https://leetcode.com/problems/subarray-product-less-than-k/submissions/

// Time complexity O(N2)
// Space complexity O(N) for tracker
public class SubArrayProductLessThankK {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();

        int slow = 0;
        int fast = slow + 1;


        while(slow < arr.length) {

            List<Integer> inputs = new ArrayList<>();
            if(arr[slow] > target ) {
                slow++;
                fast = slow + 1;
                continue;
            } else {
                inputs.add(arr[slow]);
                subarrays.add(inputs);
            }

            int currentVal = arr[slow];
            List<Integer> tracker = new ArrayList<>(inputs);
            while(fast < arr.length ) {
                currentVal *=  arr[fast];

                if(currentVal < target ) {
                    tracker.add(arr[fast]);
                    List<Integer> result = new ArrayList<>(tracker);
                    subarrays.add(result);
                    fast++;
                }else {
                    break;
                }
            }
            slow++;
            fast = slow + 1;
        }

        return subarrays;
    }
}
