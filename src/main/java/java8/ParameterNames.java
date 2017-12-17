package java8;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @Author Mayank Gupta
 * @Date 10/15/17
 */
public class ParameterNames {

    public static void main(String[] args ) throws Exception {
        Method method = ParameterNames.class.getMethod("main", String[].class);
        for(final Parameter parameter : method.getParameters()) {
            System.out.println("Parameter: " +parameter.getName());

        }
    }
}
