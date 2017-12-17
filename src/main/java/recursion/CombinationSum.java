package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Mayank Gupta
 * @Date 11/17/17
 */
public class CombinationSum {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();

        input.add(17);
        input.add(8);
        input.add(17);
        input.add(20);
        input.add(20);
        input.add(18);
        input.add(14);
        input.add(15);
        input.add(20);
        input.add(3);

        CombinationSum combinationSum = new CombinationSum();
        combinationSum.combinationSum(input,14);
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Set<ArrayList<Integer>> hashSet = new HashSet<>();
        a.sort(Collections.reverseOrder());
        getResult(new ArrayList<>(),b,a,result,hashSet);
        return result;
    }

    private void getResult(ArrayList<Integer> inputs, int sum,
                           ArrayList<Integer> outputs, ArrayList<ArrayList<Integer>> result,
                           Set<ArrayList<Integer>> hashSet) {

        if( sum < 0 ) {
            return;
        }

        if( sum == 0 ) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(inputs);
            Collections.sort(temp);
            if(!hashSet.contains(temp)) {
                hashSet.add(temp);
                result.add(temp);
            }
        } else {

            for(int i = 0 ; i < outputs.size(); i++ ) {
                inputs.add(outputs.get(i));
                int target = outputs.get(i);
                outputs.remove(outputs.get(i));
                getResult(inputs,(sum - target), outputs, result,hashSet);
                int val = inputs.remove(inputs.size() - 1);
                outputs.add(val);
                outputs.sort(Collections.reverseOrder());
            }
        }



    }
}
