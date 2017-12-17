package queue;

import java.util.*;

/**
 * @Author Mayank Gupta
 * @Date 11/1/17
 */
public class TreeSetReverseOrder {


    public static void main (String args[]) {

        int[] inputs = new int[]{1,2,2,3,4,4};

        System.out.println("Enter the kth value for smallest");
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();

        Set<Integer> treeSet = new TreeSet<>();

        for(int i = 0 ; i < inputs.length; i++ ) {

            treeSet.add(inputs[i]);

        }

        int count = 1;

        for(Integer value : treeSet) {

            if( count == k ) {
                System.out.println(value);
                break;
            }
            count++;
        }


        if( count < k || count > k  ) {
            System.out.println("No " + k + "th value");
        }

    }


}
