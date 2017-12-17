package singleton;

/**
 * @Author Mayank Gupta
 * @Date 11/7/17
 */
public class Singleton2 {

    private static final Singleton2 instance = new Singleton2();

    private Singleton2(){

    }

    public static Singleton2 getInstance() {
        return instance;
    }
}
