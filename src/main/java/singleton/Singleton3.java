package singleton;

/**
 *
 * By default, enum instance is thread safe and we don't need to worry about double-checked locking
 * In Summary, the Singleton pattern is the best way to create Singleton in Java 5 world.
 *
 *
 * Disadvantage of Enum
 *
 * 1) Static field in constructor cannot be accessed.
 * 2) Enum classes are not serializable
 *
 * @Author Mayank Gupta
 * @Date 11/7/17
 */
public enum Singleton3 {

    INSTANCE;
}
