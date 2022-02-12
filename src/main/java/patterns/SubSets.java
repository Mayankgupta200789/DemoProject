package patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity
 * Every time inner loop goes for 2^n
 * and this is called for N times
 * thus, O(N*2^n)
 *
 * Space complexity
 * Every time size becomes 2^n
 * thus, space complexity becomes O(N*2^N)
 *
 *
 */

public class SubSets {

    public List<List<Integer>> findSubSets(int[] nums) {

        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>());

        for(int number : nums ) {
            int n = subsets.size();
            for(int i = 0 ; i < n ; i++ ) {

                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(number);
                subsets.add(set);
            }
        }

        return subsets;
    }


}
