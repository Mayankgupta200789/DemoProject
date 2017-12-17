package java8;

/**
 * @Author Mayank Gupta
 * @Date 10/15/17
 */
public interface Defaultable {

    default String notRequired() {
        return "Default implementation";
    }
}
