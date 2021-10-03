package array;

public class CheckIfANumberIsPrime {

    public boolean checkPrime(int n ) {


         int result = (int)Math.ceil(Math.sqrt(n));

         for(int i = 2 ; i <= result; i++ ) {

             if(n % i == 0 ) {
                 return false;
             }
         }

         return true;



    }
}
