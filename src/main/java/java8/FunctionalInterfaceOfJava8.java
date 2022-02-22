package java8;

/**
 * Functional Interface should only have
 * one and only 1 abstract method
 * It can have any numbers of default methods
 *
 * Interfaces like Runnable and Comparable are
 * all functional interface
 *
 * Predicate
 * public interface Predicate {
 * 	public boolean test(T t);
 * }
 *
 * BinaryOperator
 *
 * public interface BinaryOperator {
 * 	public T apply (T x, T y);
 * }
 *
 * The main benefit of functional interface is it can use
 * lambda expression to instantiate.
 *
 *
 *
 */


// FUNCTIONAL INTERFACE IS ALSO CALLED AS SINGLE INTERFACE
@FunctionalInterface
public interface FunctionalInterfaceOfJava8 {

    void print();

    default void print1() {
        System.out.println("Hello world");
    }

    default void print2() {
        System.out.println("Hello world");
    }


}

class MainClass {

    public static void main(String[] args) {

        FunctionalInterfaceOfJava8 functionalInterfaceOfJava8 = () -> System.out.println("Instantiate java 8 functional interface");

    }
}
