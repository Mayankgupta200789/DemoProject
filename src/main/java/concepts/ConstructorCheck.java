package concepts;

public class ConstructorCheck {

    public ConstructorCheck(String hello){

    }

    public static void main(String[] args) {
        try {
            System.exit(0);
        }catch (Exception e ) {

        } finally {
            System.out.println("finally executed");
        }
    }
}
