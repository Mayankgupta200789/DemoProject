package patterns.subsets;

import java.util.*;
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


public class SubsetsWithDuplicates {

    public static void main(String[] args) {
        SubsetsWithDuplicates subsetsWithDuplicates = new SubsetsWithDuplicates();
        List<List<Integer>> result = findSubSets(new int[]{1, 3, 3});
        System.out.println("Here is the list of subsets: " + result);

        result = findSubSets(new int[]{1, 5, 3, 3});
        System.out.println("Here is the list of subsets: " + result);
    }

    public static List<List<Integer>> findSubSets(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>());
        Set<List<Integer>> hashSet = new HashSet<>();

        for (int number : nums) {
            int n = subsets.size();
            for (int i = 0; i < n; i++) {

                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(number);
                if(!hashSet.contains(set)) {
                    subsets.add(set);
                    hashSet.add(set);
                }
            }
        }

        return subsets;
    }
}
