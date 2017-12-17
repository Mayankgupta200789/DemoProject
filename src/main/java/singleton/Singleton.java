package singleton;

/**
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
