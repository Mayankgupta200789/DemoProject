package decision;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Mayank Gupta
 * @Date 9/25/17
 */
public class DicePermutator {

    private List<List<Integer>> result = new LinkedList<>();

    public static void main(String args[]) {

        DicePermutator dicePermutator = new DicePermutator();


//        dicePermutator.permute(3);
//        dicePermutator.queenBoard.clear();
        dicePermutator.doPermute(2,new LinkedList<Integer>());

        for(List<Integer> output :dicePermutator.result ) {
            System.out.println(output);
        }
    }

    public void permute(int numberOfDice) {

        if (numberOfDice != 0) {

            if( result.isEmpty() ) {

                for(int i = 1; i <= 6; i++ ) {
                    List<Integer> output = new LinkedList<>();
                    output.add(i);
                    result.add(output);
                }
            } else {

                List<List<Integer>> ans = new LinkedList<>();
                for( List<Integer> inputs : result ) {

                    for(int i = 1; i <= 6; i++ ) {
                        List<Integer> output = new LinkedList<>();
                        output.addAll(inputs);
                        output.add(i);
                        ans.add(output);
                    }
                }

                result = ans;
            }

            permute(numberOfDice - 1);

        }


    }

    public void doPermute(int numberOfDice,List<Integer> output ) {

         if( numberOfDice == 0 ) {
             List<Integer> temp = new LinkedList<>();
             temp.addAll(output);
             result.add(temp);
         }else {

             for(int i = 1; i <= 6; i++ ) {
                 output.add(i);
                 doPermute(numberOfDice - 1, output);
                 output.remove(output.size() - 1);
             }
         }

    }
}
