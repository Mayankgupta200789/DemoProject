package companies.versanetworks;


public class LargeIntegers {

    public String add(String s1, String s2) {

        if(s1 == null && s2 == null ) return null;
        else if( s2 == null )return s1;
        else if(s1 == null ) return s2;

        int length1 = s1.length();
        int length2 = s2.length();
        int min = Math.min(length2, length1);
        int max = Math.max(length2, length1);

        int carry = 0;
        StringBuilder output = new StringBuilder();

        int j = max - 1;
        for(int i = (min - 1); i >= 0; i--   ) {

            int input1 = Integer.parseInt(String.valueOf(s1.charAt(i)));
            int input2 = Integer.parseInt(String.valueOf(s2.charAt(j)));

            int sum = input1 + input2 + carry;
            int result = sum % 10;
            carry = sum /10;

            output.insert(0,result);
            j--;
        }


        if(length1 > length2 ) {
            getRemainingSum(s1, length1, length2, carry, output);

        } else {
            getRemainingSum(s2, length2, length1, carry, output);
        }

        return output.toString();



    }

    private void getRemainingSum(String s1, int length1, int length2, int carry, StringBuilder output) {
        int remainingLength;
        remainingLength = length1 - length2;
        //    12345
        // 67890123
        // 67902468

        for (int j = (remainingLength - 1); j >= 0; j--) {

            int input1 = Integer.parseInt(String.valueOf(s1.charAt(j)));

            int sum = input1 + carry;
            int result = sum % 10;
            carry = sum / 10;

            output.insert(0, result);

        }

        if(carry != 0 ) {
            output.insert(0, carry);
        }
    }
}
