package companies.axon;

import java.util.Stack;

public class LongestValidParenthesis {

    public int longestValidParentheses(String s) {

        Stack<Integer> indexes = new Stack<>();
        // This is keeping track of last valid bracket index
        indexes.push(-1);
        int result = 0;

        for(int i = 0 ; i < s.length(); i++ ) {

            if(s.charAt(i) == '(') {
                indexes.push(i);
            } else {
                indexes.pop();
                // If indexes are empty, then brackets are not valid
                // So insert the current index
                if(indexes.isEmpty()){
                    indexes.push(i);
                } else {
                    result = Math.max(result,i - indexes.peek());
                }
            }
        }

        return result;
    }
}
