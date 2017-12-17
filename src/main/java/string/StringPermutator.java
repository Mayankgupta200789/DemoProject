package string;

/**
 * @Author Mayank Gupta
 * @Date 9/23/17
 */
public class StringPermutator {

    public void permute(String input ) {
        doPermute("",input);
    }

    private void doPermute(String prefix,String input ) {

        if( input.isEmpty())  {
            System.out.println(prefix);
        } else {

            for(int i = 0; i < input.length(); i++  ) {
                doPermute(prefix + input.charAt(i),
                        input.substring(0,i) + input.substring(i+1,input.length()));
            }
        }

    }
}
