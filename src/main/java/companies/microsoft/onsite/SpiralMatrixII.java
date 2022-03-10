package companies.microsoft.onsite;

public class SpiralMatrixII {
        public int[][] generateMatrix(int n) {

            int[][] matrix = new int[n][n];

            int top = 0, bottom = matrix[n-1].length - 1, left = 0,right = matrix.length - 1;

            int start = 1;
            int dir = 0;
            int i = 0;

            while(left <= right ) {

                // left to right
                if(dir == 0 ) {
                    i = left;
                    while(i <= right ) {
                        matrix[top][i++] = start++;
                    }
                    top += 1;
                    dir = 1;
                }
                // top to bottom
                else if (dir == 1 ) {
                    i = top;

                    while( i <= bottom) {
                        matrix[i++][right] = start++;
                    }
                    right -= 1;
                    dir = 2;
                }
                // travel right to left
                else if (dir == 2 ) {
                    i = right;

                    while( i >= left ) {
                        matrix[bottom][i--] = start++;
                    }
                    bottom -= 1;
                    dir = 3;
                }
                // travel bottom to top
                else if (dir == 3) {
                    i = bottom;

                    while(i >= top ) {
                        matrix[i--][left] = start++;
                    }
                    left += 1;
                    dir = 0;
                }
            }

            return matrix;

        }
}
