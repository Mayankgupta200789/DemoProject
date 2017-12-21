package decision;

import java.util.ArrayList;

/**
 * @Author Mayank Gupta
 * @Date 12/21/17
 */
public class KthPermutationSequence {

    public String getPermutation(int n, int k) {

        if( k > n ) {
            return null;
        }

        ArrayList<Integer> inputs = new ArrayList<>();

        ArrayList<ArrayList<Integer>> output = new ArrayList<>();

        for(int i = 1; i <= n ; i++ ) {
            inputs.add(i);
        }
        //inputs = {1,2}
        doPermute(output, inputs, new ArrayList<>(),k);

        ArrayList<Integer> result = output.remove(output.size() - 1);

        StringBuilder tempBuilder = new StringBuilder();
        for(Integer value : result ) {
            tempBuilder.append(String.valueOf(value));
        }

        return tempBuilder.toString();
    }

    private void doPermute(ArrayList<ArrayList<Integer>> output,
                           ArrayList<Integer> choices,
                           ArrayList<Integer> inputs,
                           int k) {

        if( choices.size() == 0 ){

            ArrayList temp = new ArrayList<>(inputs);
            output.addAll(temp);
            return;
        }

        if( output.size() == k ) {
            return;
        }



        for(int i = 0 ; i < choices.size(); i++ )  {

            Integer a = choices.get(i);
            choices.remove(a);
            inputs.add(a);
            doPermute(output,choices,inputs,k );
            inputs.remove(inputs.size() - 1);
            choices.add(i, a);
        }



    }
}
