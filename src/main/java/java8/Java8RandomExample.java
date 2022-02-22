package java8;

import java.util.Random;

public class Java8RandomExample {

    public static void main(String[] args) {
        Random random = new Random();

        random.ints().limit(5).forEach(System.out::println);
        random.ints().limit(5).sorted().forEach(System.out::println);
    }
}
