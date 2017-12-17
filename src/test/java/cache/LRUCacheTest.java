package cache;

import org.junit.Test;

/**
 * @Author Mayank Gupta
 * @Date 11/16/17
 */
public class LRUCacheTest {


    @Test
    public void test(){


//[[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],

// ,[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],
// [7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],
// [5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],
// [12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],
// [3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],
// [1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],
// [4,22],[7,24],[9,26],[13,28],[11,26]]
        LRUCache lruCache = new LRUCache(10);
// [9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10]
        lruCache.put(10,13);
        lruCache.put(3,17);
        lruCache.put(6,11);
        lruCache.put(10,5);
        lruCache.put(9,10);
        lruCache.get(13);
        lruCache.put(2,19);
        lruCache.get(2);
        lruCache.get(3);
        lruCache.put(5,25);
        lruCache.get(8);
        lruCache.put(9,22);
        lruCache.put(5,5);
        lruCache.put(1,30);
        lruCache.get(11);
        lruCache.put(9,12);
        lruCache.get(7);
        lruCache.get(5);
        lruCache.get(8);
        lruCache.get(9);
        lruCache.put(4,30);lruCache.put(9,3);lruCache.get(9);lruCache.get(10);lruCache.get(10);


    }

}