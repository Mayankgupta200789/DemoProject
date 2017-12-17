package string;

/**
 * @Author Mayank Gupta
 * @Date 11/9/16
 */
public class StringCharRemover {

    // le 'e'  e


    public String remove(String word, char a) {

        if( word == null || word.isEmpty()) {
            return word;
        }

        char[] chars = word.toCharArray();

        int index = -1;

        for(int i = 0 ; i < word.length() ; i++ ) { //Hello

            char c = word.charAt(i); //H

            if( c == a ) {
                String before = word.substring(0, i);//
                String after = word.substring(i+1);
                word = before + after;
            }
        }



        return word;
    }
}
