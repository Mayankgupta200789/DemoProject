package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Mayank Gupta
 * @Date 12/15/17
 */
public class ArrayListIterator {

    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6,13);
        List<Integer> list3 = Arrays.asList(7,8,9,10,11,12);

        List<List<Integer>> list = new ArrayList<>();

        list.add(list1);
        list.add(list2);
        list.add(list3);

        RoundRobinIterator roundRobinIterator = new RoundRobinIterator(list);

        while (roundRobinIterator.hasNext()) {

            System.out.println(roundRobinIterator.next());
        }
    }
}
