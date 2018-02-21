package decision;

/**
 * @Author Mayank Gupta
 * @Date 9/24/17
 */
public class BinaryGenerator {

    public static void main(String args[]) {
        BinaryGenerator binaryGenerator = new BinaryGenerator();
        binaryGenerator.generate(7,"");
    }


    private void generate(int input, String prefix) {

        if( input == 0 ) {
            System.out.println(prefix);
        } else {
            // 1000
            //  8%2 = 0
            //  4%2 = 0
            //  2%2 = 0
            //  1%  = 1
            for(int i = 0 ; i <= 1; i++ ) {
                generate(input - 1,prefix + String.valueOf(i));
            }
            //0111

        }
    }
}
