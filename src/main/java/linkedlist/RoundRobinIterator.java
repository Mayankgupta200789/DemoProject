package linkedlist;

import java.util.Iterator;
import java.util.List;

/**
 * @Author Mayank Gupta
 * @Date 12/15/17
 */
public class RoundRobinIterator implements Iterator<Integer> {

    private int i  = -1;
    private int j = 0;
    private int size;

    private List<List<Integer>> list;

    public RoundRobinIterator(List<List<Integer>> list) {
        this.list = list;
        this.size = list.size();
    }

    @Override
    public boolean hasNext() {
        if( i == (size - 1) && j == (list.get(i).size() - 1) ) return false;

        if( i == (size - 1)  ) {
            i = 0;
            j++;
        } else {
            i++;
        }

       boolean flag = false;

        while( !flag ) {
            try {
                list.get(i).get(j);
                flag = true;
            } catch (Exception e) {
                i++;
            }
        }

        return true;
    }

    @Override
    public Integer next() {

        List<Integer> temp = list.get(i);

        return temp.get(j);
    }
}
