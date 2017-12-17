package decision;

/**
 * @Author Mayank Gupta
 * @Date 9/24/17
 */
public class StringPermutator {
    private static int length;


    // dog

    // (dog)(og)(g)

    //(dog)(do)(

    public static void main(String args[]) {
        StringPermutator stringPermutator = new StringPermutator();

        String input = "dog";
        length = input.length();
        stringPermutator.permute("", input);
    }



    public void permute(String prefix,String input  ) {

        if( prefix.length() == length) {
            System.out.println(prefix);
        } else {

            for(int i = 0 ; i < input.length(); i++ ) {
                permute(prefix + input.charAt(i), input.substring(0,i) +input.substring(i+1,input.length()));
            }
        }

    }

}

