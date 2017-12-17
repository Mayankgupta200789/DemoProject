package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Mayank Gupta
 * @Date 11/23/17
 */
public class PowerSetII {

    public static void main(String[] args) {
        PowerSetII powerSetII = new PowerSetII();

        ArrayList<Integer> inputs = new ArrayList<>();

        inputs.add(5);
        inputs.add(4);

        powerSetII.subsetsWithDup(inputs);

    }

    private Set<ArrayList<Integer>> hashSet = new HashSet<>();

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {

        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        if( a.size() == 0 ) {

            return output;
        }

        Collections.sort(a);

        generate(a,output, new ArrayList<Integer>(),0);

        return output;
    }

    private void generate(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> temp,
                          int index ) {

        for( int i = index; i < a.size(); i++ ) {

            temp.add(a.get(i));
            ArrayList<Integer> newTemp = new ArrayList<>(temp);
            Collections.sort(newTemp);
            if( !hashSet.contains(newTemp)) {
                hashSet.add(newTemp);
                output.add(newTemp);
            }
            generate(a,output,temp,i + 1);
            temp.remove(temp.size() - 1 );

        }

    }
}
