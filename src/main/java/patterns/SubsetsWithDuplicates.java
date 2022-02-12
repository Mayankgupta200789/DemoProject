package patterns;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsWithDuplicates {

    public List<List<Integer>> findSubSets(int[] nums) {

        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>());
        Set<Integer> hashSet = new HashSet<>();

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
