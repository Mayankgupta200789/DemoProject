package array;

import java.util.ArrayList;

/**
 * @Author Mayank Gupta
 * @Date 8/26/17
 */
public class AntiDiagnol {

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if( a == null || a.size() == 0 ) {
            return result;
        }

        int i = 0;
        int j = 0;

        int startI = i;
        int startJ = j;

        int len = a.size();

        while( true) {

            startI = i;
            startJ = j;

            ArrayList<Integer> output = new ArrayList<>();

            while( i < len && j >= 0 ) {

                output.add(a.get(i++).get(j--));

            }

            i = startI;
            j = startJ;

            if( j < (len - 1) ) {

                j++;
            } else {

                i++;
            }

            result.add(output);

            if( i == ( len - 1) && j == (len - 1)) {
                break;
            }

        }

        ArrayList<Integer> output = new ArrayList<>();
        output.add(a.get(i).get(j));
        result.add(output);


        return result;

    }
}
