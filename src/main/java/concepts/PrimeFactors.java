package concepts;

/**
 * @Author Mayank Gupta
 * @Date 12/14/17
 */
public class PrimeFactors {

    public static void main(String[] args) {
        PrimeFactors primeFactors = new PrimeFactors();


        primeFactors.primeFactors(11);
    }


    public void primeFactors(int n ) {

        while( n % 2 == 0 ) {
            System.out.print(2 + " ");
            n /= 2;
        }

        for( int i = 3; i <= Math.sqrt(n); i=i+2 ) {

            if( n % i == 0 ) {

                System.out.print(i + " ");
                n /= i;

            }

        }

        if( n > 2 ) {
            System.out.print(n);
        }



    }
}
