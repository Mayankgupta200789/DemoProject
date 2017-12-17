package pascal;

/**
 * @Author Mayank Gupta
 * @Date 11/12/16
 */
public class PascalTriangleFormer {


    //1
    //1 1
    //1 2 1
    //1 3 3 1
    //1 4 6 4 1
    public void form(int num) {

        for( int i = 0; i < num ; i ++ ) {
            for( int j = 0 ; j <= i ; j ++ ) {

                System.out.print(pascal(i,j) + " ");
            }
            System.out.println("");

        }
    }

    private int pascal(int i , int j ){

        if(j == 0) {
            return 1;
        }

        if( j == i ) {
            return 1;
        }

        return pascal(i-1,j-1) + pascal(i-1,j);

    }
}
