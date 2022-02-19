package companies.microsoft.february;

import java.util.HashMap;
import java.util.Map;

public class MinimumSwapsToMakePalindrome {



    public int getNoOfSwaps(String input) {

        int i = 0;
        int j = input.length() - 1;
        int totalSwap =0;
        char[] inputArray = input.toCharArray();


        if(!canStringBePalindrome(input)) return -1;

        while(i < j) {

            if(inputArray[i] != inputArray[j]) {

                int k = j;

                while(i < k && inputArray[i] != inputArray[k]) {
                    k--;
                }


                if(i == k ) {
                    swap(inputArray,i,i + 1);
                    totalSwap++;
                } else {
                    while(k < j ) {
                       swap(inputArray, k, k + 1);
                       k++;
                       totalSwap++;
                    }
                    i++;
                    j--;
                }

            } else {
                i++;j--;
            }


        }

        return totalSwap;

    }

    private void swap(char[] chars, int i, int j) {

        char k = chars[i];
        chars[i] = chars[j];
        chars[j] = k;
    }

    private boolean canStringBePalindrome(String input) {

        Map<Character,Integer> hashMap = new HashMap<>();
        int totalEntry = 0;
        for(int i = 0 ; i < input.length(); i++ ) {

            hashMap.put(input.charAt(i),hashMap.getOrDefault(input.charAt(i),0) + 1);
        }

        for(Map.Entry<Character,Integer> entry : hashMap.entrySet()) {

            if(entry.getValue() % 2 != 0) {
                totalEntry++;
            }
        }

        return totalEntry <= 1;
    }


}
