package palindrome;

/**
 * @Author Mayank Gupta
 * @Date 9/27/17
 */
public class IntegerPalindrome {

    public boolean isPalindrome(int x) {

        long input = x;
        long power = -1;
        long reverse = 0;
        long lastDigit = 0;
        long remainingDigits = 0;

        while( input != 0  ) {

            input = input / 10;
            power += 1;
        }

        input = x;

        while( input != 0 ) {

            remainingDigits = input / 10;
            lastDigit = input % 10;
            input = remainingDigits;

            reverse += lastDigit * Math.pow(10,power--);
        }

        if( x >= 0 &&  x == reverse ) {
            return true;
        } else {
            return false;
        }


    }
}
