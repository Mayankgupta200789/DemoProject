package array;

import java.util.ArrayList;
import java.util.List;


/**
 * UNFORTUNATELY I HAVE TO LOOK INTO THE SOLUTION FOR THIS ONE
 * I COULDN"T CODE IT BY MYSELF.
 * THIS IS REALLY COMPLICATED QUESTION
 *
 * idea is you have choices on every turn
 * for eg
 * 1 2 3 4 5
 *      then put 1 updated choices list to  (2 3 4 5)
 *          then put 1 2 update choice list to (3 4 5)
 *              then put 1 2 3 update choice list to ( 4 5)
 *                  then put 1 2 3 4  update choice list to (5)
 *                      then put 1 2 3 4 5 update choice list to ()
 *                          once choices are zero , enter create new arraylist of this output or prefix that you created and then insert into the list
 *                      after this remove last element so it becomes 1 2 3 4 update choice list to 5
 *
 *
 *
 *
 *
 */

public class PermuteArray {

    public List<List<Integer>> permute(int[] nums) {


        List<Integer> choices = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i = 0 ; i < nums.length; i++ ) {
            choices.add(nums[i]);
        }

        doPermute(new ArrayList<>(),choices,result);

        return result;

    }

    public void doPermute(List<Integer> prefix, List<Integer> choices,List<List<Integer>> result) {

        // 1 (2 3) i = 0 element = 1
        // 1 2 (3) i = 0 element = 2
        // 1 2 3 () i = 0
        // 1  (2 3) element = 3 i = 1
        // 1 3 (2)
        if(choices.size() == 0 ) {
            result.add(new ArrayList<Integer>(prefix));
        }
            for(int i = 0 ; i < choices.size(); i++ ) {

                prefix.add(choices.get(i));
                int element = choices.remove(i);
                doPermute(prefix,choices,result);
                prefix.remove(prefix.size() - 1);
                choices.add(i,element);
            }

    }
}
