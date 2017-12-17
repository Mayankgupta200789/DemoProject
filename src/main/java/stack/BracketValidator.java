package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author Mayank Gupta
 * @Date 9/27/17
 */
public class BracketValidator {

    private static Map<Character,Character> hashMap = new HashMap<>();
    static {
        hashMap.put('}','{');
        hashMap.put(')','(');
        hashMap.put(']','[');
    }

    private static Stack<Character> stack = new Stack<>();

    static String isBalanced(String s) {
        // Complete this function

        if( s == null || s.isEmpty() ) {
            return "NO";
        }
        //{{[[(())]]}}



        for(int i = 0 ; i < s.length(); i++ ) {

            if( s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[' ) {
                stack.push(s.charAt(i));
            } else {

                if( stack.isEmpty()) {
                    return "NO";
                }

                char pop = stack.pop();

                if( pop != hashMap.get(s.charAt(i)) ) {
                    return "NO";
                }
            }
        }

        if( stack.isEmpty() ) {
            return "YES";
        } else {
            return "NO";
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }
}
