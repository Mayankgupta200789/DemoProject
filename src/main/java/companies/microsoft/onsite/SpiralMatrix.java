package companies.microsoft.onsite;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 ) return new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int moveFlag = 0;
        List<Integer> result = new ArrayList<>();
        int i = 0;

        // left = 1
        // right = 1
        // top = 1;
        // bottom = 1;
        // 1 2 3 6 9 8 7 4
        // i = 1
        while(left <= right && top <= bottom ) {

            // left to right
            if(moveFlag == 0 ) {
                i = left;
                while(i <= right ){
                    result.add(matrix[top][i++]);
                }
                top += 1;
                moveFlag = 1;
            }
            // top to bottom
            else if(moveFlag == 1) {
                i = top;
                while(i <= bottom ) {
                    result.add(matrix[i++][right]);
                }
                right -= 1;
                moveFlag = 2;

            } // right to left
            else if ( moveFlag == 2 ) {
                i = right;
                while(i >= left ) {
                    result.add(matrix[bottom][i--]);
                }
                bottom -= 1;
                moveFlag = 3;
            }
            // bottom to top
            else if ( moveFlag == 3 ) {
                i = bottom;
                while(i >= top ) {
                    result.add(matrix[i--][left]);
                }

                left += 1;
                moveFlag = 0;
            }

        }
        return result;

    }
}
