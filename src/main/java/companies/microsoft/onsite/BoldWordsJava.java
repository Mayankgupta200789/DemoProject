package companies.microsoft.onsite;

import java.util.Arrays;

public class BoldWordsJava {

    public static void main(String[] args) {

        new BoldWordsJava().boldWords(new String[]{"abc"}, "aabcdasabcasfafdsfa");
    }

    public String boldWords(String[] words, String s ) {

        boolean[] bold = new boolean[s.length() + 1];

        for(String w : words) {
            for(int i = s.indexOf(w); i != -1; i = s.indexOf(w,i+1)) {
                Arrays.fill(bold,i,i + w.length(),true);
            }
        }
        StringBuilder result = new StringBuilder(bold[0] ? "<b>" : "");

        for(int i = 0 ; i < bold.length - 1; i++ ) {
            result.append(s.charAt(i));
            result.append(bold[i] && !bold[i+1] ? "</b>" : "");
            result.append(!bold[i] && bold[i+1] ? "<b>" : "");
        }

        return result.toString();


    }
}
