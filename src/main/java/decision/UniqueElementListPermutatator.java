package decision;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Mayank Gupta
 * @Date 10/27/17
 */
public class UniqueElementListPermutatator {

    private List<List<Integer>> result = new ArrayList<>();
    private Set<List<Integer>> hashSet = new HashSet<>();


    public static void main(String args[]) {

        UniqueElementListPermutatator uniqueElementListPermutatator = new UniqueElementListPermutatator();

        uniqueElementListPermutatator.permuteUnique(new int[]{1,1,2});


    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        if( nums == null || nums.length == 0 ) {
            return result;
        }

        List<Integer> choices = new ArrayList<>();

        for(int i = 0 ; i <  nums.length;i++ ) {
            choices.add(nums[i]);
        }

        doPermute(new ArrayList<>(),choices);

        return result;

    }

    private void doPermute(List<Integer> prefix, List<Integer> choices) {

        if( choices.size() == 0 ) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(prefix);
            if( !hashSet.contains(temp)) {
                hashSet.add(temp);
                result.add(temp);
            }
        } else {

            for(int i = 0; i < choices.size(); i++ ) {
                prefix.add(choices.get(i));
                int element = choices.remove(i);
                doPermute(prefix,choices);
                prefix.remove(prefix.size() - 1);
                choices.add(i,element);
            }
        }


    }
}
