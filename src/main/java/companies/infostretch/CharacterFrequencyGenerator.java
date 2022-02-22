package companies.infostretch;/* Implement a method which performs basic string compression by counting sequences of repeating characters. Given "AABBBCCCD" it should return "A2B3C3D1".
#
# Sample Input:
#
# AABBBCCCD
# ABCDE
# KKKKK
#
# Sample Output:
#
# A2B3C3D1
# A1B1C1D1E1
# K5
*/


import java.io.*;
import java.util.*;

public class CharacterFrequencyGenerator {
    static String compress(String str)
    {
        if(str == null || str.isEmpty()) {
            return str;
        }

        if(str.length() == 1) {
            return str.charAt(0) + "1";
        }

        char lastChar = str.charAt(0);
        int lastCount = 1;

        StringBuilder result = new StringBuilder();

        //aaBBBa
        //
        for(int i = 1; i < str.length();i++ ) {

            if(str.charAt(i) == lastChar) {
                lastCount++;
            } else {

                result.append(lastChar);
                result.append(lastCount);

                lastChar = str.charAt(i);
                lastCount = 1;
            }

        }

        result.append(lastChar);
        result.append(lastCount);




        return result.toString();
    }


    public static void check(String input, String expected)
    {
        if( compress(input).equals(expected))
        {
            System.out.println("Pass");
        }
        else
        {
            System.out.println("Fail, input [" + input + "]");
        }
    }


    public static void main(String[] args) {
        check("AABBBCCCD", "A2B3C3D1");
        check("ABCDE", "A1B1C1D1E1");
        check("KKKKK", "K5");
        check("", "");
        check("aaa", "a3");
        check("Abcda", "A1b1c1d1a1");
        check("a", "a1");
        check("aaBBBa", "a2B3a1" );
    }
}
