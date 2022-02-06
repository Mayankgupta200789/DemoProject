package decision;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mayank Gupta
 * @Date 10/23/17
 */
public class IntegerListPermutator {


    private List<List<Integer>> result = new ArrayList<>();

    public static void main(String args[]) {

        IntegerListPermutator integerListPermutator = new IntegerListPermutator();
        integerListPermutator.permute(new int[]{1,2,3});
    }

    public List<List<Integer>> permute(int[] nums) {

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
            result.add(temp);
        } else {
            // prefix =  {1}
            // choices = (3)
            //

            for(int i = 0; i < choices.size(); i++ ) {
                prefix.add(choices.get(i));
                int element = choices.remove(i);
                doPermute(prefix,choices);
                prefix.remove(prefix.size() - 1);
                choices.add(i,element);
            }
        }
    }

    public void doPermute(List<Integer> prefix, List<Integer> choices,List<List<Integer>> result) {

        if(choices.size() == 0 ) {
            result.add(new ArrayList<Integer>(prefix));
        } else {

            for(int i = 0 ; i < choices.size() ; i++ ) {

                prefix.add(choices.get(i));
                int element = choices.remove(i);
                doPermute(prefix,choices,result);
                choices.add(i,element);
                prefix.remove(prefix.size() - 1);

            }


        }


    }
}
