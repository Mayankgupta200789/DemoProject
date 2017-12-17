package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Mayank Gupta
 * @Date 12/17/17
 */
public class StringContainer {

    public static void main(String[] args) {

        StringContainer stringContainer = new StringContainer();

        Set<Character> hashSet = new HashSet<>();
        hashSet.add('a');
        hashSet.add('b');
        hashSet.add('c');
        hashSet.add('f');

        String input = "aaaaaaaaaabbbbbbbbccccccccsbabbbccc";
        stringContainer.contains(input,hashSet);

    }

    private void contains( String input, Set<Character> inputSet) {

        int i = 0;
        int j = 0;

        int len = input.length();

        Set<Character> hashSet = new HashSet<>();

        String result = "";

        int min = Integer.MAX_VALUE;

        while( i < len )  {

            while ( !inputSet.contains(input.charAt(i))) {

                i++;
            }
            char current = input.charAt(i);

            hashSet.add(current);

            if( hashSet.size() == inputSet.size() && input.substring(i, j + 1).length() < min ) {
                result = input.substring(i, j + 1);
                min = result.length();
            }

            j = i;

            while( j < (len - 1)  && current == input.charAt(j + 1) && inputSet.contains(input.charAt(j + 1))) {
                j++;
            }
            i = j;
            j++;


            while( j < len   ) {

                if(inputSet.contains(input.charAt(j))) hashSet.add(input.charAt(j));

                if( hashSet.size() == inputSet.size() && input.substring(i, j + 1).length() < min  ) {
                    result = input.substring(i, j + 1);
                    min = result.length();
                    break;
                }

                j++;
            }

            i = j;
            hashSet.clear();

        }
        System.out.println("Result is  " + result);

    }
}
