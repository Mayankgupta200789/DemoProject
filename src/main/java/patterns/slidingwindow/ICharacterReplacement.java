package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;


//https://leetcode.com/problems/longest-repeating-character-replacement/
class ICharacterReplacement {
    public static int findLength(String str, int k) {

        int windowStart =0 ;
        int maxRepeat = 0;
        Map<Character,Integer> freqMap = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        //"abccde", k=1

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++ ) {

            int val1 = freqMap.getOrDefault(str.charAt(windowEnd),0);

            freqMap.put(str.charAt(windowEnd), val1 + 1);

            maxRepeat = Math.max(maxRepeat, val1 + 1);

            if( windowEnd - windowStart + 1 - maxRepeat > k ) {

                int val2 = freqMap.get(str.charAt(windowStart));

                freqMap.put(str.charAt(windowStart),val2 - 1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

        }
        return maxLength;
    }
}

