package array;

/**
 * @Author Mayank Gupta
 * @Date 9/19/17
 */
public class PrimeNumber {

    public boolean checkPrime(int a) {

        int sqrt = (int) Math.floor(Math.sqrt(a));

        if( a == 0 || a ==  1) {
            return false;
        }


        for(int i = 2; i <= sqrt; i++ ) {

            if( a % i == 0 ) {
                return false;
            }

        }

        return true;


    }
}
