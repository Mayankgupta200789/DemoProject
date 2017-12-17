package recursion;

import java.util.*;

/**
 * @Author Mayank Gupta
 * @Date 11/23/17
 */
public class PowerSet {


    public static void main(String[] args) {
        PowerSet powerSet = new PowerSet();

        ArrayList<Integer> inputs = new ArrayList<>();

        inputs.add(20);
        inputs.add(15);
        inputs.add(10);
        inputs.add(1);
        inputs.add(19);
        inputs.add(2);
        inputs.add(13);
        inputs.add(3);
        inputs.add(7);

        powerSet.subsets(inputs);

    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        output.add(new ArrayList<Integer>());
        if (a.size() == 0)
            return output;
        Collections.sort(a);
        generate(a, output, new ArrayList<Integer>(), 0);
        return output;
    }

    public void generate(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> temp, int index)
    {
        for (int i = index; i < a.size(); i++)
        {
            temp.add(a.get(i));
            output.add(new ArrayList<Integer>(temp));
            generate(a, output, temp, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}
