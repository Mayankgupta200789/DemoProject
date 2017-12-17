package decision;

import java.util.*;

/**
 * @Author Mayank Gupta
 * @Date 11/9/17
 */
public class ListSumCombinator {

    Set<ArrayList<Integer>> hashSet = new HashSet<>();


    public static void main(String[] args) {
        ListSumCombinator listSumCombinator = new ListSumCombinator();

        ArrayList<Integer> a = new ArrayList<>();
        a.add(8);
        a.add(10);
        a.add(6);
        a.add(11);
        a.add(1);
        a.add(16);
        a.add(8);
        int b = 28;
        listSumCombinator.combinationSum(a,b);
    }


    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {


        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        getResult(new ArrayList<>(),b,a,result);
        result.sort((o1, o2) -> {
            int size = o1.size() > o2.size() ? o2.size() : o1.size();
            int result1 = 0;
            for (int i = 0; i < size; i++) {
                result1 = o1.get(i).compareTo(o2.get(i));
            }
            return result1;
        });
        return result;
    }

    private void getResult(ArrayList<Integer> inputs, int sum,
                           ArrayList<Integer> outputs, ArrayList<ArrayList<Integer>> result) {

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
                getResult(inputs,sum - outputs.get(i), outputs, result);
                inputs.remove(inputs.size() - 1);
            }
        }





    }
}
