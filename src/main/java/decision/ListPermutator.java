package decision;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Mayank Gupta
 * @Date 9/24/17
 */
public class ListPermutator {

    private List<List<String>> result = new LinkedList<>();


    public static void main(String args[]) {
        List<String> input1 = new LinkedList<>();
        List<String> input2 = new LinkedList<>();

        input1.add("abc");
        input1.add("cde");
        input1.add("fgh");
        input1.add("lmn");

        input2.add("ijk");

        ListPermutator listPermutator = new ListPermutator();
        listPermutator.permute(input1,input2);

        System.out.println(listPermutator.result);
    }

    public void permute(List<String>... a) {

        doPermute(0,new LinkedList<String>(),a);
    }

    public void doPermute(int start,List<String> output,  List<String>... a) {

        if( start == a.length && output.size() == a.length ) {
            List<String> temp = new LinkedList<>();
            temp.addAll(output);
            result.add(temp);
        } else {

            for(int i = start; i < a.length; i++ ) {
                for(int j = 0; j < a[i].size();j++  ) {
                    output.add(a[i].get(j));
                    doPermute(i + 1, output,a);
                    output.remove(output.size() - 1 );
                }
            }


        }

    }


}
