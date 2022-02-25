package companies.marketaxxess;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Author Mayank Gupta
 * @Date 11/16/17
 */
public class LRUCache {

    private int capacity;

    private Map<Integer,Integer> cache = new HashMap<>();

    private Queue<Integer> keyQueue = new LinkedList<>();

    LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        synchronized (keyQueue) {
            if (cache.get(key) == null) {
                return -1;
            } else {
                keyQueue.remove(key);
                keyQueue.add(key);
                return cache.get(key);
            }
        }
    }

    public void put(int key, int value) {

        if(keyQueue.size() < capacity ) {
            if( cache.get(key) == null) {
                keyQueue.add(key);
            } else {
                keyQueue.remove(key);
                keyQueue.add(key);
            }
            cache.put(key,value);
        } else if( cache.get(key) == null ) {
            Integer keyToBeRemoved = keyQueue.remove();
            cache.remove(keyToBeRemoved);
            keyQueue.add(key);
            cache.put(key,value);
        } else {
            keyQueue.remove(key);
            keyQueue.add(key);
            cache.put(key,value);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */