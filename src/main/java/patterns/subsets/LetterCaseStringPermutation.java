package patterns.subsets;

import java.util.*;

/**
 * Time complexity : O(N * 2^N)
 * Space complexity : O(N * 2^N)
 *
 *
 *
 */

public class LetterCaseStringPermutation {

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        permutations.add(str);

        for(int i = 0; i < str.length(); i++ ) {

            if(Character.isLetter(str.charAt(i))) {

                int size = permutations.size();

                for(int j = 0; j < size; j++ ) {

                    char[] chars = permutations.get(j).toCharArray();

                    if(Character.isLowerCase(chars[i])) {
                        chars[i] = Character.toUpperCase(chars[i]);
                    } else {
                        chars[i]  = Character.toLowerCase(chars[i]);
                    }

                    permutations.add(Arrays.toString(chars));
                }
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("abcdefghijkl");
        long endTime = System.currentTimeMillis();
        System.out.println("Elapse time recursive is  " + (endTime - startTime));
    }
}
