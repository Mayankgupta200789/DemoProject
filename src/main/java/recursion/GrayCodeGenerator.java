package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mayank Gupta
 * @Date 12/20/17
 */
public class GrayCodeGenerator {


    public static void main(String[] args) {

        GrayCodeGenerator grayCodeGenerator = new GrayCodeGenerator();

        grayCodeGenerator.grayCode(10);
    }


    public ArrayList<Integer> grayCode(int a) {

        ArrayList<Integer> output = new ArrayList<>();
        if( a < 0 ) {
            return output;
        }

        output.add(0);
        doGrayCode(output,a);

        return output;
    }

    private void doGrayCode(List<Integer> output, int a ) {

        if( output.size() == (int) Math.pow(2,a)) {
            return;
        }

        int size = output.size();
        for(int i = (size - 1); i >= 0 ; i-- ) {
            output.add(output.get(i) + size);
        }

        doGrayCode(output,a);

    }
}
