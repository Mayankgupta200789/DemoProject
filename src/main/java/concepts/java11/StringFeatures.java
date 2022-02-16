package concepts.java11;

public class StringFeatures {

    public static void main(String[] args) {


        String hello = " first ";

        // Returns true if the String is empty or contains only spaces
        System.out.println(hello.isBlank());
        // Returns a stream of lines extracted from the strin separated by line terminators such as \n \r
        System.out.println(hello.lines());

        // strip whitespaces from start and end
        System.out.println(hello.strip());

        // strip whitespaces from start
        System.out.println(hello.stripLeading());

        // strip whiltespaces from end
        System.out.println(hello.stripTrailing());

        // repeat this string n number of times
        System.out.println(hello.repeat(4));
    }
}
