package companies.axon;

import java.util.*;

public class LetterCombinatinoOfPhoneNumber {

    public static void main(String[] args) {
        new LetterCombinatinoOfPhoneNumber().letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {


        Map<Integer,List<Character>> hashMap = new HashMap<>();
        List<String> result = new ArrayList<>();

        hashMap.put(2,Arrays.asList('a','b','c'));
        hashMap.put(3,Arrays.asList('d','e','f'));
        hashMap.put(4, Arrays.asList('g','h','i'));
        hashMap.put(5,Arrays.asList('j','k','l'));
        hashMap.put(6,Arrays.asList('m','n','o'));
        hashMap.put(7,Arrays.asList('p','q','r','s'));
        hashMap.put(8,Arrays.asList('t','u','v'));
        hashMap.put(9,Arrays.asList('w','x','y','z'));


        cartesian(digits,0,new StringBuilder(),result,hashMap);

        return result;


    }

    public static void cartesian(String digits,
                                 int startIndex,
                                 StringBuilder output,
                                 List<String> result,
                                 Map<Integer,List<Character>> hashMap) {

        if(output.length() == digits.length()) {

            result.add(String.valueOf(output));
        }else {
                int number = digits.charAt(startIndex)  - 48;

                List<Character> inputs = hashMap.get(number);
                for(int j = 0 ; j < inputs.size(); j++ ){

                    cartesian(digits,startIndex + 1, output.append(inputs.get(j)),result,hashMap);
                    output.deleteCharAt(output.length() - 1);
                }
        }


    }
}
