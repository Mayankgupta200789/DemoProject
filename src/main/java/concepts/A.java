package concepts;

/**
 * @Author Mayank Gupta
 * @Date 12/7/16
 */
public class A {

    public void print() {
        System.out.println( " A object");
    }

    public void print(int a) {
        System.out.println( " A int object");
    }



    public static void main(String args[]) {

        C a = new C();
        B b = new B();
//        C c = new C();

        A d = new C();

        d.print(); // C object

        a.print(2); // B int object

    }
}

class B extends A {

    public void print() {
        System.out.println( " B object");
    }

    public void print(int a) {
        System.out.println( " B int object");
    }
}

class C extends B{

    public void print() {
        System.out.println( " C object");
    }

    public void printOnlyC() {
        System.out.println("Only C object method");
    }

}
