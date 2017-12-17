package dp;

/**
 * @Author Mayank Gupta
 * @Date 9/16/17
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {


        String result ="";

        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        for(int i = (len - 1); i >= 0; i++ ){

            for(int j = i; j < len;j++ ) {

                dp[i][j] = (s.charAt(i) == s.charAt(j)) && ((j - i) < 3 || dp[i+1][j-1]);

                if(dp[i][j] && result.length() < (j - i) ) {
                    result = s.substring(i,j+1);
                }

            }
        }

        return result;

    }

}
