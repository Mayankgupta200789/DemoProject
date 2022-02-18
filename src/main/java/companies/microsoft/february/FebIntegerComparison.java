package companies.microsoft.february;

import java.util.Arrays;
import java.util.List;

public class FebIntegerComparison {


    public int getMax(Integer input) {

            if(input >= -10 && input < 10 ) {
                return input;
            }

            StringBuilder stringBuilder = new StringBuilder(input + "");

            int result = Integer.MIN_VALUE;

            boolean flag = false;

            for(int i = 0 ; i < stringBuilder.length(); i++ ) {
                if(stringBuilder.charAt(i) == '5') {

                    stringBuilder.deleteCharAt(i);
                    result = Math.max(result,Integer.parseInt(stringBuilder.toString()));
                    stringBuilder.insert(i,5);
                    flag = true;
                }
            }

            if(flag)return result;
            return input;


    }



}
