package cache;

import java.util.*;

/**
 * @Author Mayank Gupta
 * @Date 11/29/17
 */
public class LFUCache {


    private int capacity;

    private Map<Integer,Item> freq = new LinkedHashMap<>();
//
    private Map<Integer,Integer> cache = new HashMap<>();


    private PriorityQueue<Item> items = new PriorityQueue<>((o1, o2) -> {

        int result = 0;

        result = Integer.compare(o1.freq, o2.freq);

        return result;
    });

    public static void main(String[] args) {

        LFUCache cache = new LFUCache(10);

        cache.put(10,13);
        cache.put(3,17);
        cache.put(6,11);
        cache.put(10,5);
        cache.put(9,10);
        cache.get(13);
        cache.put(2,19);
        cache.get(2);
        cache.get(3);
        cache.put(5,25);
        cache.get(8);
        cache.put(9,22);
        cache.put(5,5);
        cache.put(1,30);
        cache.get(11);
        cache.put(9,12);
        cache.get(7);
        cache.get(5);
        cache.get(8);
        cache.get(9);
        cache.put(4,30);
        cache.put(9,3);
        cache.get(9);
        cache.get(10);
        cache.get(10);
        cache.put(6,14);
        cache.put(3,1);
        cache.get(3);
        cache.put(10,11);
        cache.get(8);
        cache.put(2,14);
        cache.get(1);
        cache.get(5);
        cache.get(4);
        cache.put(11,4);
        cache.put(12,24);
        cache.put(5,18);
        cache.get(13);
        cache.put(7,23);
        cache.get(8);
        cache.get(12);
        cache.put(3,27);
        cache.put(2,12);
        cache.get(5);
        cache.put(2,9);
        cache.put(13,4);
        cache.put(8,18);
        cache.put(1,7);
        cache.get(6);
        cache.put(9,19);
        cache.put(8,21);
        cache.get(5);
        cache.put(6,30);
        cache.put(1,12);
        cache.get(10);
        cache.put(4,15);
        cache.put(7,22);
        cache.put(11,26);
        cache.put(8,17);
        cache.put(9,29);
        cache.get(5);
        cache.put(3,4);
        cache.put(11,30);
        cache.get(12);
        cache.put(4,29);
        cache.get(3);
        cache.get(9);
        cache.get(6);
        cache.put(3,4);
        cache.get(1);
        cache.get(10);
        cache.put(3,29);
        cache.put(10,28);
        cache.put(1,20);
        cache.put(11,13);
        cache.get(3);
        cache.put(3,12);
        cache.put(3,8);
        cache.put(10,9);
        cache.put(3,26);
        cache.get(8);
        cache.get(7);
        cache.get(5);
        cache.put(13,17);
        cache.put(2,27);
        cache.put(11,15);
        cache.get(12);
        cache.put(9,19);
        cache.put(2,15);
        cache.put(3,16);
        cache.get(1);
        cache.put(12,17);
        cache.put(9,1);
        cache.put(6,19);
        cache.get(4);
        cache.get(5);
        cache.get(5);
        cache.put(8,1);
        cache.put(11,7);
        cache.put(5,2);
        cache.put(9,28);
        cache.get(1);
        cache.put(2,2);
        cache.put(7,4);
        cache.put(4,22);
        cache.put(7,24);
        cache.put(9,26);
        cache.put(13,28);
        cache.put(11,28);




    }


    public LFUCache(int capacity) {

        this.capacity = capacity;
    }

    public int get(int key ) {

        if( cache.get(key) != null ) {
            int value = cache.get(key);
            incrementFreqCount(key,value);
            return cache.get(key);
        } else {
            return -1;
        }

    }

    public void put(int key, int value ) {

        if( capacity == 0 ) {
            return;
        }

        if( capacity == freq.size() && !freq.containsKey(key) ) {
            deleteLFU();
        }

        incrementFreqCount( key, value );
        cache.put(key,value);


    }

    public void incrementFreqCount(int key, int value ) {

        if( freq.containsKey(key) ) {

            Item item = freq.get(key);
            int freqValue = item.freq;
            int newfreq = ++freqValue;
            Item newitem = new Item(value, newfreq);
            items.add(newitem);
            this.freq.put(key, newitem);
        } else {

            Item newItem = new Item(value, 1);
            freq.put(key, newItem);
            items.add(newItem);
        }

    }

    public void deleteLFU() {

        int min = Integer.MAX_VALUE;
        int minKey = 0;

        if( !freq.isEmpty()) {
            for(Map.Entry<Integer,Item> entry : freq.entrySet()) {

                if (min > entry.getValue().freq) {

                    min = entry.getValue().freq;
                    minKey = entry.getKey();
                }
            }
            freq.remove(minKey);
            cache.remove(minKey);
        }
    }

    class Item {
        int key;
        int freq;

        public Item(int value, int freq ) {
            this.key = value;
            this.freq = freq;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Item item = (Item) o;

            if( key != item.key) return false;
            return freq == item.freq;

        }

        @Override
        public int hashCode() {

            int result = key;
            result = 31 * result + freq;
            return result;
        }
    }
}
