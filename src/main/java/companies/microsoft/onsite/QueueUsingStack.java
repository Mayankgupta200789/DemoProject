package companies.microsoft.onsite;

import java.util.Stack;

public class QueueUsingStack {

    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> popStack = new Stack<>();

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {

        if(popStack.isEmpty() && pushStack.isEmpty()) {
            return -1;
        }
        if(popStack.isEmpty()) {

            while(!pushStack.isEmpty()) {

                int input = pushStack.pop();
                popStack.push(input);
            }
            return popStack.pop();

        } else {

            return popStack.pop();

        }
    }

    public int peek() {
        if(popStack.isEmpty() && pushStack.isEmpty()) {
            return -1;
        }
        if(popStack.isEmpty()) {

            while(!pushStack.isEmpty()) {

                int input = pushStack.pop();
                popStack.push(input);
            }
            return popStack.peek();

        } else {

            return popStack.peek();

        }
    }

    public boolean empty() {

        return pushStack.isEmpty() && popStack.isEmpty();

    }
}
