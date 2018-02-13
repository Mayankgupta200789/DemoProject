package cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 {


    private Map<Integer,Integer> cache;

    public LRUCache2(int capacity) {


        cache= new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){
            public boolean removeEldestEntry(Map.Entry eldest){
                return size()> capacity;
            }
        };
    }

    public int get(int key ) {
        return cache.getOrDefault(key,-1);
    }


    public void set(int key, int val ) {

        cache.put(key,val);
    }







}
