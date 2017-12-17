package decision;

import java.util.ArrayList;

/**
 * @Author Mayank Gupta
 * @Date 11/6/17
 */
public class SortedIntegersPermutator {

    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {

        SortedIntegersPermutator sortedIntegersPermutator = new SortedIntegersPermutator();

        sortedIntegersPermutator.combine(5,3);
    }



    public ArrayList<ArrayList<Integer>> combine(int n, int k) {


        combine(n,k,new ArrayList<Integer>(),1);

        return result;
    }

    private void combine(int n, int k,ArrayList<Integer> output,
                                                  int chosen) {

        if( k == 0 ) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(output);
            result.add(temp);
        } else {

            for(int i = chosen; i <= n ; i++ ) {
                output.add(i);
                combine(n,k-1,output,i + 1);
                output.remove(output.size() - 1);
            }
        }
    }
}
