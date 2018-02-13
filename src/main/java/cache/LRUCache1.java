package cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache1 {

    private int capacity;
    private Map<Integer,Integer> cache = new HashMap<>();
    private List<Integer> accessList = new ArrayList<>();
    private int count=0;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
    }

    /*
    list with keys
    list with key and value
    */

    public int get(int key) {

        if(cache.containsKey(key)) {
            removeElement(key);
            int val = cache.get(key);
            addInFront(key,val);
            return val;
        } else {
            return -1;
        }


    }

    public void set(int key, int value) {

        if(!cache.containsKey(key)) {

            if( count < capacity ) {
                addInFront(key,value);
            } else {

                removeLast();
                addInFront(key,value);

            }

        } else {
            removeElement(key);
            addInFront(key,value);
        }

        cache.put(key,value);

    }

    private void removeElement(int no){
        int index = accessList.indexOf(no);
        accessList.remove(index);
        count--;
    }

    private void addInFront(int key,int no){
       accessList.add(0,key);
       cache.put(key,no);
       count++;
    }

    private void removeLast(){
        int key = accessList.indexOf(accessList.size() - 1);
        accessList.remove(accessList.size() - 1);
        cache.remove(key);
        count--;
    }
}
