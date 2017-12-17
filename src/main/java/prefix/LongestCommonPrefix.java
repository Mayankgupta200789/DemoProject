package prefix;

/**
 * @Author Mayank Gupta
 * @Date 10/4/17
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        String[] inputs = {"abbbdadadaad","asbadafasdaaf","asdasdfasdfdasf"};

        String output = longestCommonPrefix.longestCommonPrefix(inputs);

        System.out.println("The longest prefix is " + output );

    }


    public String longestCommonPrefix(String[] strs) {

        String output = "";

        if( strs == null || strs.length == 0 ) {
            return output;
        }

        output = strs[0];

        if( strs.length ==  1) {
            return output;
        }


        for(int i = 1; i < strs.length; i++ ) {
            output = getLongestPrefix(output,strs[i]);
        }

        return output;

    }

    private String getLongestPrefix(String input1,String input2 ) {

        String result = "";

        if(input1 == null || input1.length() == 0 || input2 == null || input2.length() == 0 ) {
            return result;
        }

        int smallerLength;
        if(input1.length() > input2.length() ) {
            smallerLength = input2.length();
        } else {
            smallerLength = input1.length();
        }


        for(int i = 0; i < smallerLength; i++ ) {

            if(input1.charAt(i) == input2.charAt(i) ) {
                result += input1.charAt(i);
            } else {
                break;
            }
        }

        return result;


    }
}
