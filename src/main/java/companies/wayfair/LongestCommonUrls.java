package companies.wayfair;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonUrls {

    public static void main(String[] args) {

        String[] user1 = new String[]{"/home", "/register", "/login", "/user", "/one", "/two","/fourfive","/asdfa","/six" };
        String[] user2 = new String[]{"/home", "/register", "/login", "/user", "/one", "/pink" };
        new LongestCommonUrls().lcs(user1,user2);
    }


    public List<String> lcs(String[] user1, String[] user2) {

        int[][] dp = new int[user1.length + 1][user2.length + 1];
        List<String> result = new ArrayList<>();


        for(int i = 1 ; i < dp.length; i++ ) {

            for(int j = 1 ; j < dp[i].length;j++ ){

                if(user1[i - 1].equalsIgnoreCase(user2[j - 1])){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int i = user1.length;
        int j = user2.length;

        while(i > 0 ) {

            while( i > 0 && j > 0 ) {

                if(dp[i-1][j] != dp[i][j] && dp[i][j-1]  != dp[i][j]) {
                    result.add(0,user1[i - 1]);
                    i--;
                    j--;
                }else if (dp[i-1][j] == dp[i][j] && dp[i][j-1]  == dp[i][j]) {
                    j--;
                }else if(dp[i-1][j] == dp[i][j]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        return result;

    }
}
