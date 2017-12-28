package stack;

import java.util.PriorityQueue;

/**
 * @Author Mayank Gupta
 * @Date 12/23/17
 */
public class MyMinStack<Integer> {

    private Node<Integer> node;

    private static final int DEFAULT_CAPACITY = 1 << 4;

    private PriorityQueue<Integer> priorityQueue;

    private int capacity;

    private int size;

    public MyMinStack(int capacity) {
        this.capacity = capacity;
    }

    public MyMinStack() {
        this.capacity = DEFAULT_CAPACITY;
    }

    public void push(Integer input) {

        if( size == capacity ) {
            throw new StackOverflowError();
        }

        if (node == null) {

            node = new Node<Integer>(input);


        } else {
            node.next = new Node<Integer>(input);
            Node<Integer> currentNode = node;
            node = node.next;
            node.previous = currentNode;
        }

        priorityQueue.add(input);
        size++;
    }

    public Integer pop() {

        if( size == 0 ) {
            throw new IllegalArgumentException("Cannot remove as size is zero");
        }

        if( node == null ) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Integer output = node.input;

        node = node.previous;
        priorityQueue.remove(output);
        size--;
        return output;

    }

    public Integer peek() {

        if( size == 0 ) {
            throw new IllegalArgumentException("Cannot remove as size is zero");
        }

        return node.input;

    }

    public Integer getMin() {

        return priorityQueue.peek();
    }




    class Node<I> {

        private I input;

        private Node<I> next;

        private Node<I> previous;

        public Node(I input) {
            this.input = input;
        }
    }
}
