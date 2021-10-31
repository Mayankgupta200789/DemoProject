package patterns.slidingwindow;

import java.util.*;

class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        int windowStart = 0;
        Set<Character> hashSet = new HashSet<>();
        int maxString = Integer.MIN_VALUE;
        boolean isMaxStringSet = false;
        //"araaci", K=2
        // "cbbebi", K=3
        // "cbbebi", K=10

        for(int windowEnd = 0 ; windowEnd < str.length();windowEnd++ ){

            hashSet.add(str.charAt(windowEnd));

            if(hashSet.size() > k ){
                maxString = Math.max(maxString, ((windowEnd - 1) - windowStart) + 1);
                hashSet.remove(str.charAt(windowStart));
                windowStart++;
                isMaxStringSet = true;
            }
        }

        if(!isMaxStringSet && hashSet.size() <= k ) {
            maxString = str.length();
        }
        return maxString != Integer.MIN_VALUE ? maxString : 0;
    }
}
