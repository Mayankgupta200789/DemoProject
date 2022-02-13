package patterns.subsets;

import java.util.*;

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

    public List<List<Integer>> permuteBFS(int[] nums) {

        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>());

        for(int number : nums ) {
            int n = subsets.size();
            for(int i = 0 ; i < n ; i++ ) {

                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(number);
                if(set.size() == nums.length) subsets.add(set);
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
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
