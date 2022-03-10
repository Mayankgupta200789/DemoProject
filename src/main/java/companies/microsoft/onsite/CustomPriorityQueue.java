package companies.microsoft.onsite;


import java.util.*;

public class CustomPriorityQueue {


    private int capacity;
    private Queue<Integer> queue = new LinkedList<Integer>();
    private boolean order = true;


    public CustomPriorityQueue() {
        this.capacity = 10;
    }

    public CustomPriorityQueue(int capacity){

        this.capacity = capacity;
    }

    public CustomPriorityQueue(boolean ascending){
        this.order = ascending;
    }

    public void add(int a ) {
        List<Integer> list = new LinkedList<>();
        if(queue.isEmpty() )    queue.add(a);
        else {
            if(order) {
                while (queue.peek() != null && queue.peek() >= a) {
                    list.add(queue.remove());
                }
                queue.add(a);

                queue.addAll(list);
            } else {
                while (queue.peek() != null && queue.peek() < a) {
                    list.add(queue.remove());
                }
                queue.add(a);

                queue.addAll(list);
            }
        }
    }

    public Integer peek() {
        return  queue.isEmpty() ? null : queue.peek();
    }

    public void remove(){
        queue.poll();
    }
}
