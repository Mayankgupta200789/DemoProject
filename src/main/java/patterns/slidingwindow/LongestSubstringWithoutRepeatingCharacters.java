package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        int windowStart = 0;
        int max = Integer.MIN_VALUE;
        Map<Character,Integer> hashMap = new HashMap<>();

        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++ ) {

            hashMap.put(s.charAt(windowEnd),hashMap.getOrDefault(s.charAt(windowEnd),0) + 1);

            while(hashMap.get(s.charAt(windowEnd)) > 1) {


                hashMap.put(s.charAt(windowStart),hashMap.get(s.charAt(windowStart)) - 1);

                if(hashMap.get(s.charAt(windowStart)) == 0 ) {
                    hashMap.remove(s.charAt(windowStart));
                }

                windowStart++;

            }
            max = Math.max(max, ((windowEnd) - windowStart) + 1);
        }


        return max != Integer.MIN_VALUE ? max : s.length();

    }
}
