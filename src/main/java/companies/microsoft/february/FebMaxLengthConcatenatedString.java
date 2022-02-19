package companies.microsoft.february;

import java.util.*;

public class FebMaxLengthConcatenatedString {

    public int maxLength(List<String> arr) {

        // r act ers cha


        int result = 0;
        if(arr == null || arr.size() <= 1 ){
            return result;
        }

        arr.sort((a, b) -> (b.length() - a.length()));

        Set<String> uniqueSet = new LinkedHashSet<>(arr);



        return minLen + maxLength;




    }

    public int permuteUnique(List<String> arr) {

        int result = 0;
        if( arr == null || arr.size() == 0 ) {
            return result;
        }

        List<Integer> choices = new ArrayList<>();
        arr.sort((a, b) -> (b.length() - a.length()));
        Set<Character> hashSet = new HashSet<>();

        for(int i = 0 ; i <  arr.size();i++ ) {

            String input = arr.get(i);

            int count =0 ;

           for(int i =0 ; i < input.length(); i++ ) {


               boolean flag = hashSet.add(input.charAt(i));
               if()
           }
        }

        doPermute(new ArrayList<>(),choices);

        return result;

    }

    private void doPermute(List<Integer> prefix, List<Integer> choices) {

        if( choices.size() == 0 ) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(prefix);
            if( !hashSet.contains(temp)) {
                hashSet.add(temp);
                result.add(temp);
            }
        } else {

            for(int i = 0; i < choices.size(); i++ ) {
                prefix.add(choices.get(i));
                int element = choices.remove(i);
                doPermute(prefix,choices);
                prefix.remove(prefix.size() - 1);
                choices.add(i,element);
            }
        }


    }


}
