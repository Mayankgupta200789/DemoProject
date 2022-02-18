package singleton;

/**
 * The instance is wrapped inside the class
 *
 * The variable instance is utilized in static inner class
 * utilizing class loader to do synchronization
 * the class loader guarantees to complete all static
 * initialization before it grants access to the class.
 * This implementation lazy initializes the instance
 * by calling Singleton.INSTANCE
 *
 *
 *
 * @Author Mayank Gupta
 * @Date 9/8/17
 */
public class Singleton {

    private static class SingletonClassHolder {

        private static final Singleton instance = new Singleton();
    }

    private Singleton() {

    }

    public static Singleton getInstance() {
        return SingletonClassHolder.instance;
    }

}
