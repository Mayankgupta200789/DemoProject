package string;

/**
 * @Author Mayank Gupta
 * @Date 11/11/16
 */
public class StringWildCardProblem {


    /// sap , string wild card
    // s*p sap, saap, s1223p
    //
    // sp*;


    public boolean match(String s,String exp) {


       boolean T[][] = new boolean[s.length()][exp.length()];

        char[] s1 = s.toCharArray();
        char[] c1 = exp.toCharArray();



        for( int i = 0; i < s.length();i++ ) {

            for( int j = 0 ; j < exp.length(); j++ ) {



                if( s1[i] == c1[j] ) {
                    T[i][j] = true;
                }


                if( c1[j] == '?' ){

                    if( i == 0 || j == 0) {
                        T[i][j] = true;
                    } else {
                        T[i][j] = T[i - 1][j - 1];
                    }
                }

                if( c1[j] == '*' ){

                    if( i == 0 || j == 0) {
                        T[i][j] = true;
                    } else if( j == exp.length() - 1){
                        T[i][j] = T[i-1][j];
                    } else {
                        T[i][j] = T[i-1][j] || T[i][j+1];
                    }
                }
            }
        }

        return T[s.length()-1][exp.length()-1];



    }
}
