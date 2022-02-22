package java8;

public interface Java8Interface {

    default void print() {
        System.out.println("hello world");
    }

    static void printZ() {
        System.out.println("static print from interface");
    }

    void printX();
}

class Java8InterfaceImplementation implements Java8Interface {


    @Override
    public void printX() {
        System.out.println("print from implemented class");
    }
}

class Java8MainClass {

    public static void main(String[] args) {

        Java8Interface.printZ();
        new Java8InterfaceImplementation().printX();
    }
}




