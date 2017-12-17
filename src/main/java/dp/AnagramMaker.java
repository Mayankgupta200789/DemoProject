package dp;

public class AnagramMaker {
    public static int numberNeeded(String first, String second) {

        char first1[] = first.toCharArray();
        char second1[] = second.toCharArray();


        int T[][] = new int[first.length()+1][second.length()+1];

        for( int i = 0 ; i < first1.length + 1; i ++ ) {

            for( int j = 0; j < second1.length + 1; j ++ ) {

               T[i][j] = j;

            }
        }

        for( int i = 1; i < first1.length + 1; i ++ ) {
            for(int j = 1; j < second1.length + 1; j ++ ) {
                if( first1[i-1] == second1[j-1] ) {
                    T[i][j] = T[i-1][j-1];
                } else {
                    T[i][j] = T[i-1][j] + 1;
                }
            }
        }

        return T[first.length()][second.length()];
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String a = in.next();
//        String b = in.next();
        System.out.println(numberNeeded("fsqoiaidfaukvngpsugszsnseskicpejjvytviya", "ksmfgsxamduovigbasjchnoskolfwjhgetnmnkmcphqmpwnrrwtymjtwxget"));
    }
}
