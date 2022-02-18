package companies.microsoft.february;

import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionToMakeFreqUnique {

    public int minDeletions(String s) {
        int arr[] = new int[26]; // create array to map frequencies

        for (char a : s.toCharArray()) {
            arr[a-'a']++; // count each character frequency
        }
        int ans = 0; // count
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            while (arr[i] > 0 && !set.add(arr[i])) {
                // we will try adding frequency until it is unique
                // and increment count
                ans++;
                --arr[i];
            }
        }
        return ans;
    }


}
