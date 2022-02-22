package java8;

import java.util.Arrays;
import java.util.List;

public class TerminalVsNonTerminal {

    public static void main(String[] args) {

        System.out.println("Intermediate Operation won't execute");
        Arrays.stream(new int[] { 0, 1 }).map(i -> {
            System.out.println(i);
            return i;
            // No terminal operation so it won't execute
        });

        System.out.println("Terminal operation starts here");
        Arrays.stream(new int[] { 0, 1 }).map(i -> {
            System.out.println(i);
            return i;
            // This is followed by terminal operation sum()
        }).sum();

        Arrays.stream(new int[]{0,1}).map(i -> i*i).filter(n -> n > 100).average();


    }
}
