package java8;

/**
 * @Author Mayank Gupta
 * @Date 10/15/17
 */
public class Test {

    public static void main(String[] args) {
        final String input = "test";

        input.chars().forEach(System.out::println);
    }
}
