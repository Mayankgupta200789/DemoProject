package cache;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author Mayank Gupta
 * @Date 11/16/17
 */
public class LRUCache {

    private int capacity;

    private Map<Integer,Integer> cache = new ConcurrentHashMap<>();

    private Queue<Integer> keyQueue = new ConcurrentLinkedQueue<>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private Lock readLock = readWriteLock.readLock();

    private Lock writeLock = readWriteLock.writeLock();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        int value;
        try {
            readLock.lock();
            if (cache.get(key) == null) {
                return -1;
            } else {
                keyQueue.remove(key);
                keyQueue.add(key);
                value = cache.get(key);
            }
        } finally {
            readLock.unlock();
        }
        return value;
    }

    public void put(int key, int value) {


        try {
            writeLock.lock();
            if (keyQueue.size() < capacity) {
                if (cache.get(key) == null) {
                    keyQueue.add(key);
                } else {
                    keyQueue.remove(key);
                    keyQueue.add(key);
                }
                cache.put(key, value);
            } else if (cache.get(key) == null) {
                Integer keyToBeRemoved = keyQueue.remove();
                cache.remove(keyToBeRemoved);
                keyQueue.add(key);
                cache.put(key, value);
            } else {
                keyQueue.remove(key);
                keyQueue.add(key);
                cache.put(key, value);
            }
        } finally {
            writeLock.unlock();
        }

    }
}
