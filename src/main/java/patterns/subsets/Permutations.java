package patterns.subsets;

import java.util.*;

  /**
        Time complexity
        We know that there are a total of N! permutations of a set with ‘N’ numbers.
        In the algorithm above, we are iterating through all of these permutations with the help of the two ‘for’ loops.
        In each iteration, we go through all the current permutations to insert a new number in them on line 17 (line 23 for C++ solution).
        To insert a number into a permutation of size ‘N’ will take O(N*N!)., which makes the overall time complexity of our algorithm O(N*N!)..

        Space complexity#
        All the additional space used by our algorithm is for the result list and the queue to store the intermediate permutations.
        If you see closely, at any time, we don’t have more than N! permutations between the result list and the queue.
        Therefore, the overall space complexity to store N!N! permutations each containing NN elements will be O(N*N!).

   **/

class Permutations {

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> choices = new ArrayList<>();

        for(int elem : nums ){
            choices.add(elem);
        }

        doFindPermutationsRecursively(result,new ArrayList<>(),choices);


        return result;
    }

    public static List<List<Integer>> permuteBFS(int[] nums) {

        List<List<Integer>> subsets = new ArrayList<>();

        Queue<List<Integer>> permutations = new LinkedList<>();

        permutations.add(new ArrayList<>());

        for(int number : nums ) {

            int size = permutations.size();

            for(int i = 0 ; i < size; i++ ) {
                List<Integer> oldPermutations = permutations.poll();

                for(int j = 0 ; j <= oldPermutations.size(); j++ ) {

                    List<Integer> newPermutations = new ArrayList<>(oldPermutations);
                    newPermutations.add(j, number);

                    if(newPermutations.size() == nums.length ) subsets.add(newPermutations);
                    else permutations.add(newPermutations);
                }
            }
        }


        return subsets;
    }

    public static void doFindPermutationsRecursively(List<List<Integer>> result,
                                                     List<Integer> prefix, List<Integer> choices) {

        if(choices.size() == 0 ) {
            result.add(new ArrayList<>(prefix));
        } else {
            for (int i = 0; i < choices.size(); i++) {

                prefix.add(choices.get(i));
                int elem = choices.remove(i);
                doFindPermutationsRecursively(result, prefix, choices);
                prefix.remove(prefix.size() - 1);
                choices.add(i, elem);
            }
        }

    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 0,1, 2,3,4,5,6,7,8,9});
        long endTime = System.currentTimeMillis();
        System.out.println("Elapse time recursive is  " + (endTime - startTime)/10);
        long startTime2 = System.currentTimeMillis();
        List<List<Integer>> result2 = Permutations.permuteBFS(new int[] { 0,1, 2,3,4,5,6,7,8,9 });
        long endTime2 = System.currentTimeMillis();
        System.out.println("Elapse time bfs approach is  " + (endTime2 - startTime2)/10);
//        System.out.println("Here are all the permutations: " + result);
//        System.out.print("Here are all the permutations: " + result2);
    }
}
