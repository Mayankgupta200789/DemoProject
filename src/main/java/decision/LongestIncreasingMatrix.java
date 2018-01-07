package decision;

/**
 * @Author Mayank Gupta
 * @Date 1/1/18
 */
public class LongestIncreasingMatrix {

    int max = 1;
    int result = 1;

    int[][] dp;

    public static void main(String[] args) {

        int[][] matrix = new int[3][3];

        matrix[0][0] = 9;
        matrix[0][1] = 9;
        matrix[0][2] = 4;
        matrix[1][0] = 6;
        matrix[1][1] = 6;
        matrix[1][2] = 8;
        matrix[2][0] = 2;
        matrix[2][1] = 1;
        matrix[2][2] = 1;

        LongestIncreasingMatrix longestIncreasingMatrix = new LongestIncreasingMatrix();

        longestIncreasingMatrix.longestIncreasingPath(matrix);


    }

    public int longestIncreasingPath(int[][] matrix) {

        if( matrix == null  || matrix.length == 0 || (matrix.length == 1 && matrix[0].length == 0)  ) return 0;

        dp = new int[matrix.length][matrix[0].length];
        for(int i = 0 ; i < matrix.length; i++ ) {
            for(int j = 0 ; j < matrix[i].length; j++ ) {

                longestSequence(matrix,i,j,result);
            }
        }

        return max;

    }


    private void longestSequence(int[][] matrix, int i, int j,int result ) {

        //[9,9,4],
        //[6,6,8],
        //[2,1,1]

        if( dp[i][j] != 0  ) return;


        if( i >= ( matrix.length) || j >= ( matrix[i].length) || i < 0 || j < 0 ) return;

        if( j < ( matrix[i].length - 1) && matrix[i][j] < matrix[i][j+1] )  longestSequence(matrix,i,j+1,result+1);

        if(i < ( matrix.length - 1 ) && matrix[i][j] < matrix[i+1][j] )   longestSequence(matrix,i + 1,j,result+1);

        if(i > 0 && matrix[i][j] < matrix[i-1][j] )  longestSequence(matrix,i - 1,j,result+1);

        if(j > 0 && matrix[i][j] < matrix[i][j-1] )  longestSequence(matrix,i,j - 1,result+1);


        max = max < result ? result : max;

        dp[i][j] = result;
    }
}
