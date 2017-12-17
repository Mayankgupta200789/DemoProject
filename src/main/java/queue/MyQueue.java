package queue;

/**
 * @Author Mayank Gupta
 * @Date 8/24/17
 */
public class MyQueue<I> {

    private Node<I> node;

    private Node<I> front;

    private int size;


    public MyQueue() {
        this.front = node;
    }

    public void add(I e) {

        if( node == null ) {
            node = new Node<>(e);
            front = node;
        } else {
            node.next = new Node<>(e);
            node = node.next;
        }
        size++;
    }

    public I remove() {

        if( size <= 0 ) {
            throw new IllegalArgumentException("Cannot remove, size is less than empty");
        }

        I element = front.val;

        front = front.next;

        size--;

        return element;
    }

    public I peek() {

        if( size <= 0 ) {
            throw new IllegalArgumentException("Cannot remove, size is less than empty");
        }

        return front.val;
    }

    public int size() {
        return size;
    }

    class Node<I> {

         I val;

         Node<I> next;

        Node(I val) {
            this.val = val;
        }
    }
}
