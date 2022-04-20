package companies.Convoy.cache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        int key;
        int value;
        Node previous;
        Node next;

    }
    Map<Integer,Node> nodeMap = new HashMap<>();
    Node head = new Node();
    Node tail = new Node();
    int capacity;

    public LRUCache(int capacity) {
        head.next = tail;
        tail.previous = head;
        this.capacity = capacity;
    }

    public void add(Node node) {
        Node headNext = head.next;
        node.next = headNext;
        node.previous = head;

        headNext.previous = node;
        head.next = node;

    }

    public void remove(Node node) {

        Node nodeNext = node.next;
        Node nodePrevious = node.previous;

        nodePrevious.next = nodeNext;
        nodeNext.previous = nodePrevious;

    }

    public int get(int key) {

        int result = -1;

        Node node = nodeMap.get(key);

        if(node != null ) {
            remove(node);
            add(node);
            result = node.value;
        }
        return result;
    }

    public void put(int key, int value ) {

        Node node = nodeMap.get(key);

        if(node != null ) {

            remove(node);
            add(node);
            node.value = value;
        } else {
            if(nodeMap.size() == capacity ) {
                nodeMap.remove(tail.previous.key);
                remove(tail.previous);
            }

            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            nodeMap.put(key,newNode);
            add(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */