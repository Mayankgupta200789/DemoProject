package string;

//Implement strStr().
//
//        Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//        Clarification:
//
//        What should we return when needle is an empty string? This is a great question to ask during an interview.
//
//        For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
// Concept clear for Boyce Moore algorithm
//https://www.geeksforgeeks.org/boyer-moore-algorithm-for-pattern-searching/
public class StringSearch {

    public int search(String haystack, String needle) {

        if(needle.length() == 0 ) return 0;
        if(haystack.length() == 0 ) return -1;

        if(haystack.length() < needle.length() ) return -1;


        int startHayStack = 0;
        int endHayStack = needle.length() - 1;

        int endNeedle = needle.length() - 1;

        while( endHayStack < haystack.length()
                && endNeedle < needle.length()) {

            if( haystack.charAt(endHayStack) != needle.charAt(endNeedle)) {

                endNeedle--;

                while(endNeedle > -1 ){

                    if( haystack.charAt(endHayStack) != needle.charAt(endNeedle)) {

                        endNeedle--;
                    } else {

                        startHayStack = endHayStack - endNeedle;
                        endHayStack = startHayStack + needle.length() - 1;
                        endNeedle = needle.length() - 1;
                        break;
                    }
                }

                if(endNeedle < 0 ) {
                    startHayStack = endHayStack + 1;
                    endHayStack = startHayStack + needle.length() - 1;
                    endNeedle = needle.length() - 1;
                }
            } else {

                if(startHayStack  == endHayStack  ) {
                    return startHayStack;
                }
                endHayStack--;
                endNeedle--;
            }
        }
        return -1;
    }
}
